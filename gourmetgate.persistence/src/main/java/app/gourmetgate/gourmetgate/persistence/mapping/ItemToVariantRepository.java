package app.gourmetgate.gourmetgate.persistence.mapping;

import app.gourmetgate.gourmetgate.data.mapping.IItemToVariantRepository;
import app.gourmetgate.gourmetgate.data.mapping.ItemToVariantDo;
import app.gourmetgate.gourmetgate.persistence.common.AbstractMappingRepository;
import app.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import app.gourmetgate.gourmetgate.persistence.tables.ItemToVariant;
import app.gourmetgate.gourmetgate.persistence.tables.records.ItemToVariantRecord;
import org.eclipse.scout.rt.platform.BEANS;
import org.jooq.Field;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class ItemToVariantRepository extends AbstractMappingRepository<ItemToVariant, ItemToVariantRecord, ItemToVariantDo> implements IItemToVariantRepository {

  @Override
  public ItemToVariant getTable() {
    return ItemToVariant.ITEM_TO_VARIANT;
  }

  @Override
  public Field<UUID> getIdAColumn() {
    return getTable().ITEM_ID;
  }

  @Override
  public Field<UUID> getIdBColumn() {
    return getTable().VARIANT_ID;
  }

  public Stream<ItemToVariantDo> getByItemId(UUID itemId) {
    return getByIdA(itemId);
  }

  public Stream<ItemToVariantDo> getByVariantId(UUID variantId) {
    return getByIdB(variantId);
  }

  @Override
  public Stream<ItemToVariantDo> getByItemIds(List<UUID> itemIds) {
    return getBy(getIdAColumn().in(itemIds));
  }

  @Override
  public Stream<ItemToVariantDo> getByVariantIds(List<UUID> variantIds) {
    return getBy(getIdBColumn().in(variantIds));
  }

  public void replaceByItemId(UUID itemId, List<UUID> variantIds) {
    replaceByIdA(itemId, variantIds);
  }

  public void replaceByVariantId(UUID variantId, List<UUID> itemIds) {
    replaceByIdB(variantId, itemIds);
  }

  @Override
  public void deleteByItemId(UUID itemId) {
    deleteByIdA(itemId);
  }

  @Override
  public void deleteByVariantId(UUID variantId) {
    deleteByIdB(variantId);
  }

  @Override
  protected ItemToVariantRecord toNewRecord(ItemToVariantDo sourceDo) {
    return fromDoToRecord(sourceDo, new ItemToVariantRecord());
  }

  @Override
  protected ItemToVariantDo toNewDo(ItemToVariantRecord sourceRecord) {
    return fromRecordToDo(sourceRecord, BEANS.get(ItemToVariantDo.class));
  }

  @Override
  protected DoEntityBeanMappings<ItemToVariantDo, ItemToVariantRecord> mappings() {
    return new DoEntityBeanMappings<ItemToVariantDo, ItemToVariantRecord>()
      .with(ItemToVariantDo::itemId, ItemToVariantRecord::getItemId, ItemToVariantRecord::setItemId)
      .with(ItemToVariantDo::variantId, ItemToVariantRecord::getVariantId, ItemToVariantRecord::setVariantId);
  }
}
