import {BaseDoEntity, ObjectOrModel, PageWithTable, PageWithTableModel, scout, TableRow} from "@eclipse-scout/core";
import CatalogTablePageModel, {CatalogTablePageTable} from "./CatalogTablePageModel";
import {CategoryDo, CategoryRestClient, ItemDo} from "../../index";

export class CatalogTablePage extends PageWithTable {
  declare detailTable: CatalogTablePageTable;

  protected override _jsonModel(): PageWithTableModel {
    return CatalogTablePageModel();
  }

  protected override _loadTableData(): JQuery.Promise<CategoryDo[]> {
    return scout.create(CategoryRestClient).getAllCategories(false);
  }

  protected override _transformTableDataToTableRows(tableData: CategoryDo[]): ObjectOrModel<TableRowWithEntity>[] {
    let categoryRows = tableData
      .map(category => this._createCategoryRow(category));

    let itemRows = tableData
      .map(c => c.items)
      .flat(1)
      .map(item => this._createItemRow(item));

    return categoryRows.concat(itemRows);
  }

  protected _createCategoryRow(category: CategoryDo): ObjectOrModel<TableRowWithEntity> {
    return {
      id: category.categoryId,
      entity: category,
      expanded: true,
      cells: [
        category.categoryId,
        category.name
      ]
    }
  }

  protected _createItemRow(item: ItemDo): ObjectOrModel<TableRowWithEntity> {
    return {
      id: item.itemId,
      parentRow: item.categoryId,
      entity: item,
      cells: [
        item.itemId,
        item.name,
        item.available,
        item.price,
        item.cost,
        item.vat.percentage
      ]
    }
  }
}

export interface TableRowWithEntity extends TableRow {
  entity: BaseDoEntity;
}
