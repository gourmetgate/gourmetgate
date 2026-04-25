package app.gourmetgate.gourmetgate.db.schema;

import app.gourmetgate.gourmetgate.db.common.GorumetGateEntitiy;
import app.gourmetgate.gourmetgate.db.common.ISchemaEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "user")
public class UserEntity extends GorumetGateEntitiy {

  @Id
  public UUID userId;

  @Column(nullable = false)
  public String userName;

  @Column(nullable = false)
  public String password;

  @Column(nullable = false)
  public String salt;
}
