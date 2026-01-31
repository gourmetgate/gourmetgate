import {typeName} from "@eclipse-scout/core";
import {CategoryRestrictionDo, ItemRestrictionDo, VatRestrictionDo} from "./../index";

@typeName("gourmetgate.QueryRestriction")
export class QueryRestrictionDo {
  categoryRestriction?: CategoryRestrictionDo;
  itemRestriction?: ItemRestrictionDo
  vatRestriction?: VatRestrictionDo;
}
