import {BaseDoEntity, typeName} from "@eclipse-scout/core";
import {CategoryDo} from "./../index";

@typeName("gourmetgate.CategoryResponse")
export class CategoryResponseDo extends BaseDoEntity {
  categories: CategoryDo[];
}
