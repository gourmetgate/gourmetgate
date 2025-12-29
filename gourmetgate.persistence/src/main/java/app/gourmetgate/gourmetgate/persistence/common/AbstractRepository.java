package app.gourmetgate.gourmetgate.persistence.common;

import org.eclipse.scout.rt.dataobject.DoEntity;
import org.jooq.Record;
import org.jooq.Table;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import static app.gourmetgate.gourmetgate.persistence.JooqSqlService.jooq;

public abstract class AbstractRepository<TABLE extends Table<RECORD>, RECORD extends Record, DO extends DoEntity> implements IBaseService<TABLE, RECORD, DO> {

  protected abstract DoEntityBeanMappings<DO, RECORD> mappings();

  /**
  * Returns true if a record with the provided id exists using the specified
  * context
  */
  protected boolean exists(UUID id) {
    return jooq().fetchExists(jooq()
        .select()
        .from(getTable())
        .where(getIdColumn().eq(id)));
  }

  @Override
  public RECORD newRecord() {
    return jooq().newRecord(getTable());
  }

  @Override
  public int remove(UUID id) {
    return jooq()
        .deleteFrom(getTable())
        .where(getIdColumn().eq(id))
        .execute();
  }

  @Override
  public Optional<RECORD> get(UUID id) {
    return Optional.ofNullable(
        jooq()
          .selectFrom(getTable())
          .where(getIdColumn().eq(id))
          .fetchOne());
  }

  @Override
  public Stream<RECORD> getAll() {
    return jooq()
        .selectFrom(getTable())
        .fetchStream();
  }

  @Override
  public void store(UUID id, RECORD record) {
    if (exists(id)) {
      jooq()
        .update(getTable())
        .set(record)
        .where(getIdColumn().eq(id))
        .execute();
    } else {
      jooq()
        .insertInto(getTable())
        .set(record)
        .execute();
    }
  }

  protected RECORD fromDoToRecord(DO cDo, RECORD cBean) {
    mappings().fromDoToRecord(cDo, cBean);
    return cBean;
  }

  protected DO fromRecordToDo(RECORD cBean, DO cDo) {
    mappings().fromEntityBeanToDo(cBean, cDo);
    return cDo;
  }
}
