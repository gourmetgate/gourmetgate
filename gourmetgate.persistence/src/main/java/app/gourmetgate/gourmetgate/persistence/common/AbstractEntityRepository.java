package app.gourmetgate.gourmetgate.persistence.common;

import app.gourmetgate.gourmetgate.data.common.IEntityRepository;
import app.gourmetgate.gourmetgate.data.status.Status;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import static app.gourmetgate.gourmetgate.persistence.JooqSqlService.jooq;
import static org.jooq.impl.DSL.lower;

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

    create(newRecord);
    return fromRecordToDo(newRecord, dataObject);
  }

  @Override
  public int store(UUID id, DO dataObject) {
    return store(id, toNewRecord(dataObject));
  }

  public void create(RECORD record) {
    jooq()
      .insertInto(getTable())
      .set(record)
      .execute();
  }

  @Override
  public int store(UUID id, RECORD record) {
    return jooq()
      .update(getTable())
      .set(record)
      .where(getIdColumn().eq(id))
      .execute();
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

  // HELPER Methods

  protected Condition getTextMatchingCondition(Field<String> textColumn, String text) {
    String textWithWildcards = "%" + text + "%";
    return lower(textColumn).like(lower(textWithWildcards));
  }
}
