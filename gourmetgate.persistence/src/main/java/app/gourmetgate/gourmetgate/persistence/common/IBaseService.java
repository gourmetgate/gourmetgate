package app.gourmetgate.gourmetgate.persistence.common;

import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@ApplicationScoped
public interface IBaseService<TABLE extends Table<RECORD>, RECORD extends Record, DO extends DoEntity> {

  /**
   * @return the table object associated with this service.
   */
  TABLE getTable();

  /**
   * @return the id column for the table object associated with this service.
   */
  Field<UUID> getIdColumn();

  /**
   * Deletes the record with the specified id
   *
   * @return the number of records deleted
   */
  int remove(UUID id);

  /**
   * Gets the record for the specified id.
   *
   * @return the record for the id given or an empty {@link Optional} if the id could not be found.
   */
  Optional<RECORD> get(UUID id);

  /**
   * @return all available records.
   */
  Stream<RECORD> getAll();

  /**
   * Persists the provided record based on the id specified. If no record with this id exists, a new record is created.
   * Otherwise the existing record is updated.
   */
  void store(UUID id, RECORD record);

  /**
   * @return A new empty record.
   */
  RECORD newRecord();

}
