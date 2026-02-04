package app.gourmetgate.gourmetgate.data.query;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;

import java.util.UUID;

@TypeName("gourmetgate.VariantRestriction")
public class VariantRestrictionDo extends DoEntity {

  public DoValue<UUID> variantId() {
    return doValue("variantId");
  }

  public DoValue<String> name() {
    return doValue("name");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public VariantRestrictionDo withVariantId(UUID variantId) {
    variantId().set(variantId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public UUID getVariantId() {
    return variantId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public VariantRestrictionDo withName(String name) {
    name().set(name);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getName() {
    return name().get();
  }
}
