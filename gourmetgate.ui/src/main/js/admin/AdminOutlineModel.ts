import {Outline, OutlineModel} from '@eclipse-scout/core';
import {CatalogTablePage, PersonTablePage} from '../index';

export default (): OutlineModel => ({
  id: 'gourmetgate.AdminOutline',
  title: '${textKey:AdminOutlineTitle}',
  objectType: Outline,
  nodes: [
    {
      objectType: CatalogTablePage
    },
    {
      objectType: PersonTablePage
    }
  ]
});

export type AdminOutlineWidgetMap = {
  'gourmetgate.AdminOutline': Outline;
};
