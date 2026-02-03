package app.gourmetgate.gourmetgate.core.category;

import app.gourmetgate.gourmetgate.core.common.DoHelper;
import app.gourmetgate.gourmetgate.core.common.EntityNotFoundException;
import app.gourmetgate.gourmetgate.data.category.CategoryDo;
import app.gourmetgate.gourmetgate.data.category.ICategoryRepository;
import app.gourmetgate.gourmetgate.data.item.IItemRepository;
import app.gourmetgate.gourmetgate.data.query.CategoryRestrictionDo;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.platform.util.LazyValue;

import java.util.List;
import java.util.UUID;

public class CategoryService implements IService {

  protected LazyValue<DoHelper> helper = new LazyValue<>(DoHelper.class);

  public List<CategoryDo> list(CategoryRestrictionDo restriction) {
    return BEANS.get(ICategoryRepository.class).list(restriction)
      .toList();
  }

  public CategoryDo getById(UUID id) {
    // Permission check required

    return BEANS.get(ICategoryRepository.class).getById(id)
      .orElseThrow(() -> new EntityNotFoundException("Category", id));
  }

  public CategoryDo create(CategoryDo category) {
    // Permission check required
    helper.get().validateRequiredProperty(category.name());

    return BEANS.get(ICategoryRepository.class).create(category);
  }

  public CategoryDo update(UUID id, CategoryDo category) {
    // Permission check required
    helper.get().validateRequiredProperty(category.categoryId());
    helper.get().validateRequiredProperty(category.name());
    helper.get().validateSameId(id, category.categoryId());

    int affectedRows = BEANS.get(ICategoryRepository.class).store(id, category);
    if (affectedRows != 1) {
      throw new EntityNotFoundException("Category", id);
    }
    return category;
  }

  public void delete(UUID id, UUID replacement) {
    // Check permissions
    helper.get().validateReplacementId(id, replacement);

    // Replace category
    BEANS.get(IItemRepository.class).replaceCategory(id, replacement);

    int affectedRows = BEANS.get(ICategoryRepository.class).delete(id);
    if (affectedRows != 1) {
      throw new EntityNotFoundException("Category", id);
    }
  }
}
