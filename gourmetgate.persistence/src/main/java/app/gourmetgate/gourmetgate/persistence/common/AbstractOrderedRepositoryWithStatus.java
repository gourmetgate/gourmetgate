package app.gourmetgate.gourmetgate.persistence.common;

import app.gourmetgate.gourmetgate.data.status.Status;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import static app.gourmetgate.gourmetgate.persistence.JooqSqlService.jooq;

public abstract class AbstractOrderedRepositoryWithStatus<TABLE extends Table<RECORD>, RECORD extends Record, DO extends DoEntity> implements IBaseService<TABLE, RECORD, DO> {

  protected abstract DoEntityBeanMappings<DO, RECORD> mappings();


  public abstract Field<OffsetDateTime> getSortColumn();

  public abstract Field<String> getStatusColumn();

  @Override
  public RECORD newRecord() {
    return jooq().newRecord(getTable());
  }

  @Override
  public int remove(UUID id) {
    return jooq()
      .update(getTable())
      .set(getStatusColumn(), Status.DELETED.id)
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
      .where(getStatusColumn().eq(Status.ACTIVE.id))
      .orderBy(getSortColumn())
      .fetchStream();
  }

  @Override
  public void store(UUID id, RECORD record) {
    int affectedRows = jooq()
      .update(getTable())
      .set(record)
      .where(getIdColumn().eq(id))
      .execute();

    if (affectedRows < 1) {
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
