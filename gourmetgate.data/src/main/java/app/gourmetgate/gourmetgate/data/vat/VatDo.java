package app.gourmetgate.gourmetgate.data.vat;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;

import java.math.BigDecimal;
import java.util.UUID;

@TypeName("gourmetgate.Vat")
public class VatDo extends DoEntity {

  public DoValue<UUID> vatId() {
    return doValue("vatId");
  }

  public DoValue<BigDecimal> percentage() {
    return doValue("percentage");
  }

  public DoValue<String> description() {
    return doValue("description");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public VatDo withVatId(UUID vatId) {
    vatId().set(vatId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public UUID getVatId() {
    return vatId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public VatDo withPercentage(BigDecimal percentage) {
    percentage().set(percentage);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public BigDecimal getPercentage() {
    return percentage().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public VatDo withDescription(String description) {
    description().set(description);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getDescription() {
    return description().get();
  }
}
