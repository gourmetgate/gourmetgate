import {ObjectOrModel, scout, Table, TreeNodeModel} from "@eclipse-scout/core";
import VatTablePageModel, {VatTable} from './VatTablePageModel';
import {
  AdminTablePage,
  QueryRestClient,
  ReplacementChooserForm,
  TableRowWithEntity,
  VatDo,
  VatForm,
  VatLookupCall,
  VatRestClient
} from "../../index";

export class VatTablePage extends AdminTablePage {
  declare detailTable: VatTable;


  protected override _jsonModel(): TreeNodeModel {
    return VatTablePageModel();
  }

  protected override _initDetailTable(table: Table) {
    super._initDetailTable(table);

    let createCategoryMenu = this.detailTable.widget('CreateVatMenu');
    createCategoryMenu.on('action', this._onCreateVatMenuAction.bind(this));

    let editCategoryMenu = this.detailTable.widget('EditVatMenu');
    editCategoryMenu.on('action', this._onEditVatMenuAction.bind(this));

    let deleteCategoryMenu = this.detailTable.widget('DeleteVatMenu');
    deleteCategoryMenu.on('action', this._onDeleteVatMenuAction.bind(this));
  }

  protected override _loadTableData(): JQuery.Promise<VatDo[]> {
    return scout.create(QueryRestClient).queryData({
      vatRestriction: {}
    }).then(response => response.vat);
  }

  protected override _transformTableDataToTableRows(vat: VatDo[]): ObjectOrModel<TableRowWithEntity>[] {
    return vat.map(v => this._createVatRow(v))
  }

  protected _createVatRow(vat: VatDo): ObjectOrModel<TableRowWithEntity> {
    return {
      id: vat.vatId,
      entity: vat,
      cells: [
        vat.vatId,
        vat.percentage,
        vat.description
      ]
    }
  }

  protected _getSelectedVat(): VatDo {
    let selection = this.detailTable.selectedRow() as TableRowWithEntity;
    return selection?.entity as VatDo;
  }

  protected _createVatForm(): VatForm {
    return scout.create(VatForm, {
      parent: this.outline
    });
  }

  protected _onCreateVatMenuAction() {
    let form = this._createVatForm();
    let emptyVat = scout.create(VatDo);
    form.setData(emptyVat);
    form.open();
  }

  protected _onEditVatMenuAction() {
    let form = this._createVatForm();
    form.setData(this._getSelectedVat());
    form.open();
  }

  protected _onDeleteVatMenuAction() {
    let selectedVat = this._getSelectedVat();
    let form = scout.create(ReplacementChooserForm, {
      parent: this.parent,
      title: this.session.text('DeleteX', selectedVat.percentage),
      prompt: this.session.text('ChooseReplacementForX', selectedVat.percentage),
      replacementLookupCall: {
        objectType: VatLookupCall,
        filteredId: selectedVat.vatId
      }
    });
    form.one('save', () => scout.create(VatRestClient)
      .remove(selectedVat.vatId, form.widget('ReplacementField').value));
    form.open();
  }

  protected _listeningDataTypes(): string[] {
    return [VatRestClient.DATA_TYPE];
  }
}
