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
        gridColumnCount: 1,
        fields: [
          {
            id: 'UsernameField',
            objectType: StringField,
            label: '${textKey:Username}',
            mandatory: true
          },
          {
            id: 'PasswordField',
            objectType: StringField,
            label: '${textKey:Password}',
            mandatory: true
          },
          {
            id: 'RepeatPassowrdField',
            objectType: StringField,
            label: '${textKey:RepeatPassword}',
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

export type UserFormWidgetMap = {
  'MainBox': GroupBox;
  'DetailsBox': GroupBox;
  'UsernameField': StringField;
  'PasswordField': StringField;
  'RepeatPassowrdField': StringField;
  'OkMenu': OkMenu;
  'CancelMenu': CancelMenu;
};
