package app.gourmetgate.gourmetgate.db.schema;

import app.gourmetgate.gourmetgate.db.common.GorumetGateEntitiy;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "category")
public class CategoryEntity extends GorumetGateEntitiy {

  @Id
  public UUID categoryId;

  @Column(length = 80, nullable = false)
  public String name;

}
