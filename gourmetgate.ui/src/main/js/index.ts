import {ObjectFactory} from '@eclipse-scout/core';
import * as self from './index';

export * from './App';
export * from './objectFactories';
export * from './desktop/Desktop';
export * from './admin/AdminOutline';
export * from './admin/catalog/CatalogTablePage';
export * from './rest/AbstractItemResponse';
export * from './rest/AbstractRestClient';
export * from './person/PersonDo';
export * from './person/PersonForm';
export * from './person/PersonResponse';
export * from './person/PersonRestClient';
export * from './person/PersonRestrictionDo';
export * from './person/PersonSearchForm';
export * from './person/PersonTablePage';

export default self;
ObjectFactory.get().registerNamespace('gourmetgate', self);
