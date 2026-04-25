import {BaseDoEntity, typeName} from "@eclipse-scout/core";
import {UserDo} from "./UserDo";

@typeName('gourmetgate.UserResponseDo')
export class UserResponseDo extends BaseDoEntity {
  users: UserDo[];
}
