import {DesktopModel, Menu} from '@eclipse-scout/core';
import {DataOutline, Desktop} from '../index';

export default (): DesktopModel => ({
  id: 'gourmetgate.Desktop',
  title: '${textKey:ApplicationTitle}',
  objectType: Desktop,
  logoUrl: 'img/eclipse_scout_logo.svg',
  nativeNotificationDefaults: {
    iconId: 'img/eclipse_scout_logo.png'
  },
  outline: {
    objectType: DataOutline
  },
  menus: [
    {
      id: 'ThemeMenu',
      objectType: Menu,
      text: '${textKey:Theme}',
      childActions: [
        {
          id: 'DefaultThemeMenu',
          objectType: Menu,
          text: 'Default'
        },
        {
          id: 'DarkThemeMenu',
          objectType: Menu,
          text: 'Dark'
        }
      ]
    },
    {
      id: 'AboutMenu',
      objectType: Menu,
      text: '${textKey:About}',
      cssClass: 'about-menu'
    }
  ]
});

export type DesktopWidgetMap = {
  'ThemeMenu': Menu;
  'DefaultThemeMenu': Menu;
  'DarkThemeMenu': Menu;
  'AboutMenu': Menu;
};
