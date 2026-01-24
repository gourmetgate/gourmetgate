import {AbstractRestClient, CategoryDo, CategoryResponseDo} from "../../index";

export class CategoryRestClient extends AbstractRestClient<CategoryDo, CategoryResponseDo> {

  constructor() {
    super('categories');
  }

  protected _mapListResponse(response: CategoryResponseDo): CategoryDo[] {
    return response.categories;
  }
}
