import {Outline, OutlineModel} from '@eclipse-scout/core';
import {CategoryTablePage, ItemTablePage, VariantTablePage, VatTablePage} from '../index';
import {UserTablePage} from "./user/UserTablePage";

export default (): OutlineModel => ({
  id: 'gourmetgate.AdminOutline',
  title: '${textKey:AdminOutlineTitle}',
  objectType: Outline,
  nodes: [
    {
      objectType: ItemTablePage
    },
    {
      objectType: CategoryTablePage
    },
    {
      objectType: VariantTablePage
    },
    {
      objectType: VatTablePage
    },
    {
      objectType: UserTablePage
    }
  ]
});

export type AdminOutlineWidgetMap = {
  'gourmetgate.AdminOutline': Outline;
};
