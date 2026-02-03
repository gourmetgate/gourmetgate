package app.gourmetgate.gourmetgate.persistence.variant;

import app.gourmetgate.gourmetgate.data.status.Status;
import app.gourmetgate.gourmetgate.data.variant.IVariantOptionRepository;
import app.gourmetgate.gourmetgate.data.variant.VariantOptionDo;
import app.gourmetgate.gourmetgate.persistence.common.AbstractEntityRepository;
import app.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import app.gourmetgate.gourmetgate.persistence.tables.VariantOption;
import app.gourmetgate.gourmetgate.persistence.tables.records.VariantOptionRecord;
import org.eclipse.scout.rt.platform.BEANS;
import org.jooq.Field;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static app.gourmetgate.gourmetgate.persistence.JooqSqlService.jooq;

public class VariantOptionRepository extends AbstractEntityRepository<VariantOption, VariantOptionRecord, VariantOptionDo> implements IVariantOptionRepository {

  @Override
  public VariantOption getTable() {
    return VariantOption.VARIANT_OPTION;
  }

  @Override
  public Field<UUID> getIdColumn() {
    return getTable().VARIANT_OPTION_ID;
  }

  @Override
  public Field<String> getStatusColumn() {
    return getTable().STATUS;
  }

  @Override
  public Field<OffsetDateTime> getSortColumn() {
    return getTable().SORT_CODE;
  }

  @Override
  public Stream<VariantOptionDo> getByVariantIds(List<UUID> variantIds) {
    return jooq()
      .selectFrom(getTable())
      .where(
        getTable().VARIANT_ID.in(variantIds),
        getStatusColumn().eq(Status.ACTIVE.id))
      .fetchStream()
      .map(this::toNewDo);
  }

  @Override
  public void deleteByVariantId(UUID variantId) {
    jooq()
      .update(getTable())
      .set(getStatusColumn(), Status.DELETED.id)
      .where(getTable().VARIANT_ID.eq(variantId))
      .execute();
  }

  @Override
  protected VariantOptionRecord toNewRecord(VariantOptionDo sourceDo) {
    return fromDoToRecord(sourceDo, new VariantOptionRecord());
  }

  @Override
  protected VariantOptionDo toNewDo(VariantOptionRecord sourceRecord) {
    return fromRecordToDo(sourceRecord, BEANS.get(VariantOptionDo.class));
  }

  @Override
  protected DoEntityBeanMappings<VariantOptionDo, VariantOptionRecord> mappings() {
    return new DoEntityBeanMappings<VariantOptionDo, VariantOptionRecord>()
      .with(VariantOptionDo::variantOptionId, VariantOptionRecord::getVariantOptionId, VariantOptionRecord::setVariantOptionId)
      .with(VariantOptionDo::variantId, VariantOptionRecord::getVariantId, VariantOptionRecord::setVariantId)
      .with(VariantOptionDo::name, VariantOptionRecord::getName, VariantOptionRecord::setName)
      .with(VariantOptionDo::additionalPrice, VariantOptionRecord::getAdditionalPrice, VariantOptionRecord::setAdditionalPrice);
  }
}
