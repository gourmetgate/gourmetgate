import {Column, icons, Menu, PageWithTable, PageWithTableModel, Table} from '@eclipse-scout/core';

export default (): PageWithTableModel => ({
  objectType: PageWithTable,
  leaf: true,
  text: '${textKey:Categories}',
  detailTable: {
    id: 'CategoryTable',
    objectType: Table,
    autoResizeColumns: true,
    columns: [
      {
        id: 'IdColumn',
        objectType: Column,
        text: '${textKey:Id}',
        width: 100,
        visible: false
      },
      {
        id: 'NameColumn',
        objectType: Column,
        text: '${textKey:Name}',
        width: 400
      }
    ],
    menus: [
      {
        id: 'CreateCategoryMenu',
        objectType: Menu,
        text: '${textKey:CreateCategory}',
        iconId: icons.PLUS,
        menuTypes: [Table.MenuType.EmptySpace]
      },
      {
        id: 'EditCategoryMenu',
        objectType: Menu,
        text: '${textKey:EditCategory}',
        iconId: icons.PENCIL,
        menuTypes: [Table.MenuType.SingleSelection]
      },
      {
        id: 'DeleteCategoryMenu',
        objectType: Menu,
        text: '${textKey:DelteCategory}',
        iconId: icons.REMOVE,
        menuTypes: [Table.MenuType.SingleSelection]
      }
    ]
  }
});

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export class CategoryTable extends Table {
  declare widgetMap: CategoryTableWidgetMap;
  declare columnMap: CategoryTableColumnMap;
}

export type CategoryTableWidgetMap = {
  'CreateCategoryMenu': Menu;
  'EditCategoryMenu': Menu;
  'DeleteCategoryMenu': Menu;
};

export type CategoryTableColumnMap = {
  'IdColumn': Column;
  'NameColumn': Column;
};
