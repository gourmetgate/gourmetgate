import {BaseDoEntity, typeName} from "@eclipse-scout/core";

@typeName('gourmetgate.Item')
export class ItemDo extends BaseDoEntity {
  itemId: string;
  categoryId: string;
  vatId: string;
  name: string;
  price: string;
  cost: string;
  available: boolean;
  variantIds: string[];
}
