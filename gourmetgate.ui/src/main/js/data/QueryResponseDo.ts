import {BaseDoEntity, typeName} from "@eclipse-scout/core";
import {CategoryDo, ItemDo, VariantDo, VatDo, UserDo} from "./../index";

@typeName("QueryResponse")
export class QueryResponseDo extends BaseDoEntity {
  categories?: CategoryDo[];
  items?: ItemDo[];
  variants?: VariantDo[];
  vat?: VatDo[];
  users?: UserDo[];
}
