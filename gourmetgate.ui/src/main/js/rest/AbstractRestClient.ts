import {ajax, AjaxError, BaseDoEntity, ObjectWithType, systems} from '@eclipse-scout/core';

export abstract class AbstractRestClient<TItem extends BaseDoEntity, TItemResponse extends BaseDoEntity> implements ObjectWithType {

  objectType: string;
  targetUrl: string;

  protected constructor(targetEndpoint: string) {
    this.targetUrl = systems.getOrCreate().getEndpointUrl(targetEndpoint, targetEndpoint) + '/';
  }

  public getAll(): JQuery.Promise<TItem[], AjaxError> {
    return ajax.getDataObject(this.targetUrl)
      .then(r => this._mapListResponse(r));
  }

  public getById(id: string): JQuery.Promise<TItem, AjaxError> {
    return ajax.getDataObject(this.targetUrl + id);
  }

  public create(data: BaseDoEntity): JQuery.Promise<TItem, AjaxError> {
    return ajax.postDataObject(this.targetUrl, data);
  }

  public store(id: string, data: BaseDoEntity): JQuery.Promise<TItem, AjaxError> {
    return ajax.putDataObject(this.targetUrl + id, data);
  }

  public remove(id: string): JQuery.Promise<void, AjaxError> {
    return ajax.removeDataObject(this.targetUrl + id);
  }

  protected abstract _mapListResponse(response: TItemResponse): TItem[];
}
