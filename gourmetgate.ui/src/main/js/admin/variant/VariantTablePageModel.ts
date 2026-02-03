import {BooleanColumn, Column, icons, Menu, PageWithTable, PageWithTableModel, Table} from '@eclipse-scout/core';

export default (): PageWithTableModel => ({
  objectType: PageWithTable,
  leaf: true,
  text: '${textKey:Variants}',
  detailTable: {
    id: 'VariantTable',
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
        width: 500
      },
      {
        id: 'SingleOptionColumn',
        objectType: BooleanColumn,
        text: '${textKey:SingleOption}',
        width: 150,
      },
      {
        id: 'VariantOptionsSummaryColumn',
        objectType: Column,
        text: '${textKey:Options}',
        width: 350
      }
    ],
    menus: [
      {
        id: 'CreateVariantMenu',
        objectType: Menu,
        text: '${textKey:CreateVariant}',
        iconId: icons.PLUS,
        menuTypes: [Table.MenuType.EmptySpace]
      },
      {
        id: 'EditVariantMenu',
        objectType: Menu,
        text: '${textKey:EditVariant}',
        iconId: icons.PENCIL,
        menuTypes: [Table.MenuType.SingleSelection]
      },
      {
        id: 'DeleteVariantMenu',
        objectType: Menu,
        text: '${textKey:DeleteVariant}',
        iconId: icons.REMOVE,
        menuTypes: [Table.MenuType.SingleSelection]
      }
    ]
  }
});

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export class VariantTable extends Table {
  declare widgetMap: VariantTableWidgetMap;
  declare columnMap: VariantTableColumnMap;
}

export type VariantTableWidgetMap = {
  'CreateVariantMenu': Menu;
  'EditVariantMenu': Menu;
  'DeleteVariantMenu': Menu;
};

export type VariantTableColumnMap = {
  'IdColumn': Column;
  'NameColumn': Column;
  'SingleOptionColumn': Column;
  'VariantOptionsSummaryColumn': Column;
};
