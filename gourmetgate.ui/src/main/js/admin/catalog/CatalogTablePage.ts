import {PageWithTable, PageWithTableModel} from "@eclipse-scout/core";
import CatalogTablePageModel, {CatalogTablePageTable} from "./CatalogTablePageModel";

export class CatalogTablePage extends PageWithTable {
  declare detailTable: CatalogTablePageTable;

  protected override _jsonModel(): PageWithTableModel {
    return CatalogTablePageModel();
  }


}
