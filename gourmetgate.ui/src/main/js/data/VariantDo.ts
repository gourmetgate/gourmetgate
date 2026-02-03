import {BaseDoEntity, typeName} from "@eclipse-scout/core";
import {VariantOptionDo} from "./VariantOptionDo";

@typeName('gourmetgate.Variant')
export class VariantDo extends BaseDoEntity {
  variantId: string;
  name: string;
  singleOption: boolean;
  variantOptions: VariantOptionDo[];
  itemIds: string[];
}
