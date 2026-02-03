package app.gourmetgate.gourmetgate.data.variant;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoList;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@TypeName("gourmetgate.Variant")
public class VariantDo extends DoEntity {

  public DoValue<UUID> variantId() {
    return doValue("variantId");
  }

  public DoValue<String> name() {
    return doValue("name");
  }

  public DoValue<Boolean> singleOption() {
    return doValue("singleOption");
  }

  public DoList<VariantOptionDo> variantOptions() {
    return doList("variantOptions");
  }

  public DoList<UUID> itemIds() {
    return doList("itemIds");
  }

  /* **************************************************************************
   * GENERATED CONVENIENCE METHODS
   * *************************************************************************/

  @Generated("DoConvenienceMethodsGenerator")
  public VariantDo withVariantId(UUID variantId) {
    variantId().set(variantId);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public UUID getVariantId() {
    return variantId().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public VariantDo withName(String name) {
    name().set(name);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public String getName() {
    return name().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public VariantDo withSingleOption(Boolean singleOption) {
    singleOption().set(singleOption);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public Boolean getSingleOption() {
    return singleOption().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public boolean isSingleOption() {
    return nvl(getSingleOption());
  }

  @Generated("DoConvenienceMethodsGenerator")
  public VariantDo withVariantOptions(Collection<? extends VariantOptionDo> variantOptions) {
    variantOptions().updateAll(variantOptions);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public VariantDo withVariantOptions(VariantOptionDo... variantOptions) {
    variantOptions().updateAll(variantOptions);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<VariantOptionDo> getVariantOptions() {
    return variantOptions().get();
  }

  @Generated("DoConvenienceMethodsGenerator")
  public VariantDo withItemIds(Collection<? extends UUID> itemIds) {
    itemIds().updateAll(itemIds);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public VariantDo withItemIds(UUID... itemIds) {
    itemIds().updateAll(itemIds);
    return this;
  }

  @Generated("DoConvenienceMethodsGenerator")
  public List<UUID> getItemIds() {
    return itemIds().get();
  }
}
