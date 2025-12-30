import {CloseMenu, FormModel, GroupBox, LabelField, OkMenu, SmartField} from '@eclipse-scout/core';

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
            id: 'PromptField',
            objectType: LabelField,
            labelVisible: false
          },
          {
            id: 'ReplacementField',
            objectType: SmartField<string>,
            label: '${textKey:Replacement}',
            mandatory: true
          }
        ]
      }
    ],
    menus: [
      {
        id: 'DeleteMenu',
        objectType: OkMenu,
        text: '${textKey:DeleteMenu}',
        tooltipText: '${textKey:DeleteConfirmationText}'
      },
      {
        id: 'CloseMenu',
        objectType: CloseMenu,
        tooltipText: '${textKey:CloseButton}'
      }
    ]
  }
});

/* **************************************************************************
* GENERATED WIDGET MAPS
* **************************************************************************/

export type ReplacementChooserFormWidgetMap = {
  'MainBox': GroupBox;
  'DetailsBox': GroupBox;
  'PromptField': LabelField;
  'ReplacementField': SmartField<string>;
  'DeleteMenu': OkMenu;
  'CloseMenu': CloseMenu;
};
