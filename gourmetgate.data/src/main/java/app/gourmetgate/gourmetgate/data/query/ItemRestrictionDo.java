package app.gourmetgate.gourmetgate.data.query;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoList;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;

import java.util.Collection;
import java.util.List;

@TypeName("gourmetgate.ItemRestirction")
public class ItemRestrictionDo extends DoEntity {

  public DoList<String> categories() {
    return doList("categories");
  }

  public DoValue<Boolean> available() {
    return doValue("available");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public ItemRestrictionDo withCategories(Collection<? extends String> categories) {
    categories().updateAll(categories);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ItemRestrictionDo withCategories(String... categories) {
    categories().updateAll(categories);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<String> getCategories() {
    return categories().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ItemRestrictionDo withAvailable(Boolean available) {
    available().set(available);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public Boolean getAvailable() {
    return available().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public boolean isAvailable() {
    return nvl(getAvailable());
  }
}
