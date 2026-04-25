package app.gourmetgate.gourmetgate.core.query;

import app.gourmetgate.gourmetgate.core.category.CategoryService;
import app.gourmetgate.gourmetgate.core.item.ItemService;
import app.gourmetgate.gourmetgate.core.user.UserService;
import app.gourmetgate.gourmetgate.core.variant.VariantService;
import app.gourmetgate.gourmetgate.core.vat.VatService;
import app.gourmetgate.gourmetgate.data.query.QueryResponseDo;
import app.gourmetgate.gourmetgate.data.query.QueryRestrictionDo;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;

public class QueryService implements IService {

  public QueryResponseDo queryData(QueryRestrictionDo restriction) {
    QueryResponseDo result = BEANS.get(QueryResponseDo.class);

    if (restriction.categoryRestriction().exists()) {
      result.withCategories(BEANS.get(CategoryService.class).list(restriction.getCategoryRestriction()));
    }

    if (restriction.itemRestriction().exists()) {
      result.withItems(BEANS.get(ItemService.class).list(restriction.getItemRestriction()));
    }

    if (restriction.variantRestriction().exists()) {
      result.withVariants(BEANS.get(VariantService.class).list(restriction.getVariantRestriction()));
    }

    if (restriction.vatRestriction().exists()) {
      result.withVat(BEANS.get(VatService.class).list(restriction.getVatRestriction()));
    }

    if (restriction.userRestriction().exists()) {
      result.withUsers(BEANS.get(UserService.class).list(restriction.getUserRestriction()));
    }

    return result;
  }
}
