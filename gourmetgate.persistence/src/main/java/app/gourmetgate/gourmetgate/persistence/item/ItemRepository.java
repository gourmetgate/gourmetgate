package app.gourmetgate.gourmetgate.persistence.item;

import app.gourmetgate.gourmetgate.data.item.IItemRepository;
import app.gourmetgate.gourmetgate.data.item.ItemPersistenceDo;
import app.gourmetgate.gourmetgate.data.query.ItemRestrictionDo;
import app.gourmetgate.gourmetgate.persistence.common.AbstractEntityRepository;
import app.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import app.gourmetgate.gourmetgate.persistence.tables.Item;
import app.gourmetgate.gourmetgate.persistence.tables.records.ItemRecord;
import org.eclipse.scout.rt.platform.BEANS;
import org.jooq.Field;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static app.gourmetgate.gourmetgate.persistence.JooqSqlService.jooq;
import static org.jooq.impl.DSL.noCondition;

public class ItemRepository extends AbstractEntityRepository<Item, ItemRecord, ItemPersistenceDo> implements IItemRepository {

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
  public Stream<ItemPersistenceDo> list(ItemRestrictionDo restriction) {
    return jooq()
      .selectFrom(getTable())
      .where(
        restriction.categories().exists() ? getTable().CATEGORY_ID.in(restriction.getCategories()) : noCondition(),
        restriction.available().exists() ? getTable().AVAILABLE.eq(restriction.isAvailable()) : noCondition()
      )
      .fetchStream()
      .map(this::toNewDo);
  }

  @Override
  public Stream<ItemPersistenceDo> getItemsByCategory(List<UUID> categoryIds, boolean availableOnly) {
    return jooq()
      .selectFrom(getTable())
      .where(
        getTable().CATEGORY_ID.in(categoryIds),
        availableOnly ? getTable().AVAILABLE.eq(true) : noCondition())
      .fetchStream()
      .map(this::toNewDo);
  }

  @Override
  protected ItemRecord toNewRecord(ItemPersistenceDo sourceDo) {
    return fromDoToRecord(sourceDo, new ItemRecord());
  }

  @Override
  protected ItemPersistenceDo toNewDo(ItemRecord sourceRecord) {
    return fromRecordToDo(sourceRecord, BEANS.get(ItemPersistenceDo.class));
  }

  @Override
  protected DoEntityBeanMappings<ItemPersistenceDo, ItemRecord> mappings() {
    return new DoEntityBeanMappings<ItemPersistenceDo, ItemRecord>()
      .with(ItemPersistenceDo::itemId, ItemRecord::getItemId, ItemRecord::setItemId)
      .with(ItemPersistenceDo::categoryId, ItemRecord::getCategoryId, ItemRecord::setCategoryId)
      .with(ItemPersistenceDo::vatId, ItemRecord::getVatId, ItemRecord::setVatId)
      .with(ItemPersistenceDo::name, ItemRecord::getName, ItemRecord::setName)
      .with(ItemPersistenceDo::price, ItemRecord::getPrice, ItemRecord::setPrice)
      .with(ItemPersistenceDo::cost, ItemRecord::getCost, ItemRecord::setCost)
      .with(ItemPersistenceDo::available, ItemRecord::getAvailable, ItemRecord::setAvailable);
  }
}
