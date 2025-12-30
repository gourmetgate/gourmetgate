import {Form, scout, WidgetModel} from "@eclipse-scout/core";
import CategoryFormModel, {CategoryFormWidgetMap} from './CategoryFormModel';
import {CategoryDo, CategoryRestClient} from "../../index";

export class CategoryForm extends Form {
  declare data: CategoryDo;
  declare widgetMap: CategoryFormWidgetMap;

  protected override _jsonModel(): WidgetModel {
    return CategoryFormModel();
  }

  protected override _load(): JQuery.Promise<CategoryDo> {
    if (this.data.categoryId) {
      this.setTitle(this.session.text('EditCategory'))
      return scout.create(CategoryRestClient).getById(this.data.categoryId);
    }
    this.setTitle(this.session.text('CreateCategory'))
    return $.resolvedPromise(this.data);
  }

  override importData() {
    this.widget('NameField').setValue(this.data.name)
  }

  override exportData(): CategoryDo {
    return scout.create(CategoryDo, {
      categoryId: this.data?.categoryId,
      name: this.widget('NameField').value
    });
  }

  protected override _save(data: CategoryDo): JQuery.Promise<void> {
    let restClient = scout.create(CategoryRestClient);
    return (data.categoryId
      ? restClient.store(data.categoryId, data)
      : restClient.create(data))
      .then(() => undefined); // drop return value to match signature
  }
}
