import {LookupCallModel} from "@eclipse-scout/core";

export interface QueryLookupCallModel extends LookupCallModel<string> {
  /**
   * Endpoint url of the query endpoint
   */
  endpointUrl?: string;
  /**
   * Name of the key property in the JSON data.
   */
  keyPropertyName?: string;
  /**
   * Name of the text property in the JSON data.
   */
  textPropertyName?: string;
  /**
   * Name of the restriction object that is set to the query endpoint.
   */
  restrictionPropertyName?: string;
  /**
   * Name of the result property in the JSON response.
   */
  resultsPropertyName?: string;
  /**
   * Id that is filtered out of the lookup rows.
   */
  filteredId?: string;
}
