package app.gourmetgate.gourmetgate.data.mapping;

import org.eclipse.scout.rt.platform.ApplicationScoped;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@ApplicationScoped
public interface IItemToVariantRepository {

  Stream<ItemToVariantDo> getByItemId(UUID itemId);

  Stream<ItemToVariantDo> getByVariantId(UUID variantId);

  Stream<ItemToVariantDo> getByItemIds(List<UUID> itemIds);

  Stream<ItemToVariantDo> getByVariantIds(List<UUID> variantIds);

  void replaceByItemId(UUID itemId, List<UUID> variantIds);

  void replaceByVariantId(UUID variantId, List<UUID> itemIds);

  void deleteByItemId(UUID itemId);

  void deleteByVariantId(UUID variantId);
}
