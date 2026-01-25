import {AbstractRestClient, CategoryDo, CategoryResponseDo} from "../../index";

export class CategoryRestClient extends AbstractRestClient<CategoryDo, CategoryResponseDo> {

  static override DATA_TYPE = 'categories'

  constructor() {
    super(CategoryRestClient.DATA_TYPE);
  }

  protected _mapListResponse(response: CategoryResponseDo): CategoryDo[] {
    return response.categories;
  }
}
