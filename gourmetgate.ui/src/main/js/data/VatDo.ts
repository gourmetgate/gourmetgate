import {BaseDoEntity, typeName} from "@eclipse-scout/core";

@typeName('gourmetgate.Vat')
export class VatDo extends BaseDoEntity {
  vatId: string;
  percentage: string;
  description: string;
}
