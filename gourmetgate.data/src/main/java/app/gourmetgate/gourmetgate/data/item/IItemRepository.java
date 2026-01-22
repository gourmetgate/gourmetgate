package app.gourmetgate.gourmetgate.data.item;

import app.gourmetgate.gourmetgate.data.common.IEntityRepository;
import app.gourmetgate.gourmetgate.data.query.ItemRestrictionDo;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public interface IItemRepository extends IEntityRepository<ItemPersistenceDo> {

  Stream<ItemPersistenceDo> list(ItemRestrictionDo restriction);

  Stream<ItemPersistenceDo> getItemsByCategory(List<UUID> categoryIds, boolean availableOnly);
}
