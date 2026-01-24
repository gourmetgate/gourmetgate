import {ObjectOrModel, PageWithTable, scout, TreeNodeModel} from "@eclipse-scout/core";
import VatTablePageModel, {VatTable} from './VatTablePageModel';
import {QueryRestClient, TableRowWithEntity, VatDo} from "../../index";

export class VatTablePage extends PageWithTable {
  declare detailTable: VatTable;


  protected override _jsonModel(): TreeNodeModel {
    return VatTablePageModel();
  }

  protected override _loadTableData(): JQuery.Promise<VatDo[]> {
    return scout.create(QueryRestClient).queryData({
      vatRestriction: {}
    }).then(response => response.vat);
  }

  protected override _transformTableDataToTableRows(vat: VatDo[]): ObjectOrModel<TableRowWithEntity>[] {
    return vat.map(v => this._createCategoryRow(v))
  }

  protected _createCategoryRow(vat: VatDo): ObjectOrModel<TableRowWithEntity> {
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
}
