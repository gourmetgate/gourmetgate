import {QueryLookupCall} from "../../index";

export class VariantLookupCall extends QueryLookupCall {

  constructor() {
    super();

    this.keyPropertyName = 'variantId';
    this.textPropertyName = 'name';
    this.restrictionPropertyName = 'variantRestriction';
    this.resultsPropertyName = 'variants';
  }
}
