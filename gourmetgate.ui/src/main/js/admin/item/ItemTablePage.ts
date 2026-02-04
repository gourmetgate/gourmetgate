import {ObjectOrModel, scout, Table, TreeNodeModel} from "@eclipse-scout/core";
import ItemTablePageModel, {ItemTable} from './ItemTablePageModel';
import {
  AdminTablePage,
  CategoryDo,
  CategoryRestClient,
  ItemDo,
  ItemForm,
  ItemRestClient,
  MessageBoxHelper,
  QueryResponseDo,
  QueryRestClient,
  TableRowWithEntity,
  VariantDo,
  VariantRestClient,
  VatDo,
  VatRestClient
} from "../../index";

export class ItemTablePage extends AdminTablePage {
  declare detailTable: ItemTable;

  protected override _jsonModel(): TreeNodeModel {
    return ItemTablePageModel();
  }

  protected override _initDetailTable(table: Table) {
    super._initDetailTable(table);

    let createItemMenu = this.detailTable.widget('CreateItemMenu');
    createItemMenu.on('action', this._onCreateItemMenuAction.bind(this));

    let editItemMenu = this.detailTable.widget('EditItemMenu');
    editItemMenu.on('action', this._onEditItemMenuAction.bind(this));

    let deleteItemMenu = this.detailTable.widget('DeleteItemMenu');
    deleteItemMenu.on('action', this._onDeleteItemMenuAction.bind(this));
  }

  protected override _loadTableData(): JQuery.Promise<QueryResponseDo> {
    return scout.create(QueryRestClient).queryData({
      categoryRestriction: {},
      itemRestriction: {},
      variantRestriction: {},
      vatRestriction: {}
    })
  }

  protected override _transformTableDataToTableRows(tableData: QueryResponseDo): ObjectOrModel<TableRowWithEntity>[] {
    let vatById = new Map(tableData.vat.map(vat => [vat.vatId, vat]));
    let categoryById = new Map(tableData.categories.map(c => [c.categoryId, c]));
    let variantsById = new Map(tableData.variants.map(v => [v.variantId, v]));

    return tableData.items
      .map(item => this._createItemRow(item, categoryById.get(item.categoryId), vatById.get(item.vatId), variantsById));
  }

  protected _createItemRow(item: ItemDo, category: CategoryDo, vat: VatDo, variantsById: Map<string, VariantDo>): ObjectOrModel<TableRowWithEntity> {
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
        vat.percentage,
        item.variantIds?.map(id => variantsById.get(id).name).join(", ")
      ]
    }
  }

  protected _getSelectedItem(): ItemDo {
    let selection = this.detailTable.selectedRow() as TableRowWithEntity;
    return selection?.entity as ItemDo;
  }

  protected _createItemForm(): ItemForm {
    return scout.create(ItemForm, {
      parent: this.outline
    });
  }

  protected _onCreateItemMenuAction() {
    let form = this._createItemForm();
    let emptyItem = scout.create(ItemDo);
    form.setData(emptyItem);
    form.open();
  }

  protected _onEditItemMenuAction() {
    let form = this._createItemForm();
    form.setData(this._getSelectedItem());
    form.open();
  }

  protected _onDeleteItemMenuAction() {
    scout.create(MessageBoxHelper).createDeleteConfirmationMessageBox(this.session)
      .then(yes => {
        if (yes) {
          scout.create(ItemRestClient).remove(this._getSelectedItem().itemId);
        }
      })
  }

  protected _listeningDataTypes(): string[] {
    return [CategoryRestClient.DATA_TYPE, ItemRestClient.DATA_TYPE, VariantRestClient.DATA_TYPE, VatRestClient.DATA_TYPE];
  }
}
