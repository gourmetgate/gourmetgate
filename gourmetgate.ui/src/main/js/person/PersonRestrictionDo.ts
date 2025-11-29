import {BaseDoEntity, typeName} from '@eclipse-scout/core';

@typeName('gourmetgate.PersonRestriction')
export class PersonRestrictionDo extends BaseDoEntity {
  firstName: string;
  lastName: string;
}
