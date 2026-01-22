package app.gourmetgate.gourmetgate.core.item;

import app.gourmetgate.gourmetgate.core.common.DoHelper;
import app.gourmetgate.gourmetgate.core.vat.VatService;
import app.gourmetgate.gourmetgate.data.item.IItemRepository;
import app.gourmetgate.gourmetgate.data.item.ItemDo;
import app.gourmetgate.gourmetgate.data.item.ItemPersistenceDo;
import app.gourmetgate.gourmetgate.data.query.ItemRestrictionDo;
import app.gourmetgate.gourmetgate.data.vat.VatDo;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class ItemService implements IService {

  public List<ItemDo> list(ItemRestrictionDo restriction) {
    return BEANS.get(IItemRepository.class).list(restriction)
      .map(persistenceDo -> BEANS.get(DoHelper.class).autoMap(ItemDo.class, persistenceDo))
      .toList();
  }

  public Map<UUID, List<ItemDo>> getItemsByCategory(List<UUID> categoryIds, boolean availableOnly) {
    DoHelper helper = BEANS.get(DoHelper.class);
    List<ItemDo> items = BEANS.get(IItemRepository.class).getItemsByCategory(categoryIds, availableOnly)
      .map(persistenceDo -> helper.autoMap(ItemDo.class, persistenceDo))
      .peek(itemDo -> helper.deleteNode(itemDo, ItemPersistenceDo.class, ItemPersistenceDo::vatId))
      .toList();

    // Add variants

    // Add vat
    Map<UUID, VatDo> vatByItemId = BEANS.get(VatService.class).getVatByItemId(items.stream().map(ItemDo::getItemId).toList());
    items.forEach(item -> item.withVat(vatByItemId.get(item.getItemId())));

    return items.stream()
      .collect(Collectors.groupingBy(ItemDo::getCategoryId));
  }
}
