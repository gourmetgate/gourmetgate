import {Outline, OutlineModel} from '@eclipse-scout/core';
import AdminOutlineModel from './AdminOutlineModel';

export class AdminOutline extends Outline {

  protected override _jsonModel(): OutlineModel {
    return AdminOutlineModel();
  }
}
