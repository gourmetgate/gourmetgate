import {ObjectFactory} from '@eclipse-scout/core';
import * as self from './index';

export * from './App';
export * from './objectFactories';
export * from './desktop/Desktop';

export * from './data/CategoryDo';
export * from './data/CategoryResponseDo';
export * from './data/CategoryRestrictionDo';
export * from './data/ItemDo';
export * from './data/ItemRestrictionDo';
export * from './data/ItemResponseDo';
export * from './data/VariantDo';
export * from './data/VariantOptionDo';
export * from './data/VariantResponseDo';
export * from './data/VariantRestrictionDo';
export * from './data/VatDo';
export * from './data/VatRestrictionDo';
export * from './data/VatResponseDo';
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
export * from './admin/item/ItemRestClient';
export * from './admin/item/ItemTablePage';
export * from './admin/item/ItemForm';
export * from './admin/item/ItemLookupCall';
export * from './admin/category/CategoryRestClient';
export * from './admin/category/CategoryTablePage';
export * from './admin/category/CategoryForm';
export * from './admin/category/CategoryLookupCall';
export * from './admin/variant/VariantLookupCall';
export * from './admin/variant/VariantForm';
export * from './admin/variant/VariantRestClient';
export * from './admin/variant/VariantTablePage';
export * from './admin/vat/VatLookupCall';
export * from './admin/vat/VatRestClient';
export * from './admin/vat/VatTablePage';
export * from './admin/vat/VatForm';

export default self;
ObjectFactory.get().registerNamespace('gourmetgate', self);
