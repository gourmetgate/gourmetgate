import {
  CancelMenu,
  CheckBoxField,
  FormField,
  FormModel,
  GroupBox,
  NumberField,
  OkMenu,
  SmartField,
  StringField,
  TreeBox
} from '@eclipse-scout/core';
import {CategoryLookupCall, VatLookupCall} from "./../../index";
import {VariantLookupCall} from '../../index';

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
            id: 'CategoryField',
            objectType: SmartField<string>,
            label: '${textKey:Category}',
            lookupCall: CategoryLookupCall,
            mandatory: true
          },
          {
            id: 'VatField',
            objectType: SmartField<string>,
            label: '${textKey:Vat}',
            lookupCall: VatLookupCall,
            mandatory: true
          },
          {
            id: 'PriceField',
            objectType: NumberField,
            label: '${textKey:Price}',
            mandatory: true,
            gridDataHints: {
              horizontalAlignment: -1
            }
          },
          {
            id: 'CostField',
            objectType: NumberField,
            label: '${textKey:Cost}',
            gridDataHints: {
              horizontalAlignment: -1
            }
          },
          {
            id: 'AvailableField',
            objectType: CheckBoxField,
            label: '${textKey:Available}'
          },
          {
            id: 'AssignedVariantsField',
            objectType: TreeBox,
            label: '${textKey:Variants}',
            labelPosition: FormField.LabelPosition.TOP,
            lookupCall: VariantLookupCall,
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

export type ItemFormWidgetMap = {
  'MainBox': GroupBox;
  'DetailsBox': GroupBox;
  'NameField': StringField;
  'CategoryField': SmartField<string>;
  'VatField': SmartField<string>;
  'PriceField': NumberField;
  'CostField': NumberField;
  'AvailableField': CheckBoxField;
  'AssignedVariantsField': TreeBox<any>;
  'OkMenu': OkMenu;
  'CancelMenu': CancelMenu;
};
