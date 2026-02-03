package app.gourmetgate.gourmetgate.core.variant;

import app.gourmetgate.gourmetgate.core.common.DoHelper;
import app.gourmetgate.gourmetgate.data.variant.IVariantOptionRepository;
import app.gourmetgate.gourmetgate.data.variant.VariantOptionDo;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.platform.util.LazyValue;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class VariantOptionService implements IService {

  protected LazyValue<DoHelper> helper = new LazyValue<>(DoHelper.class);

  public Map<UUID, List<VariantOptionDo>> getOptionsByVariantIds(List<UUID> variantIds) {
    return BEANS.get(IVariantOptionRepository.class).getByVariantIds(variantIds)
      .collect(Collectors.groupingBy(VariantOptionDo::getVariantId));
  }

  public List<VariantOptionDo> getOptionsByVariantId(UUID variantId) {
    return getOptionsByVariantIds(List.of(variantId)).get(variantId);
  }

  public List<VariantOptionDo> create(List<VariantOptionDo> variantOptions) {
    // permission check

    return variantOptions.stream()
      .peek(this::validateRequiredFields)
      .map(variantOption -> BEANS.get(IVariantOptionRepository.class).create(variantOption))
      .toList();
  }

  public List<VariantOptionDo> update(UUID variantId, List<VariantOptionDo> variantOptions) {
    // permission check required

    Map<UUID, VariantOptionDo> existingOptionsById = BEANS.get(IVariantOptionRepository.class).getByVariantIds(List.of(variantId))
      .collect(Collectors.toMap(VariantOptionDo::getVariantOptionId, Function.identity()));

    // Create or update variant options
    List<VariantOptionDo> newVariantOptions = variantOptions.stream()
      .peek(this::validateRequiredFields)
      .map(variantOption -> {
        if (existingOptionsById.containsKey(variantOption.getVariantOptionId())) {
          BEANS.get(IVariantOptionRepository.class).store(variantOption.getVariantOptionId(), variantOption);
          existingOptionsById.remove(variantOption.getVariantOptionId()); // Option is processed, remove
          return variantOption;
        } else {
          return BEANS.get(IVariantOptionRepository.class).create(variantOption);
        }
      })
      .toList();

    // Delete remaining options
    existingOptionsById.values().stream()
      .map(VariantOptionDo::getVariantOptionId)
      .forEach(id -> BEANS.get(IVariantOptionRepository.class).delete(id));

    return newVariantOptions;
  }

  public void deleteByVariantId(UUID variantId) {
    // Permission check

    BEANS.get(IVariantOptionRepository.class).deleteByVariantId(variantId);
  }

  protected void validateRequiredFields(VariantOptionDo variantOption) {
    helper.get().validateRequiredProperty(variantOption.variantId());
    helper.get().validateRequiredProperty(variantOption.name());
    helper.get().validateRequiredProperty(variantOption.additionalPrice());
  }
}
