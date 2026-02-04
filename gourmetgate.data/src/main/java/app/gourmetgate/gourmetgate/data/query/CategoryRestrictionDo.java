package app.gourmetgate.gourmetgate.data.query;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;

import java.util.UUID;

@TypeName("gourmetgate.CategoryRestriction")
public class CategoryRestrictionDo extends DoEntity {

  public DoValue<UUID> categoryId() {
    return doValue("categoryId");
  }

  public DoValue<String> name() {
    return doValue("name");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public CategoryRestrictionDo withCategoryId(UUID categoryId) {
    categoryId().set(categoryId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public UUID getCategoryId() {
    return categoryId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public CategoryRestrictionDo withName(String name) {
    name().set(name);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getName() {
    return name().get();
  }
}
