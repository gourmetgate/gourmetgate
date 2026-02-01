import {BaseDoEntity, typeName} from "@eclipse-scout/core";
import {ItemDo} from "./../index";

@typeName("gourmetgate.ItemResponse")
export class ItemResponseDo extends BaseDoEntity {
  items: ItemDo[];
}
