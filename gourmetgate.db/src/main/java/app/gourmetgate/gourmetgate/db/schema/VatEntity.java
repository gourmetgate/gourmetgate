package app.gourmetgate.gourmetgate.db.schema;

import app.gourmetgate.gourmetgate.db.common.ISchemaEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "vat")
public class VatEntity implements ISchemaEntity {

  @Id
  private UUID vatId;

  private BigDecimal percentage;

  @Nullable
  private String description;


  public UUID getVatId() {
    return vatId;
  }

  public void setVatId(UUID vatId) {
    this.vatId = vatId;
  }

  public BigDecimal getPercentage() {
    return percentage;
  }

  public void setPercentage(BigDecimal percentage) {
    this.percentage = percentage;
  }

  @Nullable
  public String getDescription() {
    return description;
  }

  public void setDescription(@Nullable String description) {
    this.description = description;
  }
}
