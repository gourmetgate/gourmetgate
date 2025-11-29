import {CancelMenu, CheckBoxField, FormModel, GroupBox, NumberField, OkMenu, StringField} from '@eclipse-scout/core';

export default (): FormModel => ({
  displayHint: 'view',
  rootGroupBox: {
    id: 'MainBox',
    objectType: GroupBox,
    fields: [
      {
        id: 'DetailBox',
        objectType: GroupBox,
        fields: [
          {
            id: 'FirstNameField',
            objectType: StringField,
            label: '${textKey:FirstName}',
            maxLength: 200
          },
          {
            id: 'LastNameField',
            objectType: StringField,
            label: '${textKey:LastName}',
            maxLength: 200,
            mandatory: true
          },
          {
            id: 'SalaryField',
            objectType: NumberField,
            label: '${textKey:Salary}',
            minValue: 0,
            maxValue: 99999999
          },
          {
            id: 'ExternalField',
            objectType: CheckBoxField,
            label: '${textKey:External}'
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

export type PersonFormWidgetMap = {
  'MainBox': GroupBox;
  'DetailBox': GroupBox;
  'FirstNameField': StringField;
  'LastNameField': StringField;
  'SalaryField': NumberField;
  'ExternalField': CheckBoxField;
  'OkMenu': OkMenu;
  'CancelMenu': CancelMenu;
};
