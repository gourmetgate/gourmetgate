package app.gourmetgate.gourmetgate.db.setup.table;

import app.gourmetgate.gourmetgate.db.setup.IDatabaseObject;

public interface IGenerateTable extends IDatabaseObject {

  String getSchemaName();

  String createSQLInternal();

}
