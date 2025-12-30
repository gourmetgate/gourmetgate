import {CancelMenu, FormModel, GroupBox, NumberField, OkMenu, StringField} from '@eclipse-scout/core';

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
            id: 'PercentageField',
            objectType: NumberField,
            label: '${textKey:Percentage}',
            maxLength: 80,
            mandatory: true,
            gridDataHints: {
              horizontalAlignment: -1
            }
          },
          {
            id: 'DescriptionField',
            objectType: StringField,
            label: '${textKey:Description}',
            multilineText: true,
            maxLength: 255,
            gridDataHints: {
              h: 2
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

export type VatFormWidgetMap = {
  'MainBox': GroupBox;
  'DetailsBox': GroupBox;
  'PercentageField': NumberField;
  'DescriptionField': StringField;
  'OkMenu': OkMenu;
  'CancelMenu': CancelMenu;
};
