import {ajax, systems} from "@eclipse-scout/core";
import {QueryResponseDo, QueryRestrictionDo} from "./../index";

export class QueryRestClient {

  targetUrl: string;

  constructor() {
    this.targetUrl = systems.getOrCreate()
      .getEndpointUrl('query', 'query') + '/';
  }

  public queryData(restriction: QueryRestrictionDo): JQuery.Promise<QueryResponseDo> {
    return ajax.postDataObject(this.targetUrl, restriction)
      .then((res: QueryResponseDo) => res);
  }
}
