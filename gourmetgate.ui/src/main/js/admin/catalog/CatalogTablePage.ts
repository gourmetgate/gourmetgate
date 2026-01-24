import {BaseDoEntity, ObjectOrModel, PageWithTable, PageWithTableModel, scout, TableRow} from "@eclipse-scout/core";
import CatalogTablePageModel, {CatalogTablePageTable} from "./CatalogTablePageModel";
import {CategoryDo, ItemDo, QueryResponseDo, VatDo} from "../../index";
import {QueryRestClient} from "../../rest/QueryRestClient";

export class CatalogTablePage extends PageWithTable {
  declare detailTable: CatalogTablePageTable;

  protected override _jsonModel(): PageWithTableModel {
    return CatalogTablePageModel();
  }

  protected override _loadTableData(): JQuery.Promise<QueryResponseDo> {
    return scout.create(QueryRestClient).queryData({
      categoryRestriction: {},
      itemRestriction: {},
      vatRestriction: {}
    })
  }

  protected override _transformTableDataToTableRows(tableData: QueryResponseDo): ObjectOrModel<TableRowWithEntity>[] {
    let categoryRows = tableData.categories
      .map(category => this._createCategoryRow(category));

    let vatById = new Map(tableData.vat.map(vat => [vat.vatId, vat]));

    let itemRows = tableData.items
      .map(item => this._createItemRow(item, vatById.get(item.vatId)));

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

  protected _createItemRow(item: ItemDo, vat: VatDo): ObjectOrModel<TableRowWithEntity> {
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
        vat.percentage
      ]
    }
  }
}

export interface TableRowWithEntity extends TableRow {
  entity: BaseDoEntity;
}
