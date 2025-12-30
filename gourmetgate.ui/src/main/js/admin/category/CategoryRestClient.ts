import {AbstractRestClient, CategoryDo, CategoryResponseDo} from "../../index";
import {ajax, AjaxError} from "@eclipse-scout/core";

export class CategoryRestClient extends AbstractRestClient<CategoryDo, CategoryResponseDo> {

  static override DATA_TYPE = 'categories'

  constructor() {
    super(CategoryRestClient.DATA_TYPE);
  }

  public override remove(id: string, replacementId: string): JQuery.Promise<void, AjaxError> {
    return ajax.removeDataObject(this.targetUrl + id + '?replacementId=' + replacementId)
      .then(() => this._triggerDataChange());
  }

  protected _mapListResponse(response: CategoryResponseDo): CategoryDo[] {
    return response.categories;
  }
}
