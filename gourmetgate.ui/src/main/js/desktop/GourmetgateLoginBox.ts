import {LoginBox} from "@eclipse-scout/core";

export class GourmetgateLoginBox extends LoginBox {
  constructor() {
    console.log('test');
    super();
    this.authUrl = 'api/auth';
  }
}
