package app.gourmetgate.gourmetgate.db.schema;

import app.gourmetgate.gourmetgate.db.common.OrderableEntityWithStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "item")
public class ItemEntity extends OrderableEntityWithStatus {

  @Id
  public UUID itemId;

  @Column(nullable = false)
  public UUID categoryId;

  @Column(nullable = false)
  public UUID vatId;

  @Column(length = 80, nullable = false)
  public String name;

  @Column(nullable = false)
  public BigDecimal price;

  public BigDecimal cost;

  @Column(nullable = false)
  public boolean available = true;
}
