import {BaseDoEntity, typeName} from "@eclipse-scout/core";

@typeName('gourmetgate.UserDo')
export class UserDo extends BaseDoEntity {
  userId: string;
  userName: string;
  password: string;
}
