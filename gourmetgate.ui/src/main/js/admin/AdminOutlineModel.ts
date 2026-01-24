import {Outline, OutlineModel} from '@eclipse-scout/core';
import {CategoryTablePage, ItemTablePage, VatTablePage} from '../index';

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
      objectType: VatTablePage
    }
  ]
});

export type AdminOutlineWidgetMap = {
  'gourmetgate.AdminOutline': Outline;
};
