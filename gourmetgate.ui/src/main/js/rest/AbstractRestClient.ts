import {ajax, AjaxError, BaseDoEntity, ObjectWithType, scout, systems} from '@eclipse-scout/core';

export abstract class AbstractRestClient<TItem extends BaseDoEntity, TItemResponse extends BaseDoEntity> implements ObjectWithType {

  static DATA_TYPE: string = null;

  objectType: string;
  targetUrl: string;
  dataType: string;

  protected constructor(dataType: string) {
    this.dataType = dataType;
    this.targetUrl = systems.getOrCreate().getEndpointUrl(dataType, dataType) + '/';
  }

  public getAll(): JQuery.Promise<TItem[], AjaxError> {
    return ajax.getDataObject(this.targetUrl)
      .then(r => this._mapListResponse(r));
  }

  public getById(id: string): JQuery.Promise<TItem, AjaxError> {
    return ajax.getDataObject(this.targetUrl + id);
  }

  public create(data: BaseDoEntity): JQuery.Promise<TItem, AjaxError> {
    return ajax.postDataObject(this.targetUrl, data)
      .then(r => this._triggerDataChange(r));
  }

  public store(id: string, data: BaseDoEntity): JQuery.Promise<TItem, AjaxError> {
    return ajax.putDataObject(this.targetUrl + id, data)
      .then(r => this._triggerDataChange(r));
  }

  public remove(id: string): JQuery.Promise<void, AjaxError> {
    return ajax.removeDataObject(this.targetUrl + id)
      .then(() => this._triggerDataChange());
  }

  protected _triggerDataChange<TData>(data?: TData): TData {
    scout.getSession().desktop.dataChange({
      dataType: this.dataType,
      data
    });
    return data;
  }

  protected abstract _mapListResponse(response: TItemResponse): TItem[];
}
