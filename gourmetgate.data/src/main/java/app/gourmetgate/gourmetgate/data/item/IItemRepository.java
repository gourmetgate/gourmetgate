package app.gourmetgate.gourmetgate.data.item;

import app.gourmetgate.gourmetgate.data.common.IEntityRepository;
import app.gourmetgate.gourmetgate.data.query.ItemRestrictionDo;

import java.util.UUID;
import java.util.stream.Stream;

public interface IItemRepository extends IEntityRepository<ItemDo> {

  Stream<ItemDo> list(ItemRestrictionDo restriction);

  void replaceCategory(UUID oldId, UUID replacementId);
}
