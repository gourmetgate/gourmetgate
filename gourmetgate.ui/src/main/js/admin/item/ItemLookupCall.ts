import {QueryLookupCall} from "../../index";

export class ItemLookupCall extends QueryLookupCall {

  constructor() {
    super();

    this.keyPropertyName = 'itemId';
    this.textPropertyName = 'name';
    this.restrictionPropertyName = 'itemRestriction';
    this.resultsPropertyName = 'items';
  }
}
