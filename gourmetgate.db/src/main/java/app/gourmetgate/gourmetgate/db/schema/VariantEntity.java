package app.gourmetgate.gourmetgate.db.schema;

import app.gourmetgate.gourmetgate.db.common.GorumetGateEntitiy;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "variant")
public class VariantEntity extends GorumetGateEntitiy {

  @Id
  public UUID variantId;

  @Column(nullable = false)
  public String name;

  @Column(nullable = false)
  public Boolean singleOption;
}
