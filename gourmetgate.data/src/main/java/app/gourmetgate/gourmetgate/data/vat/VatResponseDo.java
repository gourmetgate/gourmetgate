package app.gourmetgate.gourmetgate.data.vat;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoList;
import org.eclipse.scout.rt.dataobject.TypeName;

import java.util.Collection;
import java.util.List;

@TypeName("gourmetgate.VatResponse")
public class VatResponseDo extends DoEntity {

  public DoList<VatDo> vat() {
    return doList("vat");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public VatResponseDo withVat(Collection<? extends VatDo> vat) {
    vat().updateAll(vat);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public VatResponseDo withVat(VatDo... vat) {
    vat().updateAll(vat);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<VatDo> getVat() {
    return vat().get();
  }
}
