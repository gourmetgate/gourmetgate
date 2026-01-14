package app.gourmetgate.gourmetgate.core.category;

import app.gourmetgate.gourmetgate.core.common.DoHelper;
import app.gourmetgate.gourmetgate.core.item.ItemService;
import app.gourmetgate.gourmetgate.data.category.CategoryDo;
import app.gourmetgate.gourmetgate.data.category.ICategoryRepository;
import app.gourmetgate.gourmetgate.data.item.ItemDo;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CategoryService implements IService {

  public List<CategoryDo> getCategories(boolean onlyAvailable) {
    List<CategoryDo> categories = BEANS.get(ICategoryRepository.class).getAllActive()
      .map(persistenceDo -> BEANS.get(DoHelper.class).autoMap(CategoryDo.class, persistenceDo))
      .toList();

    List<UUID> categoryIds = categories.stream().map(CategoryDo::getCategoryId).toList();
    Map<UUID, List<ItemDo>> itemsByCategory = BEANS.get(ItemService.class).getItemsByCategory(categoryIds, onlyAvailable);

    return categories.stream()
      .map(category -> category.withItems(itemsByCategory.get(category.getCategoryId())))
      .toList();
  }
}
