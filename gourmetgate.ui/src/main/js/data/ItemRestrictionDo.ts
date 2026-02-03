import {typeName} from "@eclipse-scout/core";

@typeName("gourmetgate.ItemRestriction")
export class ItemRestrictionDo {
  categories?: string[];
  available?: boolean;
}
