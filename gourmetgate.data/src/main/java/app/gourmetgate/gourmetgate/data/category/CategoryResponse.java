package app.gourmetgate.gourmetgate.data.category;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoList;

import java.util.Collection;
import java.util.List;

public class CategoryResponse extends DoEntity {

  public DoList<CategoryDo> categories() {
    return doList("categories");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public CategoryResponse withCategories(Collection<? extends CategoryDo> categories) {
    categories().updateAll(categories);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public CategoryResponse withCategories(CategoryDo... categories) {
    categories().updateAll(categories);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<CategoryDo> getCategories() {
    return categories().get();
  }
}
