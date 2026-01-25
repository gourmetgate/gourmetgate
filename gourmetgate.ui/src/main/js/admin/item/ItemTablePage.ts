import {ObjectOrModel, scout, TreeNodeModel} from "@eclipse-scout/core";
import ItemTablePageModel, {ItemTable} from './ItemTablePageModel';
import {
  AdminTablePage,
  CategoryDo,
  CategoryRestClient,
  ItemDo,
  QueryResponseDo,
  QueryRestClient,
  TableRowWithEntity,
  VatDo
} from "../../index";

export class ItemTablePage extends AdminTablePage {
  declare detailTable: ItemTable;

  protected override _jsonModel(): TreeNodeModel {
    return ItemTablePageModel();
  }

  protected override _loadTableData(): JQuery.Promise<QueryResponseDo> {
    return scout.create(QueryRestClient).queryData({
      categoryRestriction: {},
      itemRestriction: {},
      vatRestriction: {}
    })
  }

  protected override _transformTableDataToTableRows(tableData: QueryResponseDo): ObjectOrModel<TableRowWithEntity>[] {
    let vatById = new Map(tableData.vat.map(vat => [vat.vatId, vat]));
    let categoryById = new Map(tableData.categories.map(c => [c.categoryId, c]));

    return tableData.items
      .map(item => this._createItemRow(item, categoryById.get(item.categoryId), vatById.get(item.vatId)));
  }

  protected _createItemRow(item: ItemDo, category: CategoryDo, vat: VatDo): ObjectOrModel<TableRowWithEntity> {
    return {
      id: item.itemId,
      entity: item,
      cells: [
        item.itemId,
        item.name,
        category.name,
        item.available,
        item.price,
        item.cost,
        vat.percentage
      ]
    }
  }

  protected _listeningDataTypes(): string[] {
    return [CategoryRestClient.DATA_TYPE];
  }
}
