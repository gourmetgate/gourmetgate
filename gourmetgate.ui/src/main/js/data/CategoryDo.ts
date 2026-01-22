import {BaseDoEntity, typeName} from "@eclipse-scout/core";
import {ItemDo} from "./../index";

@typeName('gourmetgate.Category')
export class CategoryDo extends BaseDoEntity {
  categoryId: string;
  name: string;
  items: ItemDo[];
}
