import {ObjectOrModel, scout, Table, TreeNodeModel} from "@eclipse-scout/core";
import CategoryTablePageModel, {CategoryTable} from './CategoryTablePageModel';
import {
  AdminTablePage,
  CategoryDo,
  CategoryForm,
  CategoryLookupCall,
  CategoryRestClient,
  ReplacementChooserForm,
  TableRowWithEntity
} from "../../index";

export class CategoryTablePage extends AdminTablePage {

  declare detailTable: CategoryTable;

  protected override _jsonModel(): TreeNodeModel {
    return CategoryTablePageModel();
  }

  protected override _initDetailTable(table: Table) {
    super._initDetailTable(table);

    let createCategoryMenu = this.detailTable.widget('CreateCategoryMenu');
    createCategoryMenu.on('action', this._onCreateCategoryMenuAction.bind(this));

    let editCategoryMenu = this.detailTable.widget('EditCategoryMenu');
    editCategoryMenu.on('action', this._onEditCategoryMenuAction.bind(this));

    let deleteCategoryMenu = this.detailTable.widget('DeleteCategoryMenu');
    deleteCategoryMenu.on('action', this._onDeleteCategoryMenuAction.bind(this));
  }

  protected override _loadTableData(): JQuery.Promise<CategoryDo[]> {
    return scout.create(CategoryRestClient).getAll();
  }

  protected override _transformTableDataToTableRows(tableData: CategoryDo[]): ObjectOrModel<TableRowWithEntity>[] {
    return tableData
      .map(category => this._createCategoryRow(category));
  }

  protected _createCategoryRow(category: CategoryDo): ObjectOrModel<TableRowWithEntity> {
    return {
      id: category.categoryId,
      entity: category,
      cells: [
        category.categoryId,
        category.name
      ]
    }
  }

  protected _getSelectedCategory(): CategoryDo {
    let selection = this.detailTable.selectedRow() as TableRowWithEntity;
    return selection?.entity as CategoryDo;
  }

  protected _createCategoryForm(): CategoryForm {
    return scout.create(CategoryForm, {
      parent: this.outline
    });
  }

  protected _onCreateCategoryMenuAction() {
    let form = this._createCategoryForm();
    let emptyCategory = scout.create(CategoryDo);
    form.setData(emptyCategory);
    form.open();
  }

  protected _onEditCategoryMenuAction() {
    let form = this._createCategoryForm();
    form.setData(this._getSelectedCategory());
    form.open();
  }

  protected _onDeleteCategoryMenuAction() {
    let selectedCategory = this._getSelectedCategory();
    let form = scout.create(ReplacementChooserForm, {
      parent: this.parent,
      title: this.session.text('DeleteX', selectedCategory.name),
      prompt: this.session.text('ChooseReplacementForX', selectedCategory.name),
      replacementLookupCall: {
        objectType: CategoryLookupCall,
        filteredId: selectedCategory.categoryId
      }
    });
    form.one('save', () => scout.create(CategoryRestClient)
      .remove(selectedCategory.categoryId, form.widget('ReplacementField').value));
    form.open();
  }

  protected _listeningDataTypes(): string[] {
    return [CategoryRestClient.DATA_TYPE];
  }
}
