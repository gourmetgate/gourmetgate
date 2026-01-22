import {ajax, systems} from "@eclipse-scout/core";
import {CategoryDo, CategoryResponseDo} from "../../index";

export class CategoryRestClient {

  targetUrl: string;

  constructor() {
    this.targetUrl = systems.getOrCreate().getEndpointUrl('categories', 'categories') + '/';
  }

  public getAllCategories(onlyAvailable: boolean): JQuery.Promise<CategoryDo[]> {
    return ajax.getDataObject(this.targetUrl + '?onlyAvailable=' + onlyAvailable)
      .then((res: CategoryResponseDo) => res.categories);
  }
}
