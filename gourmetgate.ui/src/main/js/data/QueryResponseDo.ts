import {BaseDoEntity, typeName} from "@eclipse-scout/core";
import {CategoryDo, ItemDo, VatDo} from "./../index";

@typeName("QueryResponse")
export class QueryResponseDo extends BaseDoEntity {
  categories?: CategoryDo[];
  items?: ItemDo[];
  vat?: VatDo[];
}
