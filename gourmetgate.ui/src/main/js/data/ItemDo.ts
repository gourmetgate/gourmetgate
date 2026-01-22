import {BaseDoEntity, typeName} from "@eclipse-scout/core";
import {VatDo} from "./../index";

@typeName('gourmetgate.Item')
export class ItemDo extends BaseDoEntity {
  itemId: string;
  categoryId: string;
  vat: VatDo;
  name: string;
  price: string;
  cost: string;
  available: boolean;
}
