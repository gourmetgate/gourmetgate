package app.gourmetgate.gourmetgate.db.schema;

import app.gourmetgate.gourmetgate.db.common.ISchemaEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "item_to_variant")
public class ItemToVariantEntity implements ISchemaEntity {

  @Id
  public UUID itemId;

  @Id
  public UUID variantId;
}
