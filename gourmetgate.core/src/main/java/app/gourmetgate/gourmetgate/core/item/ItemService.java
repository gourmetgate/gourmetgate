package app.gourmetgate.gourmetgate.core.item;

import app.gourmetgate.gourmetgate.core.common.DoHelper;
import app.gourmetgate.gourmetgate.data.item.IItemRepository;
import app.gourmetgate.gourmetgate.data.item.ItemDo;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class ItemService implements IService {

  public Map<UUID, List<ItemDo>> getItemsByCategory(List<UUID> categoryIds, boolean availableOnly) {
    DoHelper helper = BEANS.get(DoHelper.class);
    return BEANS.get(IItemRepository.class).getItemsByCategory(categoryIds, availableOnly)
      .map(persistenceDo -> helper.autoMap(ItemDo.class, persistenceDo)) // Auto-map
      // Add variants
      .collect(Collectors.groupingBy(ItemDo::getCategoryId));
  }
}
