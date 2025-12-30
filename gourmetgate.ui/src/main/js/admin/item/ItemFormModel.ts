import {CancelMenu, CheckBoxField, FormModel, GroupBox, OkMenu, SmartField, StringField} from '@eclipse-scout/core';
import {CategoryLookupCall, VatLookupCall} from "./../../index";

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
            objectType: StringField,
            label: '${textKey:Price}',
            mandatory: true
          },
          {
            id: 'CostField',
            objectType: StringField,
            label: '${textKey:Cost}'
          },
          {
            id: 'AvailableField',
            objectType: CheckBoxField,
            label: '${textKey:Available}',
            mandatory: true
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
  'PriceField': StringField;
  'CostField': StringField;
  'AvailableField': CheckBoxField;
  'OkMenu': OkMenu;
  'CancelMenu': CancelMenu;
};
