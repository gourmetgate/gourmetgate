package app.gourmetgate.gourmetgate.persistence.category;

import app.gourmetgate.gourmetgate.data.category.CategoryDo;
import app.gourmetgate.gourmetgate.data.category.ICategoryRepository;
import app.gourmetgate.gourmetgate.data.query.CategoryRestrictionDo;
import app.gourmetgate.gourmetgate.data.status.Status;
import app.gourmetgate.gourmetgate.persistence.common.AbstractEntityRepository;
import app.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import app.gourmetgate.gourmetgate.persistence.tables.Category;
import app.gourmetgate.gourmetgate.persistence.tables.records.CategoryRecord;
import org.eclipse.scout.rt.platform.BEANS;
import org.jooq.Field;

import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.stream.Stream;

import static app.gourmetgate.gourmetgate.persistence.JooqSqlService.jooq;
import static org.jooq.impl.DSL.noCondition;

public class CategoryRepository extends AbstractEntityRepository<Category, CategoryRecord, CategoryDo> implements ICategoryRepository {

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
  public Stream<CategoryDo> list(CategoryRestrictionDo restriction) {
    return jooq()
      .selectFrom(getTable())
      .where(
        getStatusColumn().eq(Status.ACTIVE.id),
        restriction.categoryId().exists() ? getIdColumn().eq(restriction.getCategoryId()) : noCondition(),
        restriction.name().exists() ? getTextMatchingCondition(getTable().NAME, restriction.getName()) : noCondition()
      ).fetchStream()
      .map(this::toNewDo);
  }

  @Override
  protected CategoryRecord toNewRecord(CategoryDo sourceDo) {
    return fromDoToRecord(sourceDo, new CategoryRecord());
  }

  @Override
  protected CategoryDo toNewDo(CategoryRecord sourceRecord) {
    return fromRecordToDo(sourceRecord, BEANS.get(CategoryDo.class));
  }

  @Override
  protected DoEntityBeanMappings<CategoryDo, CategoryRecord> mappings() {
    return new DoEntityBeanMappings<CategoryDo, CategoryRecord>()
      .with(CategoryDo::categoryId, CategoryRecord::getCategoryId, CategoryRecord::setCategoryId)
      .with(CategoryDo::name, CategoryRecord::getName, CategoryRecord::setName);
  }
}
