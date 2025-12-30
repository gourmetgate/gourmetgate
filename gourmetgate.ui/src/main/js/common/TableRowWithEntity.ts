import {BaseDoEntity, TableRow} from "@eclipse-scout/core";

export interface TableRowWithEntity extends TableRow {
  entity: BaseDoEntity;
}
