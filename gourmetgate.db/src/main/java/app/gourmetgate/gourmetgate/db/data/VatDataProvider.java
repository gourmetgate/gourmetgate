package app.gourmetgate.gourmetgate.db.data;

import app.gourmetgate.gourmetgate.db.common.AbstractInitialDataProvider;
import app.gourmetgate.gourmetgate.db.schema.VatEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class VatDataProvider extends AbstractInitialDataProvider<VatEntity> {

  public static final UUID VAT_STANDARD_CH_ID = UUID.randomUUID();

  @Override
  public List<VatEntity> getInitialData() {
    VatEntity entity = new VatEntity();
    entity.vatId = VAT_STANDARD_CH_ID;
    entity.percentage = new BigDecimal("8.1");
    entity.description = "Default VAT of Switzerland";
    return List.of(entity);
  }
}
