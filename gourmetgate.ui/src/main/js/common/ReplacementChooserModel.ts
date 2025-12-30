import {FormModel, ObjectOrModel} from "@eclipse-scout/core";
import {QueryLookupCall} from "./QueryLookupCall";

export interface ReplacementChooserModel extends FormModel {
  replacementLookupCall?: ObjectOrModel<QueryLookupCall>
  prompt?: string;
}
