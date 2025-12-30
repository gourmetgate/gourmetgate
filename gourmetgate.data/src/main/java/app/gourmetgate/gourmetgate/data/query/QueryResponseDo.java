package app.gourmetgate.gourmetgate.data.query;

import app.gourmetgate.gourmetgate.data.category.CategoryDo;
import app.gourmetgate.gourmetgate.data.item.ItemDo;
import app.gourmetgate.gourmetgate.data.vat.VatDo;
import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoList;
import org.eclipse.scout.rt.dataobject.TypeName;

import java.util.Collection;
import java.util.List;

@TypeName("gourmetgate.QueryResponse")
public class QueryResponseDo extends DoEntity {

  public DoList<CategoryDo> categories() {
    return doList("categories");
  }

  public DoList<ItemDo> items() {
    return doList("items");
  }

  public DoList<VatDo> vat() {
    return doList("vat");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public QueryResponseDo withCategories(Collection<? extends CategoryDo> categories) {
    categories().updateAll(categories);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public QueryResponseDo withCategories(CategoryDo... categories) {
    categories().updateAll(categories);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<CategoryDo> getCategories() {
    return categories().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public QueryResponseDo withItems(Collection<? extends ItemDo> items) {
    items().updateAll(items);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public QueryResponseDo withItems(ItemDo... items) {
    items().updateAll(items);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<ItemDo> getItems() {
    return items().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public QueryResponseDo withVat(Collection<? extends VatDo> vat) {
    vat().updateAll(vat);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public QueryResponseDo withVat(VatDo... vat) {
    vat().updateAll(vat);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<VatDo> getVat() {
    return vat().get();
  }
}
