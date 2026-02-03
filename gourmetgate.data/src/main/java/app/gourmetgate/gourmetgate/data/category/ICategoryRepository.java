package app.gourmetgate.gourmetgate.data.category;

import app.gourmetgate.gourmetgate.data.common.IEntityRepository;
import app.gourmetgate.gourmetgate.data.query.CategoryRestrictionDo;
import org.eclipse.scout.rt.platform.ApplicationScoped;

import java.util.stream.Stream;

@ApplicationScoped
public interface ICategoryRepository extends IEntityRepository<CategoryDo> {

  Stream<CategoryDo> list(CategoryRestrictionDo restriction);
}
