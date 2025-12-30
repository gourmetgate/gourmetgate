import {typeName} from "@eclipse-scout/core";

@typeName("ItemRestriction")
export class ItemRestrictionDo {
  categories?: string[];
  available?: boolean;
}
