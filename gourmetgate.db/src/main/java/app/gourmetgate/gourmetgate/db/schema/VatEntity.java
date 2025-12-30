package app.gourmetgate.gourmetgate.db.schema;

import app.gourmetgate.gourmetgate.db.common.OrderableEntityWithStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "vat")
public class VatEntity extends OrderableEntityWithStatus {

  @Id
  public UUID vatId;

  @Column(nullable = false)
  public BigDecimal percentage;

  @Column(nullable = false)
  public String description;
}
