import {Form, InitModelOf, WidgetModel} from "@eclipse-scout/core";
import {QueryLookupCall, ReplacementChooserModel} from "./../index";
import ReplacementChooserFormModel, {ReplacementChooserFormWidgetMap} from './ReplacementChooserFormModel';

export class ReplacementChooserForm extends Form implements ReplacementChooserModel {
  declare model: ReplacementChooserModel;
  declare widgetMap: ReplacementChooserFormWidgetMap;

  replacementLookupCall: QueryLookupCall;
  prompt: string;

  protected override _jsonModel(): WidgetModel {
    return ReplacementChooserFormModel();
  }

  protected override _init(model: InitModelOf<this>) {
    super._init(model);
    this.widget('ReplacementField').setLookupCall(this.replacementLookupCall);
    this.widget('PromptField').setValue(this.prompt);
  }
}
