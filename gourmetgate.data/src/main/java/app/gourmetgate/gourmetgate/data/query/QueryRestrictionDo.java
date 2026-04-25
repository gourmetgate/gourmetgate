package app.gourmetgate.gourmetgate.data.query;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;

@TypeName("gourmetgate.QueryRestriction")
public class QueryRestrictionDo extends DoEntity {

    public DoValue<CategoryRestrictionDo> categoryRestriction() {
        return doValue("categoryRestriction");
    }

    public DoValue<ItemRestrictionDo> itemRestriction() {
        return doValue("itemRestriction");
    }

    public DoValue<VariantRestrictionDo> variantRestriction() {
        return doValue("variantRestriction");
    }

    public DoValue<VatRestrictionDo> vatRestriction() {
        return doValue("vatRestriction");
    }

    public DoValue<UserRestrictionDo> userRestriction() {
        return doValue("userRestriction");
    }

    /* **************************************************************************
     * GENERATED CONVENIENCE METHODS
     * *************************************************************************/

    @Generated("DoConvenienceMethodsGenerator")
    public QueryRestrictionDo withCategoryRestriction(CategoryRestrictionDo categoryRestriction) {
        categoryRestriction().set(categoryRestriction);
        return this;
    }

    @Generated("DoConvenienceMethodsGenerator")
    public CategoryRestrictionDo getCategoryRestriction() {
        return categoryRestriction().get();
    }

    @Generated("DoConvenienceMethodsGenerator")
    public QueryRestrictionDo withItemRestriction(ItemRestrictionDo itemRestriction) {
        itemRestriction().set(itemRestriction);
        return this;
    }

    @Generated("DoConvenienceMethodsGenerator")
    public ItemRestrictionDo getItemRestriction() {
        return itemRestriction().get();
    }

    @Generated("DoConvenienceMethodsGenerator")
    public QueryRestrictionDo withVariantRestriction(VariantRestrictionDo variantRestriction) {
        variantRestriction().set(variantRestriction);
        return this;
    }

    @Generated("DoConvenienceMethodsGenerator")
    public VariantRestrictionDo getVariantRestriction() {
        return variantRestriction().get();
    }

    @Generated("DoConvenienceMethodsGenerator")
    public QueryRestrictionDo withVatRestriction(VatRestrictionDo vatRestriction) {
        vatRestriction().set(vatRestriction);
        return this;
    }

    @Generated("DoConvenienceMethodsGenerator")
    public VatRestrictionDo getVatRestriction() {
        return vatRestriction().get();
    }

    @Generated("DoConvenienceMethodsGenerator")
    public QueryRestrictionDo withUserRestriction(UserRestrictionDo userRestriction) {
        userRestriction().set(userRestriction);
        return this;
    }

    @Generated("DoConvenienceMethodsGenerator")
    public UserRestrictionDo getUserRestriction() {
        return userRestriction().get();
    }
}
