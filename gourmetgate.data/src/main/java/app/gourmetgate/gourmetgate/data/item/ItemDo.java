package app.gourmetgate.gourmetgate.data.item;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;

import java.math.BigDecimal;
import java.util.UUID;

@TypeName("gourmetgate.Item")
public class ItemDo extends DoEntity {

  public DoValue<UUID> itemId() {
    return doValue("itemId");
  }

  public DoValue<UUID> categoryId() {
    return doValue("categoryId");
  }

  public DoValue<UUID> vatId() {
    return doValue("vatId");
  }

  public DoValue<String> name() {
    return doValue("name");
  }

  public DoValue<BigDecimal> price() {
    return doValue("price");
  }

  public DoValue<BigDecimal> cost() {
    return doValue("cost");
  }

  public DoValue<Boolean> available() {
    return doValue("available");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public ItemDo withItemId(UUID itemId) {
    itemId().set(itemId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public UUID getItemId() {
    return itemId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ItemDo withCategoryId(UUID categoryId) {
    categoryId().set(categoryId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public UUID getCategoryId() {
    return categoryId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ItemDo withVatId(UUID vatId) {
    vatId().set(vatId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public UUID getVatId() {
    return vatId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ItemDo withName(String name) {
    name().set(name);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getName() {
    return name().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ItemDo withPrice(BigDecimal price) {
    price().set(price);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public BigDecimal getPrice() {
    return price().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ItemDo withCost(BigDecimal cost) {
    cost().set(cost);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public BigDecimal getCost() {
    return cost().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public ItemDo withAvailable(Boolean available) {
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
