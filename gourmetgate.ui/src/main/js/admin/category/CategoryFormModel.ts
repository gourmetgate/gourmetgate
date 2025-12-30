import {CancelMenu, FormModel, GroupBox, OkMenu, StringField} from '@eclipse-scout/core';

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
        fields: [
          {
            id: 'NameField',
            objectType: StringField,
            label: '${textKey:Name}',
            maxLength: 80,
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

export type CategoryFormWidgetMap = {
  'MainBox': GroupBox;
  'DetailsBox': GroupBox;
  'NameField': StringField;
  'OkMenu': OkMenu;
  'CancelMenu': CancelMenu;
};
