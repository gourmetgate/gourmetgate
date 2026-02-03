import {BaseDoEntity, typeName} from "@eclipse-scout/core";
import {VariantDo} from "./../index";

@typeName("gourmetgate.VariantResponse")
export class VariantResponseDo extends BaseDoEntity {
  variants: VariantDo[];
}
