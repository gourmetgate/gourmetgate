package app.gourmetgate.gourmetgate.persistence.vat;

import app.gourmetgate.gourmetgate.data.vat.IVatRepository;
import app.gourmetgate.gourmetgate.data.vat.VatDo;
import app.gourmetgate.gourmetgate.persistence.common.AbstractEntityRepository;
import app.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import app.gourmetgate.gourmetgate.persistence.tables.Vat;
import app.gourmetgate.gourmetgate.persistence.tables.records.VatRecord;
import org.eclipse.scout.rt.platform.BEANS;
import org.jooq.Field;

import java.time.OffsetDateTime;
import java.util.UUID;

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
