import {BooleanColumn, Column, icons, Menu, PageWithTable, PageWithTableModel, Table} from '@eclipse-scout/core';
import {CurrencyColumn, PercentageColumn} from '../../index';

export default (): PageWithTableModel => ({
  objectType: PageWithTable,
  leaf: true,
  text: '${textKey:Items}',
  detailTable: {
    id: 'ItemTable',
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
        id: 'NameColumn',
        objectType: Column,
        text: '${textKey:Name}',
        width: 300
      },
      {
        id: 'CategoryNameColumn',
        objectType: Column,
        text: '${textKey:Category}',
        width: 150,
        grouped: true,
        sortActive: true,
        sortAscending: true
      },
      {
        id: 'AvailableColumn',
        objectType: BooleanColumn,
        text: '${textKey:Available}',
        width: 80
      },
      {
        id: 'PriceColumn',
        objectType: CurrencyColumn,
        text: '${textKey:Price}',
        width: 150
      },
      {
        id: 'CostColumn',
        objectType: CurrencyColumn,
        text: '${textKey:Cost}',
        width: 150
      },
      {
        id: 'VatColumn',
        objectType: PercentageColumn,
        text: '${textKey:Vat}',
        width: 150
      },
      {
        id: 'VariantsColumn',
        objectType: Column,
        text: '${textKey:Variants}',
        width: 200
      }
    ],
    menus: [
      {
        id: 'CreateItemMenu',
        objectType: Menu,
        text: '${textKey:CreateItem}',
        iconId: icons.PLUS,
        menuTypes: [Table.MenuType.EmptySpace]
      },
      {
        id: 'EditItemMenu',
        objectType: Menu,
        text: '${textKey:EditItem}',
        iconId: icons.PENCIL,
        menuTypes: [Table.MenuType.SingleSelection]
      },
      {
        id: 'DeleteItemMenu',
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

export class ItemTable extends Table {
  declare widgetMap: ItemTableWidgetMap;
  declare columnMap: ItemTableColumnMap;
}

export type ItemTableWidgetMap = {
  'CreateItemMenu': Menu;
  'EditItemMenu': Menu;
  'DeleteItemMenu': Menu;
};

export type ItemTableColumnMap = {
  'IdColumn': Column;
  'NameColumn': Column;
  'CategoryNameColumn': Column;
  'AvailableColumn': BooleanColumn;
  'PriceColumn': CurrencyColumn;
  'CostColumn': CurrencyColumn;
  'VatColumn': PercentageColumn;
  'VariantsColumn': Column;
};
