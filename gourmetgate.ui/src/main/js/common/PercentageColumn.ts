import {Column, TableRow} from "@eclipse-scout/core";

export class PercentageColumn extends Column {

  protected override _formatValue(value: string, row?: TableRow): string | JQuery.Promise<string> {
    let formatted = super._formatValue(value, row);
    return formatted + ' %';
  }
}
