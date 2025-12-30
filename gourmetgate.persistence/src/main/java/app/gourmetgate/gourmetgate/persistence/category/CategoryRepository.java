package app.gourmetgate.gourmetgate.persistence.category;

import app.gourmetgate.gourmetgate.data.category.CategoryPersistenceDo;
import app.gourmetgate.gourmetgate.data.category.ICategoryRepository;
import app.gourmetgate.gourmetgate.persistence.common.AbstractOrderedRepositoryWithStatus;
import app.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import app.gourmetgate.gourmetgate.persistence.tables.Category;
import app.gourmetgate.gourmetgate.persistence.tables.records.CategoryRecord;
import org.eclipse.scout.rt.platform.BEANS;
import org.jooq.Field;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public class CategoryRepository extends AbstractOrderedRepositoryWithStatus<Category, CategoryRecord, CategoryPersistenceDo> implements ICategoryRepository {

  @Override
  public Category getTable() {
    return Category.CATEGORY;
  }

  @Override
  public Field<UUID> getIdColumn() {
    return getTable().CATEGORY_ID;
  }

  @Override
  public Field<OffsetDateTime> getSortColumn() {
    return getTable().SORT_CODE;
  }

  @Override
  public Field<String> getStatusColumn() {
    return getTable().STATUS;
  }

  @Override
  public Stream<CategoryPersistenceDo> getAllActive() {
    return getAll().map(this::recToDo);
  }

  @Override
  public Optional<CategoryPersistenceDo> getById(UUID id) {
    return get(id).map(this::recToDo);
  }

  @Override
  public CategoryPersistenceDo create(CategoryPersistenceDo category) {
    CategoryRecord newCategoryRecord = newRecord();
    UUID newCategoryId = UUID.randomUUID();

    fromDoToRecord(category, newCategoryRecord)
      .setCategoryId(newCategoryId);
    newCategoryRecord.store();
    return fromRecordToDo(newCategoryRecord, category);
  }

  @Override
  public void store(UUID id, CategoryPersistenceDo category) {
    super.store(id, doToRec(category));
  }

  @Override
  public int delete(UUID id) {
    return remove(id);
  }

  protected CategoryPersistenceDo recToDo(CategoryRecord personRecord) {
    return fromRecordToDo(personRecord, BEANS.get(CategoryPersistenceDo.class));
  }

  protected CategoryRecord doToRec(CategoryPersistenceDo person) {
    return fromDoToRecord(person, new CategoryRecord());
  }

  @Override
  protected DoEntityBeanMappings<CategoryPersistenceDo, CategoryRecord> mappings() {
    return new DoEntityBeanMappings<CategoryPersistenceDo, CategoryRecord>()
      .with(CategoryPersistenceDo::categoryId, CategoryRecord::getCategoryId, CategoryRecord::setCategoryId)
      .with(CategoryPersistenceDo::name, CategoryRecord::getName, CategoryRecord::setName);
  }
}
