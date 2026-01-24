import {BooleanColumn, Column, PageWithTable, PageWithTableModel, Table} from '@eclipse-scout/core';
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
        width: 200,
        grouped: true,
        sortActive: true,
        sortAscending: true
      },
      {
        id: 'AvailableColumn',
        objectType: BooleanColumn,
        text: '${textKey:Available}',
        width: 100
      },
      {
        id: 'PriceColumn',
        objectType: CurrencyColumn,
        text: '${textKey:Price}',
        width: 200
      },
      {
        id: 'CostColumn',
        objectType: CurrencyColumn,
        text: '${textKey:Cost}',
        width: 200
      },
      {
        id: 'VatColumn',
        objectType: PercentageColumn,
        text: '${textKey:Vat}',
        width: 200
      }
    ]
  }
});

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export class ItemTable extends Table {
  declare columnMap: ItemTableColumnMap;
}

export type ItemTableColumnMap = {
  'IdColumn': Column;
  'NameColumn': Column;
  'CategoryNameColumn': Column;
  'AvailableColumn': BooleanColumn;
  'PriceColumn': CurrencyColumn;
  'CostColumn': CurrencyColumn;
  'VatColumn': PercentageColumn;
};
