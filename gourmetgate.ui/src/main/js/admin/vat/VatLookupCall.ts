import {QueryLookupCall} from "../../index";

export class VatLookupCall extends QueryLookupCall {

  constructor() {
    super();

    this.keyPropertyName = 'vatId';
    this.textPropertyName = 'percentage';
    this.restrictionPropertyName = 'vatRestriction';
    this.resultsPropertyName = 'vat';
  }
}
