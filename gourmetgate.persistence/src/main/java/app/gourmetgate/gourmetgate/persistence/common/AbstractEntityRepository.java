package app.gourmetgate.gourmetgate.persistence.common;

import app.gourmetgate.gourmetgate.data.common.IEntityRepository;
import app.gourmetgate.gourmetgate.data.status.Status;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.platform.exception.ProcessingException;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import static app.gourmetgate.gourmetgate.persistence.JooqSqlService.jooq;

public abstract class AbstractEntityRepository<TABLE extends Table<RECORD>, RECORD extends Record, DO extends DoEntity> extends AbstractRepository<TABLE, RECORD, DO> implements IEntityRepository<DO> {

  public abstract Field<OffsetDateTime> getSortColumn();

  public abstract Field<String> getStatusColumn();

  @Override
  public Stream<DO> getAllActive() {
    return getAll().map(this::toNewDo);
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
  public Optional<DO> getById(UUID id) {
    return get(id).map(this::toNewDo);
  }

  @Override
  public DO create(DO dataObject) {
    RECORD newRecord = newRecord();
    UUID newId = UUID.randomUUID(); // Always generate new id on insert

    fromDoToRecord(dataObject, newRecord);
    newRecord.set(getIdColumn(), newId);

    store(newId, newRecord);
    return fromRecordToDo(newRecord, dataObject);
  }

  @Override
  public void store(UUID id, DO dataObject) {
    store(id, toNewRecord(dataObject));
  }

  @Override
  public void store(UUID id, RECORD record) {
    int affectedRows = jooq()
      .update(getTable())
      .set(record)
      .where(getIdColumn().eq(id))
      .execute();

    if (affectedRows < 1) {
      throw new ProcessingException("No record found to be updated");
    }
  }

  @Override
  public int delete(UUID id) {
    return jooq()
      .update(getTable())
      .set(getStatusColumn(), Status.DELETED.id)
      .where(getIdColumn().eq(id))
      .execute();
  }

  protected abstract RECORD toNewRecord(DO sourceDo);

  protected abstract DO toNewDo(RECORD sourceRecord);
}
