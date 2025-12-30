import {
  AggregateTableControl,
  BooleanColumn,
  Column,
  icons,
  Menu,
  NumberColumn,
  PageWithTable,
  PageWithTableModel,
  SearchFormTableControl,
  Table
} from '@eclipse-scout/core';
import {PersonSearchForm} from '../index';
import {PersonSearchFormWidgetMap} from './PersonSearchFormModel';

export default (): PageWithTableModel => ({
  objectType: PageWithTable,
  leaf: true,
  text: '${textKey:Persons}',
  detailTable: {
    objectType: Table,
    columns: [
      {
        id: 'FirstNameColumn',
        objectType: Column,
        text: '${textKey:FirstName}',
        width: 200
      },
      {
        id: 'LastNameColumn',
        objectType: Column,
        text: '${textKey:LastName}',
        width: 200
      },
      {
        id: 'SalaryColumn',
        objectType: NumberColumn,
        text: '${textKey:Salary}',
        width: 120
      },
      {
        id: 'ExternalColumn',
        objectType: BooleanColumn,
        text: '${textKey:External}',
        width: 100
      },
      {
        id: 'PersonIdColumn',
        objectType: Column,
        displayable: false
      },
    ],
    menus: [
      {
        id: 'EditPersonMenu',
        objectType: Menu,
        text: '${textKey:EditPerson}',
        iconId: icons.PENCIL,
        menuTypes: [Table.MenuType.SingleSelection]
      },
      {
        id: 'CreatePersonMenu',
        objectType: Menu,
        text: '${textKey:CreatePerson}',
        iconId: icons.PLUS
      },
      {
        id: 'DeletePersonMenu',
        objectType: Menu,
        text: '${textKey:DeletePerson}',
        iconId: icons.REMOVE,
        menuTypes: [
          Table.MenuType.SingleSelection
        ]
      }
    ],
    tableControls: [
      {
        id: 'SearchFormTableControl',
        objectType: SearchFormTableControl,
        form: {
          id: 'SearchForm',
          objectType: PersonSearchForm
        }
      },
      {
        id: 'AggregateTableControl',
        objectType: AggregateTableControl
      }
    ]
  }
});

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export class PersonTablePageTable extends Table {
  declare widgetMap: PersonTablePageTableWidgetMap;
  declare columnMap: PersonTablePageTableColumnMap;
}

export type PersonTablePageTableWidgetMap = {
  'EditPersonMenu': Menu;
  'CreatePersonMenu': Menu;
  'DeletePersonMenu': Menu;
  'SearchFormTableControl': SearchFormTableControl;
  'SearchForm': PersonSearchForm;
  'AggregateTableControl': AggregateTableControl;
} & PersonSearchFormWidgetMap;

export type PersonTablePageTableColumnMap = {
  'FirstNameColumn': Column;
  'LastNameColumn': Column;
  'SalaryColumn': NumberColumn;
  'ExternalColumn': BooleanColumn;
  'PersonIdColumn': Column;
};
