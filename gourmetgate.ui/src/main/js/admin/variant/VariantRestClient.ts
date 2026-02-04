import {AbstractRestClient, VariantDo} from "../../index";
import {VariantResponseDo} from "../../data/VariantResponseDo";

export class VariantRestClient extends AbstractRestClient<VariantDo, VariantResponseDo> {

  static override DATA_TYPE = 'variant'

  constructor() {
    super(VariantRestClient.DATA_TYPE);
  }

  protected _mapListResponse(response: VariantResponseDo): VariantDo[] {
    return response.variants;
  }
}
