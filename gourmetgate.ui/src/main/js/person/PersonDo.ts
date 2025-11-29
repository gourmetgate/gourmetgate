import {BaseDoEntity, typeName} from '@eclipse-scout/core';

@typeName('gourmetgate.Person')
export class PersonDo extends BaseDoEntity {
  id: string;
  firstName: string;
  lastName: string;
  salary: number;
  external: boolean;
}
