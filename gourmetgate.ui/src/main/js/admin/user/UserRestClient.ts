import {AbstractRestClient} from "../../rest/AbstractRestClient";
import {UserDo} from "../../data/user/UserDo";
import {UserResponseDo} from "../../data/user/UserResponseDo";

export class UserRestClient extends AbstractRestClient<UserDo, UserResponseDo>{
  static override DATA_TYPE = 'user';

  constructor() {
    super(UserRestClient.DATA_TYPE);
  }

  protected _mapListResponse(response: UserResponseDo): UserDo[] {
    return response.users;
  }
}
