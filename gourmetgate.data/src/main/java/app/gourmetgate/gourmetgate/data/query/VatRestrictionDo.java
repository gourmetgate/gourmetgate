package app.gourmetgate.gourmetgate.data.query;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;

import java.math.BigDecimal;
import java.util.UUID;

@TypeName("gourmetgate.VatRestriction")
public class VatRestrictionDo extends DoEntity {

  public DoValue<UUID> vatId() {
    return doValue("vatId");
  }

  public DoValue<BigDecimal> percentage() {
    return doValue("percentage");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public VatRestrictionDo withVatId(UUID vatId) {
    vatId().set(vatId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public UUID getVatId() {
    return vatId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public VatRestrictionDo withPercentage(BigDecimal percentage) {
    percentage().set(percentage);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public BigDecimal getPercentage() {
    return percentage().get();
  }
}
