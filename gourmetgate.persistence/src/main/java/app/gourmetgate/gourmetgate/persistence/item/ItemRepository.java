package app.gourmetgate.gourmetgate.persistence.item;

import app.gourmetgate.gourmetgate.data.item.IItemRepository;
import app.gourmetgate.gourmetgate.data.item.ItemDo;
import app.gourmetgate.gourmetgate.data.query.ItemRestrictionDo;
import app.gourmetgate.gourmetgate.data.status.Status;
import app.gourmetgate.gourmetgate.persistence.common.AbstractEntityRepository;
import app.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import app.gourmetgate.gourmetgate.persistence.tables.Item;
import app.gourmetgate.gourmetgate.persistence.tables.records.ItemRecord;
import org.eclipse.scout.rt.platform.BEANS;
import org.jooq.Field;

import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.stream.Stream;

import static app.gourmetgate.gourmetgate.persistence.JooqSqlService.jooq;
import static org.jooq.impl.DSL.noCondition;

public class ItemRepository extends AbstractEntityRepository<Item, ItemRecord, ItemDo> implements IItemRepository {

  @Override
  public Item getTable() {
    return Item.ITEM;
  }

  @Override
  public Field<UUID> getIdColumn() {
    return getTable().ITEM_ID;
  }

  @Override
  public Field<OffsetDateTime> getSortColumn() {
    return getTable().SORT_CODE;
  }

  @Override
  public Field<String> getStatusColumn() {
    return getTable().STATUS;
  }

  @Override
  public Stream<ItemDo> list(ItemRestrictionDo restriction) {
    return jooq()
      .selectFrom(getTable())
      .where(
        restriction.categories().exists() ? getTable().CATEGORY_ID.in(restriction.getCategories()) : noCondition(),
        restriction.available().exists() ? getTable().AVAILABLE.eq(restriction.isAvailable()) : noCondition(),
        getTable().STATUS.eq(Status.ACTIVE.id)
      )
      .fetchStream()
      .map(this::toNewDo);
  }

  @Override
  public void replaceCategory(UUID oldId, UUID replacementId) {
    jooq()
      .update(getTable())
      .set(getTable().CATEGORY_ID, replacementId)
      .where(getTable().CATEGORY_ID.eq(oldId))
      .execute();
  }

  @Override
  protected ItemRecord toNewRecord(ItemDo sourceDo) {
    return fromDoToRecord(sourceDo, new ItemRecord());
  }

  @Override
  protected ItemDo toNewDo(ItemRecord sourceRecord) {
    return fromRecordToDo(sourceRecord, BEANS.get(ItemDo.class));
  }

  @Override
  protected DoEntityBeanMappings<ItemDo, ItemRecord> mappings() {
    return new DoEntityBeanMappings<ItemDo, ItemRecord>()
      .with(ItemDo::itemId, ItemRecord::getItemId, ItemRecord::setItemId)
      .with(ItemDo::categoryId, ItemRecord::getCategoryId, ItemRecord::setCategoryId)
      .with(ItemDo::vatId, ItemRecord::getVatId, ItemRecord::setVatId)
      .with(ItemDo::name, ItemRecord::getName, ItemRecord::setName)
      .with(ItemDo::price, ItemRecord::getPrice, ItemRecord::setPrice)
      .with(ItemDo::cost, ItemRecord::getCost, ItemRecord::setCost)
      .with(ItemDo::available, ItemRecord::getAvailable, ItemRecord::setAvailable);
  }
}
