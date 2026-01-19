import {BooleanColumn, Column, PageWithTable, PageWithTableModel, Table} from '@eclipse-scout/core';

export default (): PageWithTableModel => ({
  objectType: PageWithTable,
  leaf: true,
  text: '${textKey:ProductCatalog}',
  detailTable: {
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
        id: 'AvailableColumn',
        objectType: BooleanColumn,
        text: '${textKey:Available}',
        width: 100
      },
      {
        id: 'PriceColumn',
        objectType: Column,
        text: '${textKey:Price}',
        width: 200
      },
      {
        id: 'CostColumn',
        objectType: Column,
        text: '${textKey:Cost}',
        width: 200
      },
      {
        id: 'VatColumn',
        objectType: Column,
        text: '${textKey:Vat}',
        width: 200
      }
    ]
  }
});

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export class CatalogTablePageTable extends Table {
  declare columnMap: CatalogTablePageTableColumnMap;
}

export type CatalogTablePageTableColumnMap = {
  'IdColumn': Column;
  'NameColumn': Column;
  'AvailableColumn': BooleanColumn;
  'PriceColumn': Column;
  'CostColumn': Column;
  'VatColumn': Column;
};
