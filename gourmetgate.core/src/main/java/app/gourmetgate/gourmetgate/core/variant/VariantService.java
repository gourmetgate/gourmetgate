package app.gourmetgate.gourmetgate.core.variant;

import app.gourmetgate.gourmetgate.core.common.DoHelper;
import app.gourmetgate.gourmetgate.core.common.EntityNotFoundException;
import app.gourmetgate.gourmetgate.data.mapping.IItemToVariantRepository;
import app.gourmetgate.gourmetgate.data.mapping.ItemToVariantDo;
import app.gourmetgate.gourmetgate.data.query.VariantRestrictionDo;
import app.gourmetgate.gourmetgate.data.variant.IVariantRepository;
import app.gourmetgate.gourmetgate.data.variant.VariantDo;
import app.gourmetgate.gourmetgate.data.variant.VariantOptionDo;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.platform.util.LazyValue;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class VariantService implements IService {

  protected LazyValue<DoHelper> helper = new LazyValue<>(DoHelper.class);

  public List<VariantDo> list(VariantRestrictionDo restriction) {
    List<VariantDo> variants = BEANS.get(IVariantRepository.class).list(restriction)
      .toList();
    List<UUID> variantIds = variants.stream().map(VariantDo::getVariantId).toList();

    Map<UUID, List<VariantOptionDo>> variantOptions = BEANS.get(VariantOptionService.class).getOptionsByVariantIds(variantIds);
    Map<UUID, List<UUID>> itemMappings = BEANS.get(IItemToVariantRepository.class).getByVariantIds(variantIds)
      .collect(Collectors.groupingBy(ItemToVariantDo::getVariantId, Collectors.mapping(ItemToVariantDo::getItemId, Collectors.toList())));

    return variants.stream()
      .map(variant -> variant.withVariantOptions(variantOptions.get(variant.getVariantId())))
      .map(variant -> variant.withItemIds(itemMappings.get(variant.getVariantId())))
      .toList();
  }

  public VariantDo getById(UUID id) {
    // Permission check required

    VariantDo variant = BEANS.get(IVariantRepository.class).getById(id)
      .orElseThrow(() -> new EntityNotFoundException("Variant", id));

    variant.withVariantOptions(BEANS.get(VariantOptionService.class)
      .getOptionsByVariantId(variant.getVariantId()));
    variant.withItemIds(BEANS.get(IItemToVariantRepository.class)
      .getByVariantId(variant.getVariantId()).map(ItemToVariantDo::getItemId).toList());

    return variant;
  }

  public VariantDo create(VariantDo variant) {
    // Permission check required
    helper.get().validateRequiredProperty(variant.name());
    helper.get().validateRequiredProperty(variant.singleOption());
    helper.get().validateRequiredProperty(variant.variantOptions());

    VariantDo newVariant = BEANS.get(IVariantRepository.class).create(variant);
    newVariant.getVariantOptions().forEach(option -> option.withVariantId(newVariant.getVariantId()));
    newVariant.withVariantOptions(BEANS.get(VariantOptionService.class).create(newVariant.getVariantOptions()));
    BEANS.get(IItemToVariantRepository.class).replaceByVariantId(newVariant.getVariantId(), newVariant.getItemIds());
    return newVariant;
  }

  public VariantDo update(UUID id, VariantDo variant) {
    // Permission check required
    helper.get().validateRequiredProperty(variant.variantId());
    helper.get().validateRequiredProperty(variant.name());
    helper.get().validateRequiredProperty(variant.singleOption());
    helper.get().validateRequiredProperty(variant.variantOptions());
    helper.get().validateSameId(id, variant.variantId());

    int affectedRows = BEANS.get(IVariantRepository.class).store(id, variant);
    if (affectedRows != 1) {
      throw new EntityNotFoundException("Variant", id);
    }

    variant.withVariantOptions(BEANS.get(VariantOptionService.class).update(variant.getVariantId(), variant.getVariantOptions()));
    BEANS.get(IItemToVariantRepository.class).replaceByVariantId(variant.getVariantId(), variant.getItemIds());
    return variant;
  }

  public void delete(UUID id) {
    // Check permissions

    int affectedRows = BEANS.get(IVariantRepository.class).delete(id);
    if (affectedRows != 1) {
      throw new EntityNotFoundException("Variant", id);
    }

    BEANS.get(VariantOptionService.class).deleteByVariantId(id);
    BEANS.get(IItemToVariantRepository.class).deleteByVariantId(id);
  }
}
