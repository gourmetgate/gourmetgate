import {Column, icons, Menu, PageWithTable, PageWithTableModel, Table} from '@eclipse-scout/core';
import {PercentageColumn} from '../../index';

export default (): PageWithTableModel => ({
  objectType: PageWithTable,
  leaf: true,
  text: '${textKey:Vat}',
  detailTable: {
    id: 'VatTable',
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
        id: 'PercentageColumn',
        objectType: PercentageColumn,
        text: '${textKey:Percentage}',
        width: 200
      },
      {
        id: 'DescriptionColumn',
        objectType: Column,
        text: '${textKey:Description}',
        width: 500,
      }
    ],
    menus: [
      {
        id: 'CreateVatMenu',
        objectType: Menu,
        text: '${textKey:CreateVat}',
        iconId: icons.PLUS,
        menuTypes: [Table.MenuType.EmptySpace]
      },
      {
        id: 'EditVatMenu',
        objectType: Menu,
        text: '${textKey:EditVat}',
        iconId: icons.PENCIL,
        menuTypes: [Table.MenuType.SingleSelection]
      },
      {
        id: 'DeleteVatMenu',
        objectType: Menu,
        text: '${textKey:DeleteVat}',
        iconId: icons.REMOVE,
        menuTypes: [Table.MenuType.SingleSelection]
      }
    ]
  }
});

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export class VatTable extends Table {
  declare widgetMap: VatTableWidgetMap;
  declare columnMap: VatTableColumnMap;
}

export type VatTableWidgetMap = {
  'CreateVatMenu': Menu;
  'EditVatMenu': Menu;
  'DeleteVatMenu': Menu;
};

export type VatTableColumnMap = {
  'IdColumn': Column;
  'PercentageColumn': PercentageColumn;
  'DescriptionColumn': Column;
};
