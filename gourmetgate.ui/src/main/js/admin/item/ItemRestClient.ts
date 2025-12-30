import {AbstractRestClient, ItemDo, ItemResponseDo} from "../../index";

export class ItemRestClient extends AbstractRestClient<ItemDo, ItemResponseDo> {

  static override DATA_TYPE = 'items'

  constructor() {
    super(ItemRestClient.DATA_TYPE);
  }

  protected _mapListResponse(response: ItemResponseDo): ItemDo[] {
    return response.items;
  }
}
