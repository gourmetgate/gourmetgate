import {AdminTablePage} from "../AdminTablePage";
import UserTablePageModel, {UserTable} from './UserTablePageModel';
import {ObjectOrModel, scout, Table, TreeNodeModel} from "@eclipse-scout/core";
import {MessageBoxHelper} from "../../common/MessageBoxHelper";
import {TableRowWithEntity} from "../../common/TableRowWithEntity";
import {UserForm} from "./UserForm";
import {UserDo} from "../../data/user/UserDo";
import {UserRestClient} from "./UserRestClient";
import {UserResponseDo} from "../../data/user/UserResponseDo";

export class UserTablePage extends AdminTablePage {
  protected override _listeningDataTypes(): string[] {
    return [UserRestClient.DATA_TYPE];
  }
  declare detailTable: UserTable;

  protected override _jsonModel(): TreeNodeModel {
    return UserTablePageModel();
  }
  protected override _initDetailTable(table: Table) {
    super._initDetailTable(table);

    let createuserMenu = this.detailTable.widget('CreateUserMenu');
    createuserMenu.on('action', this._onCreateUserMenuAction.bind(this));

    let edituserMenu = this.detailTable.widget('EditUserMenu');
    edituserMenu.on('action', this._onEditUserMenuAction.bind(this));

    let deleteuserMenu = this.detailTable.widget('DeleteUserMenu');
    deleteuserMenu.on('action', this._onDeleteUserMenuAction.bind(this));
  }

  protected override _loadTableData(): JQuery.Promise<QueryResponseDo> {
    return scout.create(QueryRestClient).queryData({
            categoryRestriction: {},
            itemRestriction: {},
            variantRestriction: {},
            vatRestriction: {},
            userRestriction: {}
    })
  }

  protected override _transformTableDataToTableRows(tableData: QueryResponseDo): ObjectOrModel<TableRowWithEntity>[] {
    return tableData.users
      .map(userDo => this._createUserRow(userDo));
  }
  protected _createUserRow(user: UserDo): ObjectOrModel<TableRowWithEntity> {
    return {
      id: user.userId,
      entity: user,
      cells: [
        user.userId,
        user.userName
      ]
    };
  }


  protected _getSelectedUser(): UserDo {
    let selection = this.detailTable.selectedRow() as TableRowWithEntity;
    return selection?.entity as UserDo;
  }

  protected _createUserForm(): UserForm {
    return scout.create(UserForm, {
      parent: this.outline
    });
  }

  protected _onCreateUserMenuAction() {
    let form = this._createUserForm();
    let emptyuser = scout.create(UserDo);
    form.setData(emptyuser);
    form.open();
  }

  protected _onEditUserMenuAction() {
    let form = this._createUserForm();
    form.setData(this._getSelectedUser());
    form.open();
  }
  protected _onDeleteUserMenuAction() {
    scout.create(MessageBoxHelper).createDeleteConfirmationMessageBox(this.session)
      .then(yes => {
        if (yes) {
          scout.create(UserRestClient).remove(this._getSelectedUser().userId);
        }
      });
  }
}
