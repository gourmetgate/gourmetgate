import {BaseDoEntity, typeName} from "@eclipse-scout/core";

@typeName('gourmetgate.VariantOption')
export class VariantOptionDo extends BaseDoEntity {
  variantOptionId: string;
  variantId: string;
  name: string;
  additionalPrice: string;
}
