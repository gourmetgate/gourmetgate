package app.gourmetgate.gourmetgate.data.category;

import app.gourmetgate.gourmetgate.data.item.ItemDo;
import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoList;
import org.eclipse.scout.rt.dataobject.DoValue;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class CategoryDo extends DoEntity {

  public DoValue<UUID> categoryId() {
    return doValue("categoryId");
  }

  public DoValue<String> name() {
    return doValue("name");
  }

  public DoList<ItemDo> items() {
    return doList("items");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public CategoryDo withCategoryId(UUID categoryId) {
    categoryId().set(categoryId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public UUID getCategoryId() {
    return categoryId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public CategoryDo withName(String name) {
    name().set(name);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getName() {
    return name().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public CategoryDo withItems(Collection<? extends ItemDo> items) {
    items().updateAll(items);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public CategoryDo withItems(ItemDo... items) {
    items().updateAll(items);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<ItemDo> getItems() {
    return items().get();
  }
}
