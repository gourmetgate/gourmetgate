import {Desktop} from './index';
import {scout} from '@eclipse-scout/core';
import {GourmetgateLoginBox} from './desktop/GourmetgateLoginBox';

scout.addObjectFactories({
  'Desktop': () => new Desktop(),
  'LoginBox': () => new GourmetgateLoginBox()
});
