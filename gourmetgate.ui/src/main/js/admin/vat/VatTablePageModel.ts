import {Column, PageWithTable, PageWithTableModel, Table} from '@eclipse-scout/core';
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
        width: 500
      }
    ]
  }
});

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export class VatTable extends Table {
  declare columnMap: VatTableColumnMap;
}

export type VatTableColumnMap = {
  'IdColumn': Column;
  'NameColumn': Column;
  'DescriptionColumn': Column;
};
