package app.gourmetgate.gourmetgate.data.mapping;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;

import java.util.UUID;

public class ItemToVariantDo extends DoEntity {

  public DoValue<UUID> itemId() {
    return doValue("itemId");
  }

  public DoValue<UUID> variantId() {
    return doValue("variantId");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public ItemToVariantDo withItemId(UUID itemId) {
    itemId().set(itemId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public UUID getItemId() {
    return itemId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ItemToVariantDo withVariantId(UUID variantId) {
    variantId().set(variantId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public UUID getVariantId() {
    return variantId().get();
  }
}
