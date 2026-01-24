import {Column, PageWithTable, PageWithTableModel, Table} from '@eclipse-scout/core';

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
    ]
  }
});

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export class CategoryTable extends Table {
  declare columnMap: CategoryTableColumnMap;
}

export type CategoryTableColumnMap = {
  'IdColumn': Column;
  'NameColumn': Column;
};
