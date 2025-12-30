import {Form, scout, WidgetModel} from "@eclipse-scout/core";
import {VatDo, VatRestClient} from "../../index";
import VatFormModel, {VatFormWidgetMap} from './VatFormModel';

export class VatForm extends Form {
  declare data: VatDo;
  declare widgetMap: VatFormWidgetMap;

  protected override _jsonModel(): WidgetModel {
    return VatFormModel();
  }

  protected override _load(): JQuery.Promise<VatDo> {
    if (this.data.vatId) {
      this.setTitle(this.session.text('EditVat'))
      return scout.create(VatRestClient).getById(this.data.vatId);
    }
    this.setTitle(this.session.text('CreateVat'))
    return $.resolvedPromise(this.data);
  }

  override importData() {
    this.widget('PercentageField').setValue(this.data.percentage)
    this.widget('DescriptionField').setValue(this.data.description)
  }

  override exportData(): VatDo {
    return scout.create(VatDo, {
      vatId: this.data?.vatId,
      percentage: this.widget('PercentageField').value.toString(),
      description: this.widget('DescriptionField').value
    });
  }

  protected override _save(data: VatDo): JQuery.Promise<void> {
    let restClient = scout.create(VatRestClient);
    return (data.vatId
      ? restClient.store(data.vatId, data)
      : restClient.create(data))
      .then(() => undefined); // drop return value to match signature
  }
}
