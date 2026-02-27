import {Form, InitModelOf, scout, Status, WidgetModel} from "@eclipse-scout/core";
import {UserDo} from "../../data/user/UserDo";
import {UserRestClient} from "./UserRestClient";
import UserFormModel, {UserFormWidgetMap} from './UserFormModel';
import ItemFormModel from "../item/ItemFormModel";

export class UserForm extends Form {
  declare widgetMap: UserFormWidgetMap;

  private userNameField;
  private passwordField;
  private repeatPasswordField;

  protected override _init(model: InitModelOf<this>) {
    super._init(model);
    this.userNameField = this.widget('UsernameField');
    this.passwordField = this.widget('PasswordField');
    this.repeatPasswordField = this.widget('RepeatPassowrdField');
  }

  protected override _jsonModel(): WidgetModel {
    return UserFormModel();
  }

  override importData() {
    this.userNameField.setValue(this.data.userName);
  }

  override exportData(): UserDo {
    return scout.create(UserDo, {
      userId: this.data?.userId,
      userName: this.userNameField.value,
      password: this.passwordField.value
    });
  }


  override validate(): JQuery.Promise<Status> {
    if (this.passwordField.getValue() !== this.repeatPasswordField.getValue()) {
      throw new Error();
    }
    return super.validate();
  }

  protected override _save(data: UserDo): JQuery.Promise<void> {
    let restClient = scout.create(UserRestClient);
    return (data.userId
      ? restClient.store(data.userId, data)
      : restClient.create(data))
      .then(() => undefined); // drop return value to match signature
  }
}
