package app.gourmetgate.gourmetgate.data.variant;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoList;
import org.eclipse.scout.rt.dataobject.TypeName;

import java.util.Collection;
import java.util.List;

@TypeName("gourmetgate.VariantResponse")
public class VariantResponseDo extends DoEntity {

  public DoList<VariantDo> variants() {
    return doList("variants");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public VariantResponseDo withVariants(Collection<? extends VariantDo> variants) {
    variants().updateAll(variants);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public VariantResponseDo withVariants(VariantDo... variants) {
    variants().updateAll(variants);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<VariantDo> getVariants() {
    return variants().get();
  }
}
