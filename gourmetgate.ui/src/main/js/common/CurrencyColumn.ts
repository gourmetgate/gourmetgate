import {NumberColumn, strings, TableRow} from "@eclipse-scout/core";

export class CurrencyColumn extends NumberColumn {

  static CURRENCY_PREFIX = 'CHF '

  protected override _formatValue(value: number, row?: TableRow): string {
    let stringValue = strings.asString(value);
    if (!strings.hasText(stringValue)) {
      stringValue = '0';
    }
    return CurrencyColumn.CURRENCY_PREFIX + this.formatAmount(stringValue);
  }

  protected formatAmount(rawAmount: string): string {
    let indexOfDecimal = rawAmount.indexOf('.');
    if (indexOfDecimal < 0) {
      indexOfDecimal = rawAmount.length;
      rawAmount += '.';
    }
    let digitsAfterComma = rawAmount.substring(indexOfDecimal + 1).length;
    if (digitsAfterComma > 2) {
      return rawAmount.substring(0, indexOfDecimal + 3);
    }
    return rawAmount + "0".repeat(2 - digitsAfterComma);
  }
}
