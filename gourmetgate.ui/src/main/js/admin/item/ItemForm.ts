import {Form, scout, WidgetModel} from "@eclipse-scout/core";
import {ItemDo, ItemRestClient} from "../../index";
import ItemFormModel, {ItemFormWidgetMap} from './ItemFormModel';

export class ItemForm extends Form {
  declare widgetMap: ItemFormWidgetMap;
  declare data: ItemDo;

  protected override _jsonModel(): WidgetModel {
    return ItemFormModel();
  }

  protected override _load(): JQuery.Promise<ItemDo> {
    if (this.data.itemId) {
      this.setTitle(this.session.text('EditItem'))
      return scout.create(ItemRestClient).getById(this.data.itemId);
    }
    this.setTitle(this.session.text('CreateItem'))
    return $.resolvedPromise(this.data);
  }

  override importData() {
    this.widget('NameField').setValue(this.data.name);
    this.widget('CategoryField').setValue(this.data.categoryId);
    this.widget('VatField').setValue(this.data.vatId);
    this.widget('PriceField').setValue(this.data.price);
    this.widget('CostField').setValue(this.data.cost);
    this.widget('AvailableField').setValue(this.data.available);
  }

  override exportData(): ItemDo {
    return scout.create(ItemDo, {
      itemId: this.data?.itemId,
      categoryId: this.widget('CategoryField').value,
      vatId: this.widget('VatField').value,
      name: this.widget('NameField').value,
      price: this.widget('PriceField').value,
      cost: this.widget('CostField').value,
      available: this.widget('AvailableField').value,
    });
  }

  protected override _save(data: ItemDo): JQuery.Promise<void> {
    let restClient = scout.create(ItemRestClient);
    return (data.itemId
      ? restClient.store(data.itemId, data)
      : restClient.create(data))
      .then(() => undefined); // drop return value to match signature
  }
}
