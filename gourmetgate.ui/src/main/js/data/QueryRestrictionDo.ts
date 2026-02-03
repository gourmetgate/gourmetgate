import {typeName} from "@eclipse-scout/core";
import {CategoryRestrictionDo, ItemRestrictionDo, VariantRestrictionDo, VatRestrictionDo} from "./../index";

@typeName("gourmetgate.QueryRestriction")
export class QueryRestrictionDo {
  categoryRestriction?: CategoryRestrictionDo;
  itemRestriction?: ItemRestrictionDo;
  variantRestriction?: VariantRestrictionDo;
  vatRestriction?: VatRestrictionDo;
}
