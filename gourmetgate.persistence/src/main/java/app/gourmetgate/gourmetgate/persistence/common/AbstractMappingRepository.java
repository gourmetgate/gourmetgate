package app.gourmetgate.gourmetgate.persistence.common;

import org.eclipse.scout.rt.dataobject.DoEntity;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import static app.gourmetgate.gourmetgate.persistence.JooqSqlService.jooq;

public abstract class AbstractMappingRepository<TABLE extends Table<RECORD>, RECORD extends Record, DO extends DoEntity> {

  public abstract TABLE getTable();

  public abstract Field<UUID> getIdAColumn();

  public abstract Field<UUID> getIdBColumn();

  public Optional<DO> getById(UUID idA, UUID idB) {
    return Optional.ofNullable(jooq()
        .selectFrom(getTable())
        .where(
          getIdAColumn().eq(idA),
          getIdBColumn().eq(idB))
        .fetchOne())
      .map(this::toNewDo);
  }

  // make a public getter with proper naming in the subclass
  protected Stream<DO> getByIdA(UUID idA) {
    return getBy(getIdAColumn().eq(idA));
  }

  // make a public getter with proper naming in the subclass
  protected Stream<DO> getByIdB(UUID idB) {
    return getBy(getIdBColumn().eq(idB));
  }

  protected Stream<DO> getBy(Condition... conditions) {
    return jooq()
      .selectFrom(getTable())
      .where(conditions)
      .fetchStream()
      .map(this::toNewDo);
  }

  // make a public getter with proper naming in the subclass
  protected void replaceByIdA(UUID idA, List<UUID> idBs) {
    jooq().deleteFrom(getTable())
      .where(getIdAColumn().eq(idA))
      .execute();

    idBs.forEach(idB -> {
      RECORD record = jooq().newRecord(getTable());
      record.set(getIdAColumn(), idA);
      record.set(getIdBColumn(), idB);
      create(record);
    });
  }

  // make a public getter with proper naming in the subclass
  protected void replaceByIdB(UUID idB, List<UUID> idAs) {
    jooq().deleteFrom(getTable())
      .where(getIdBColumn().eq(idB))
      .execute();

    idAs.forEach(idA -> {
      RECORD record = jooq().newRecord(getTable());
      record.set(getIdAColumn(), idA);
      record.set(getIdBColumn(), idB);
      create(record);
    });
  }

  protected void create(RECORD rec) {
    jooq()
      .insertInto(getTable())
      .set(rec)
      .execute();
  }

  protected void deleteByIdA(UUID idA) {
    jooq()
      .deleteFrom(getTable())
      .where(getIdAColumn().eq(idA))
      .execute();
  }

  protected void deleteByIdB(UUID idB) {
    jooq()
      .deleteFrom(getTable())
      .where(getIdBColumn().eq(idB))
      .execute();
  }

  protected abstract RECORD toNewRecord(DO sourceDo);

  protected abstract DO toNewDo(RECORD sourceRecord);

  protected abstract DoEntityBeanMappings<DO, RECORD> mappings();

  protected RECORD fromDoToRecord(DO cDo, RECORD cBean) {
    mappings().fromDoToRecord(cDo, cBean);
    return cBean;
  }

  protected DO fromRecordToDo(RECORD cBean, DO cDo) {
    mappings().fromEntityBeanToDo(cBean, cDo);
    return cDo;
  }
}
