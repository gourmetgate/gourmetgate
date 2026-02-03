package app.gourmetgate.gourmetgate.persistence.variant;

import app.gourmetgate.gourmetgate.data.variant.IVariantRepository;
import app.gourmetgate.gourmetgate.data.variant.VariantDo;
import app.gourmetgate.gourmetgate.persistence.common.AbstractEntityRepository;
import app.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import app.gourmetgate.gourmetgate.persistence.tables.Variant;
import app.gourmetgate.gourmetgate.persistence.tables.records.VariantRecord;
import org.eclipse.scout.rt.platform.BEANS;
import org.jooq.Field;

import java.time.OffsetDateTime;
import java.util.UUID;

public class VariantRepository extends AbstractEntityRepository<Variant, VariantRecord, VariantDo> implements IVariantRepository {

  @Override
  public Variant getTable() {
    return Variant.VARIANT;
  }

  @Override
  public Field<UUID> getIdColumn() {
    return getTable().VARIANT_ID;
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
  protected VariantRecord toNewRecord(VariantDo sourceDo) {
    return fromDoToRecord(sourceDo, new VariantRecord());
  }

  @Override
  protected VariantDo toNewDo(VariantRecord sourceRecord) {
    return fromRecordToDo(sourceRecord, BEANS.get(VariantDo.class));
  }

  @Override
  protected DoEntityBeanMappings<VariantDo, VariantRecord> mappings() {
    return new DoEntityBeanMappings<VariantDo, VariantRecord>()
      .with(VariantDo::variantId, VariantRecord::getVariantId, VariantRecord::setVariantId)
      .with(VariantDo::name, VariantRecord::getName, VariantRecord::setName)
      .with(VariantDo::singleOption, VariantRecord::getSingleOption, VariantRecord::setSingleOption);
  }
}
