import {BaseDoEntity, typeName} from "@eclipse-scout/core";
import {VatDo} from "./../index";

@typeName("gourmetgate.VatResponse")
export class VatResponseDo extends BaseDoEntity {
  vat: VatDo[];
}
