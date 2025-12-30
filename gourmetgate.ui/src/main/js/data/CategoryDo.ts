import {BaseDoEntity, typeName} from "@eclipse-scout/core";

@typeName('gourmetgate.Category')
export class CategoryDo extends BaseDoEntity {
  categoryId: string;
  name: string;
}
