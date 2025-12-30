import {MessageBox, MessageBoxes, ObjectWithType, Session} from "@eclipse-scout/core";

export class MessageBoxHelper implements ObjectWithType {
  objectType: string;

  public createDeleteConfirmationMessageBox(session: Session): JQuery.Promise<boolean> {
    return MessageBoxes.openYesNo(session.desktop, session.text('DeleteConfirmationTextNoItemList'))
      .then(button => button === MessageBox.Buttons.YES);
  }
}
