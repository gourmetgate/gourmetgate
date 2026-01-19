package app.gourmetgate.gourmetgate.persistence.vat;

import app.gourmetgate.gourmetgate.data.vat.IVatRepository;
import app.gourmetgate.gourmetgate.data.vat.VatDo;
import app.gourmetgate.gourmetgate.persistence.common.AbstractEntityRepository;
import app.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import app.gourmetgate.gourmetgate.persistence.tables.Item;
import app.gourmetgate.gourmetgate.persistence.tables.Vat;
import app.gourmetgate.gourmetgate.persistence.tables.records.VatRecord;
import org.eclipse.scout.rt.platform.BEANS;
import org.jooq.Field;
import org.jooq.Record4;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static app.gourmetgate.gourmetgate.persistence.JooqSqlService.jooq;

public class VatRepository extends AbstractEntityRepository<Vat, VatRecord, VatDo> implements IVatRepository {

  @Override
  public Vat getTable() {
    return Vat.VAT;
  }

  @Override
  public Field<UUID> getIdColumn() {
    return getTable().VAT_ID;
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
  public Map<UUID, VatDo> getVatByItemId(List<UUID> itemIds) {
    return jooq()
      .select(
        Item.ITEM.ITEM_ID,
        getTable().VAT_ID,
        getTable().PERCENTAGE,
        getTable().DESCRIPTION)
      .from(getTable())
      .join(Item.ITEM).on(Item.ITEM.VAT_ID.eq(getIdColumn()))
      .where(Item.ITEM.ITEM_ID.in(itemIds))
      .fetchStream()
      .collect(Collectors.toMap(Record4::value1,
        tuple -> BEANS.get(VatDo.class)
          .withVatId(tuple.value2())
          .withPercentage(tuple.value3())
          .withDescription(tuple.value4())));
  }

  @Override
  protected VatRecord toNewRecord(VatDo sourceDo) {
    return fromDoToRecord(sourceDo, new VatRecord());
  }

  @Override
  protected VatDo toNewDo(VatRecord sourceRecord) {
    return fromRecordToDo(sourceRecord, BEANS.get(VatDo.class));
  }

  @Override
  protected DoEntityBeanMappings<VatDo, VatRecord> mappings() {
    return new DoEntityBeanMappings<VatDo, VatRecord>()
      .with(VatDo::vatId, VatRecord::getVatId, VatRecord::setVatId)
      .with(VatDo::percentage, VatRecord::getPercentage, VatRecord::setPercentage)
      .with(VatDo::description, VatRecord::getDescription, VatRecord::setDescription);
  }
}
