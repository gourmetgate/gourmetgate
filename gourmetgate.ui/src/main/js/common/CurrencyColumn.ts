import {Column, strings, TableRow} from "@eclipse-scout/core";

export class CurrencyColumn extends Column {

  static CURRENCY_PREFIX = 'CHF '

  protected override _formatValue(value: string, row?: TableRow): string | JQuery.Promise<string> {
    value = strings.asString(value); // ensure string value
    if (!strings.hasText(value)) {
      value = '0';
    }
    return CurrencyColumn.CURRENCY_PREFIX + this.formatAmount(value);
  }

  protected formatAmount(rawAmount: string): string {
    if (rawAmount.indexOf('.') < 0) {
      rawAmount += '.';
    }
    let digitsAfterComma = rawAmount.substring(rawAmount.indexOf('.') + 1).length;
    return rawAmount + "0".repeat(2 - digitsAfterComma)
  }
}
