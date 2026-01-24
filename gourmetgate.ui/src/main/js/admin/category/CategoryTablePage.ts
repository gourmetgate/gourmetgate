import {ObjectOrModel, PageWithTable, scout, TreeNodeModel} from "@eclipse-scout/core";
import CategoryTablePageModel, {CategoryTable} from './CategoryTablePageModel';
import {CategoryDo, QueryResponseDo, QueryRestClient, TableRowWithEntity} from "../../index";

export class CategoryTablePage extends PageWithTable {

  declare detailTable: CategoryTable;

  protected override _jsonModel(): TreeNodeModel {
    return CategoryTablePageModel();
  }

  protected override _loadTableData(): JQuery.Promise<QueryResponseDo> {
    return scout.create(QueryRestClient).queryData({
      categoryRestriction: {}
    })
  }

  protected override _transformTableDataToTableRows(tableData: QueryResponseDo): ObjectOrModel<TableRowWithEntity>[] {
    return tableData.categories
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
