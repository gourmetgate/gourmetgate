import {AbstractRestClient, VatDo, VatResponseDo} from "../../index";
import {ajax, AjaxError} from "@eclipse-scout/core";

export class VatRestClient extends AbstractRestClient<VatDo, VatResponseDo> {

  static override DATA_TYPE = 'vat'

  constructor() {
    super(VatRestClient.DATA_TYPE);
  }

  public override remove(id: string, replacementId: string): JQuery.Promise<void, AjaxError> {
    return ajax.removeDataObject(this.targetUrl + id + '?replacementId=' + replacementId)
      .then(() => this._triggerDataChange());
  }

  protected _mapListResponse(response: VatResponseDo): VatDo[] {
    return response.vat;
  }
}
