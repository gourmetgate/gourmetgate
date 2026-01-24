import {ObjectOrModel, PageWithTable, scout, TreeNodeModel} from "@eclipse-scout/core";
import CategoryTablePageModel, {CategoryTable} from './CategoryTablePageModel';
import {CategoryDo, CategoryRestClient, TableRowWithEntity} from "../../index";

export class CategoryTablePage extends PageWithTable {

  declare detailTable: CategoryTable;

  protected override _jsonModel(): TreeNodeModel {
    return CategoryTablePageModel();
  }

  protected override _loadTableData(): JQuery.Promise<CategoryDo[]> {
    return scout.create(CategoryRestClient).getAll();
  }

  protected override _transformTableDataToTableRows(tableData: CategoryDo[]): ObjectOrModel<TableRowWithEntity>[] {
    return tableData
      .map(category => this._createCategoryRow(category));
  }

  protected _createCategoryRow(category: CategoryDo): ObjectOrModel<TableRowWithEntity> {
    return {
      id: category.categoryId,
      entity: category,
      cells: [
        category.categoryId,
        category.name
      ]
    }
  }
}
