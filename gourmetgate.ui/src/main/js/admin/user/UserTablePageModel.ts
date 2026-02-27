import {Column, icons, Menu, PageWithTable, PageWithTableModel, Table} from '@eclipse-scout/core';

export default (): PageWithTableModel => ({
  objectType: PageWithTable,
  leaf: true,
  text: '${textKey:Users}',
  detailTable: {
    id: 'UserTable',
    objectType: Table,
    autoResizeColumns: true,

    columns: [
      {
        id: 'IdColumn',
        objectType: Column,
        text: '${textKey:Id}',
        width: 200,
        visible: false
      },
      {
        id: 'Username',
        objectType: Column,
        text: '${textKey:Username}',
        width: 300
      }
    ],
    menus: [
      {
        id: 'CreateUserMenu',
        objectType: Menu,
        text: '${textKey:CreateUser}',
        iconId: icons.PLUS,
        menuTypes: [Table.MenuType.EmptySpace]
      },
      {
        id: 'EditUserMenu',
        objectType: Menu,
        text: '${textKey:EditItem}',
        iconId: icons.PENCIL,
        menuTypes: [Table.MenuType.SingleSelection]
      },
      {
        id: 'DeleteUserMenu',
        objectType: Menu,
        text: '${textKey:DeleteItem}',
        iconId: icons.REMOVE,
        menuTypes: [Table.MenuType.SingleSelection]
      }
    ]
  }
});

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export class UserTable extends Table {
  declare widgetMap: UserTableWidgetMap;
  declare columnMap: UserTableColumnMap;
}

export type UserTableWidgetMap = {
  'CreateUserMenu': Menu;
  'EditUserMenu': Menu;
  'DeleteUserMenu': Menu;
};

export type UserTableColumnMap = {
  'IdColumn': Column;
  'Username': Column;
};
