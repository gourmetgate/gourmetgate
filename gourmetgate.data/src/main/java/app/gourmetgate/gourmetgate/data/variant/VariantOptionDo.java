package app.gourmetgate.gourmetgate.data.variant;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;

import java.math.BigDecimal;
import java.util.UUID;

@TypeName("gourmetgate.VariantOption")
public class VariantOptionDo extends DoEntity {

  public DoValue<UUID> variantOptionId() {
    return doValue("variantOptionId");
  }

  public DoValue<UUID> variantId() {
    return doValue("variantId");
  }

  public DoValue<String> name() {
    return doValue("name");
  }

  public DoValue<BigDecimal> additionalPrice() {
    return doValue("additionalPrice");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public VariantOptionDo withVariantOptionId(UUID variantOptionId) {
    variantOptionId().set(variantOptionId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public UUID getVariantOptionId() {
    return variantOptionId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public VariantOptionDo withVariantId(UUID variantId) {
    variantId().set(variantId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public UUID getVariantId() {
    return variantId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public VariantOptionDo withName(String name) {
    name().set(name);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getName() {
    return name().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public VariantOptionDo withAdditionalPrice(BigDecimal additionalPrice) {
    additionalPrice().set(additionalPrice);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public BigDecimal getAdditionalPrice() {
    return additionalPrice().get();
  }
}
