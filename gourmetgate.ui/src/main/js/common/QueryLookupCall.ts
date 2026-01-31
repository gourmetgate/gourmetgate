import {AjaxCall, arrays, LookupCall, LookupResult, LookupRow, scout, strings, systems} from "@eclipse-scout/core";
import {QueryLookupCallModel} from "./QueryLookupCallModel";
import $ from "jquery";
import {QueryResponseDo, QueryRestrictionDo} from "../index";
import Deferred = JQuery.Deferred;

export class QueryLookupCall extends LookupCall<string> implements QueryLookupCallModel {
  declare model: QueryLookupCallModel;

  endpointUrl: string;
  keyPropertyName: string;
  textPropertyName: string;
  restrictionPropertyName: string;
  resultsPropertyName: string;
  filteredId: string;

  protected _ajaxCall: AjaxCall;
  protected _deferred: Deferred<LookupResult<string>, { abort: boolean }>;
  protected _keyRestriction: string;
  protected _textRestriction: string;

  constructor() {
    super();

    this.endpointUrl = systems.getOrCreate().getEndpointUrl('query', 'query') + '/';
    this.keyPropertyName = null;
    this.textPropertyName = null;
    this.restrictionPropertyName = null;
    this.resultsPropertyName = null;
    this.filteredId = null;
  }

  protected override _getAll(): JQuery.Promise<LookupResult<string>> {
    return this._call();
  }

  protected override _getByText(text: string): JQuery.Promise<LookupResult<string>> {
    this._textRestriction = text;
    return this._call();
  }

  protected override _getByKey(key: string): JQuery.Promise<LookupResult<string>> {
    this._keyRestriction = key;
    return this._call();
  }

  protected _call(): JQuery.Promise<LookupResult<string>> {
    this._deferred = $.Deferred();
    this._ajaxCall = this._createAjaxCall();

    this._ajaxCall.call()
      .then((data: QueryResponseDo, textStatus, jqXHR) => {
        let lookupRows = this._createLookupRowsFromDo(data)
        this._deferred.resolve(this._createLookupResult(lookupRows));
      })
      .catch(ajaxError => {
        this._deferred.resolve(this._createLookupResult([], this.session.text('ErrorWhileLoadingData')));
      });

    return this._deferred.promise();
  }

  override abort() {
    this._deferred?.reject({
      abort: true
    });
    this._ajaxCall?.abort();
    super.abort();
  }

  protected _createLookupRowsFromDo(data: QueryResponseDo): LookupRow<string>[] {
    return arrays.ensure(data[this.resultsPropertyName])
      .filter(entity => entity[this.keyPropertyName] !== this.filteredId)
      .map(entity => scout.create(LookupRow<string>, {
        key: entity[this.keyPropertyName],
        text: entity[this.textPropertyName]
      }));
  }

  protected _createAjaxCall(): AjaxCall {
    let url = this.endpointUrl;
    let restriction = this._buildRestriction();
    let data = restriction ? JSON.stringify(restriction) : null;
    let ajaxOptions = {
      method: 'POST',
      data: data,
      dataType: 'json',
      contentType: 'application/json; charset=UTF-8',
      cache: false,
      url: url,
      timeout: 0
    };
    return scout.create(AjaxCall, {
      ajaxOptions: ajaxOptions,
      name: 'QueryLookupCall',
      retryIntervals: [100, 500, 500, 500]
    });
  }

  protected _buildRestriction(): QueryRestrictionDo {
    let restriction = scout.create(QueryRestrictionDo);
    let entityRestriction = {};
    if (strings.hasText(this._keyRestriction)) {
      entityRestriction[this.keyPropertyName] = this._keyRestriction;
    } else if (strings.hasText(this._textRestriction)) {
      entityRestriction[this.textPropertyName] = this._textRestriction;
    }
    restriction[this.restrictionPropertyName] = entityRestriction;
    return restriction;
  }
}
