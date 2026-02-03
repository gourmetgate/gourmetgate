import {ObjectOrModel, scout, Table, TreeNodeModel} from "@eclipse-scout/core";
import {
  AdminTablePage,
  MessageBoxHelper,
  TableRowWithEntity,
  VariantDo,
  VariantForm,
  VariantRestClient
} from "../../index";
import VariantTablePageModel, {VariantTable} from './VariantTablePageModel';

export class VariantTablePage extends AdminTablePage {
  declare detailTable: VariantTable;


  protected override _jsonModel(): TreeNodeModel {
    return VariantTablePageModel();
  }

  protected override _initDetailTable(table: Table) {
    super._initDetailTable(table);

    let createVariantMenu = this.detailTable.widget('CreateVariantMenu');
    createVariantMenu.on('action', this._onCreateVariantMenuAction.bind(this));

    let editVariantMenu = this.detailTable.widget('EditVariantMenu');
    editVariantMenu.on('action', this._onEditVariantMenuAction.bind(this));

    let deleteVariantMenu = this.detailTable.widget('DeleteVariantMenu');
    deleteVariantMenu.on('action', this._onDeleteVariantMenuAction.bind(this));
  }

  protected override _loadTableData(): JQuery.Promise<VariantDo[]> {
    return scout.create(VariantRestClient).getAll();
  }

  protected override _transformTableDataToTableRows(variant: VariantDo[]): ObjectOrModel<TableRowWithEntity>[] {
    return variant.map(v => this._createVariantRow(v))
  }

  protected _createVariantRow(variant: VariantDo): ObjectOrModel<TableRowWithEntity> {
    return {
      id: variant.variantId,
      entity: variant,
      cells: [
        variant.variantId,
        variant.name,
        variant.singleOption,
        variant.variantOptions.map(o => o.name).join(", ")
      ]
    }
  }

  protected _getSelectedVariant(): VariantDo {
    let selection = this.detailTable.selectedRow() as TableRowWithEntity;
    return selection?.entity as VariantDo;
  }

  protected _createVariantForm(): VariantForm {
    return scout.create(VariantForm, {
      parent: this.outline
    });
  }

  protected _onCreateVariantMenuAction() {
    let form = this._createVariantForm();
    let emptyVariant = scout.create(VariantDo);
    form.setData(emptyVariant);
    form.open();
  }

  protected _onEditVariantMenuAction() {
    let form = this._createVariantForm();
    form.setData(this._getSelectedVariant());
    form.open();
  }

  protected _onDeleteVariantMenuAction() {
    scout.create(MessageBoxHelper).createDeleteConfirmationMessageBox(this.session)
      .then(yes => {
        if (yes) {
          scout.create(VariantRestClient).remove(this._getSelectedVariant().variantId);
        }
      })
  }

  protected _listeningDataTypes(): string[] {
    return [VariantRestClient.DATA_TYPE];
  }
}
