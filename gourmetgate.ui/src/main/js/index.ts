import {ObjectFactory} from '@eclipse-scout/core';
import * as self from './index';

export * from './App';
export * from './objectFactories';
export * from './desktop/Desktop';

export * from './data/VatDo';
export * from './data/ItemDo';
export * from './data/CategoryDo';
export * from './data/CategoryResponseDo';
export * from './data/CategoryRestrictionDo';
export * from './data/ItemRestrictionDo';
export * from './data/VatRestrictionDo';
export * from './data/QueryRestrictionDo';
export * from './data/QueryResponseDo';

export * from './rest/AbstractRestClient';
export * from './rest/QueryRestClient';

export * from './common/TableRowWithEntity';
export * from './common/CurrencyColumn';
export * from './common/PercentageColumn';
export * from './common/MessageBoxHelper';
export * from './common/QueryLookupCall';
export * from './common/ReplacementChooserModel';
export * from './common/ReplacementChooserForm';

export * from './admin/AdminOutline';
export * from './admin/AdminTablePage';
export * from './admin/item/ItemTablePage';
export * from './admin/category/CategoryRestClient';
export * from './admin/category/CategoryTablePage';
export * from './admin/category/CategoryForm';
export * from './admin/category/CategoryLookupCall';
export * from './admin/vat/VatTablePage';
export * from './rest/AbstractItemResponse';
export * from './rest/AbstractPersonRestClient';
export * from './person/PersonDo';
export * from './person/PersonForm';
export * from './person/PersonResponse';
export * from './person/PersonRestClient';
export * from './person/PersonRestrictionDo';
export * from './person/PersonSearchForm';
export * from './person/PersonTablePage';

export default self;
ObjectFactory.get().registerNamespace('gourmetgate', self);
