import {
  CancelMenu,
  CheckBoxField,
  Column,
  FormField,
  FormModel,
  GroupBox,
  icons,
  Menu,
  NumberColumn,
  OkMenu,
  StringField,
  Table,
  TableField,
  TreeBox
} from '@eclipse-scout/core';
import {CurrencyColumn, ItemLookupCall} from '../../index';

export default (): FormModel => ({
  displayHint: 'dialog',
  rootGroupBox: {
    id: 'MainBox',
    objectType: GroupBox,
    gridColumnCount: 1,
    fields: [
      {
        id: 'DetailsBox',
        objectType: GroupBox,
        gridColumnCount: 1,
        fields: [
          {
            id: 'NameField',
            objectType: StringField,
            label: '${textKey:Name}',
            maxLength: 80,
            mandatory: true
          },
          {
            id: 'SingleOptionField',
            objectType: CheckBoxField,
            label: '${textKey:SingleOption}'
          },
          {
            id: 'VariantOptionsField',
            objectType: TableField,
            label: '${textKey:Options}',
            labelPosition: FormField.LabelPosition.TOP,
            mandatory: true,
            gridDataHints: {
              h: 5
            },
            table: {
              id: 'VariantOptionTable',
              objectType: Table,
              autoResizeColumns: true,
              textFilterEnabled: false,
              columns: [
                {
                  id: 'VariantOptionIdColumn',
                  objectType: Column,
                  label: '${textKey:Id}',
                  width: 10,
                  visible: false
                },
                {
                  id: 'NameColumn',
                  objectType: Column,
                  text: '${textKey:Name}',
                  width: 60,
                  editable: true,
                  mandatory: true
                },
                {
                  id: 'AdditionalPriceColumn',
                  objectType: CurrencyColumn,
                  text: '${textKey:AdditionalPrice}',
                  width: 40,
                  editable: true,
                  mandatory: true
                },
              ],
              menus: [
                {
                  id: 'AddMenu',
                  objectType: Menu,
                  text: '${textKey:AddOption}',
                  iconId: icons.PLUS,
                  menuTypes: [Table.MenuType.EmptySpace]
                },
                {
                  id: 'DeleteMenu',
                  objectType: Menu,
                  text: '${textKey:DeleteOption}',
                  iconId: icons.REMOVE,
                  menuTypes: [Table.MenuType.SingleSelection, Table.MenuType.MultiSelection]
                }
              ]
            }
          },
          {
            id: 'AssignedItemsField',
            objectType: TreeBox,
            label: '${textKey:AvailableFor}',
            labelPosition: FormField.LabelPosition.TOP,
            lookupCall: ItemLookupCall,
            gridDataHints: {
              h: 4
            }
          }
        ]
      }
    ],
    menus: [
      {
        id: 'OkMenu',
        objectType: OkMenu,
        tooltipText: '${textKey:OkMenuTooltip}'
      },
      {
        id: 'CancelMenu',
        objectType: CancelMenu,
        tooltipText: '${textKey:CancelMenuTooltip}'
      }
    ]
  }
});

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export type VariantFormWidgetMap = {
  'MainBox': GroupBox;
  'DetailsBox': GroupBox;
  'NameField': StringField;
  'SingleOptionField': CheckBoxField;
  'VariantOptionsField': TableField;
  'VariantOptionTable': VariantOptionTable;
  'AssignedItemsField': TreeBox<any>;
  'OkMenu': OkMenu;
  'CancelMenu': CancelMenu;
} & VariantOptionTableWidgetMap;

export class VariantOptionTable extends Table {
  declare widgetMap: VariantOptionTableWidgetMap;
  declare columnMap: VariantOptionTableColumnMap;
}

export type VariantOptionTableWidgetMap = {
  'AddMenu': Menu;
  'DeleteMenu': Menu;
};

export type VariantOptionTableColumnMap = {
  'VariantOptionIdColumn': Column;
  'NameColumn': Column;
  'AdditionalPriceColumn': NumberColumn;
};
