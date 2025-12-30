import {QueryLookupCall} from "../../index";

export class CategoryLookupCall extends QueryLookupCall {

  constructor() {
    super();

    this.keyPropertyName = 'categoryId';
    this.textPropertyName = 'name';
    this.restrictionPropertyName = 'categoryRestriction';
    this.resultsPropertyName = 'categories';
  }
}
