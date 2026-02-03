import {Form, InitModelOf, scout, WidgetModel} from "@eclipse-scout/core";
import {VariantDo, VariantOptionDo, VariantRestClient} from "../../index";
import VariantFormModel, {VariantFormWidgetMap} from './VariantFormModel';
import $ from "jquery";

export class VariantForm extends Form {
  declare widgetMap: VariantFormWidgetMap;
  declare data: VariantDo;

  protected override _jsonModel(): WidgetModel {
    return VariantFormModel();
  }

  protected override _init(model: InitModelOf<this>) {
    super._init(model);

    let table = this.widget('VariantOptionTable');
    table.widget('AddMenu').on('action', () => this._onAddOptionMenu());
    table.widget('DeleteMenu').on('action', () => this._onDeleteOptionMenu());
  }

  protected override _load(): JQuery.Promise<VariantDo> {
    if (this.data.variantId) {
      this.setTitle(this.session.text('EditVariant'))
      return scout.create(VariantRestClient).getById(this.data.variantId);
    }
    this.setTitle(this.session.text('CreateVariant'))
    return $.resolvedPromise(this.data);
  }

  override importData() {
    this.widget('NameField').setValue(this.data.name);
    this.widget('SingleOptionField').setValue(this.data.singleOption);
    this._importOptions();
    this.widget('AssignedItemsField').setValue(this.data.itemIds);
  }

  protected _importOptions() {
    this.data.variantOptions?.forEach(option => {
      this.widget('VariantOptionTable').insertRows({
        id: option.variantOptionId,
        cells: [
          option.variantOptionId,
          option.name,
          option.additionalPrice
        ]
      });
    });
  }

  override exportData(): VariantDo {
    return scout.create(VariantDo, {
      variantId: this.data?.variantId,
      name: this.widget('NameField').value,
      singleOption: this.widget('SingleOptionField').value,
      variantOptions: this._exportOptions(),
      itemIds: this.widget('AssignedItemsField').value
    });
  }

  protected _exportOptions(): VariantOptionDo[] {
    let table = this.widget('VariantOptionTable');
    return table.rows
      .map(row => scout.create(VariantOptionDo, {
        variantOptionId: table.columnById('VariantOptionIdColumn').cellValue(row),
        variantId: this.data.variantId,
        name: table.columnById('NameColumn').cellValue(row),
        additionalPrice: table.columnById('AdditionalPriceColumn').cellValue(row).toString()
      }));
  }

  protected override _save(data: VariantDo): JQuery.Promise<void> {
    let restClient = scout.create(VariantRestClient);
    return (data.variantId
      ? restClient.store(data.variantId, data)
      : restClient.create(data))
      .then(() => undefined); // drop return value to match signature
  }

  protected _onAddOptionMenu() {
    this.widget('VariantOptionTable').insertRow({
      cells: [
        null,
        this.session.text('NewOption'),
        0
      ]
    });
  }

  protected _onDeleteOptionMenu() {
    let table = this.widget('VariantOptionTable');
    table.deleteRows(table.selectedRows);
  }
}
