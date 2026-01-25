import {EventHandler, InitModelOf, PageWithTable} from "@eclipse-scout/core";
import {DataChangeEvent} from "../index";

export abstract class AdminTablePage extends PageWithTable {
  protected _dataChangeListener: EventHandler<DataChangeEvent>;

  protected override _init(model: InitModelOf<this>) {
    super._init(model);

    this._dataChangeListener = this._onDataChange.bind(this);
    this.session.desktop.on('dataChange', this._dataChangeListener);
  }

  protected _onDataChange(event: DataChangeEvent) {
    if (this._listeningDataTypes().includes(event.dataType)) {
      this.reloadPage();
    }
  }

  protected abstract _listeningDataTypes(): string[];
}
