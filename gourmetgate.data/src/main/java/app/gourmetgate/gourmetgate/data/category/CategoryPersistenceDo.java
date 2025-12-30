package app.gourmetgate.gourmetgate.data.category;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;

import java.util.UUID;

public class CategoryPersistenceDo extends DoEntity {

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
  public CategoryPersistenceDo withCategoryId(UUID categoryId) {
    categoryId().set(categoryId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public UUID getCategoryId() {
    return categoryId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public CategoryPersistenceDo withName(String name) {
    name().set(name);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getName() {
    return name().get();
  }
}
