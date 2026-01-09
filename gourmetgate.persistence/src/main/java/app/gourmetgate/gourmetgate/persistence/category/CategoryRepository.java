package app.gourmetgate.gourmetgate.persistence.category;

import app.gourmetgate.gourmetgate.data.category.CategoryPersistenceDo;
import app.gourmetgate.gourmetgate.data.category.ICategoryRepository;
import app.gourmetgate.gourmetgate.persistence.common.AbstractEntityRepository;
import app.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import app.gourmetgate.gourmetgate.persistence.tables.Category;
import app.gourmetgate.gourmetgate.persistence.tables.records.CategoryRecord;
import org.eclipse.scout.rt.platform.BEANS;
import org.jooq.Field;

import java.time.OffsetDateTime;
import java.util.UUID;

public class CategoryRepository extends AbstractEntityRepository<Category, CategoryRecord, CategoryPersistenceDo> implements ICategoryRepository {

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
  protected CategoryRecord toNewRecord(CategoryPersistenceDo sourceDo) {
    return fromDoToRecord(sourceDo, new CategoryRecord());
  }

  @Override
  protected CategoryPersistenceDo toNewDo(CategoryRecord sourceRecord) {
    return fromRecordToDo(sourceRecord, BEANS.get(CategoryPersistenceDo.class));
  }

  @Override
  protected DoEntityBeanMappings<CategoryPersistenceDo, CategoryRecord> mappings() {
    return new DoEntityBeanMappings<CategoryPersistenceDo, CategoryRecord>()
      .with(CategoryPersistenceDo::categoryId, CategoryRecord::getCategoryId, CategoryRecord::setCategoryId)
      .with(CategoryPersistenceDo::name, CategoryRecord::getName, CategoryRecord::setName);
  }
}
