package app.gourmetgate.gourmetgate.core.item;

import app.gourmetgate.gourmetgate.core.common.DoHelper;
import app.gourmetgate.gourmetgate.core.common.EntityNotFoundException;
import app.gourmetgate.gourmetgate.data.item.IItemRepository;
import app.gourmetgate.gourmetgate.data.item.ItemDo;
import app.gourmetgate.gourmetgate.data.query.ItemRestrictionDo;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.platform.util.LazyValue;

import java.util.List;
import java.util.UUID;

public class ItemService implements IService {

  protected LazyValue<DoHelper> helper = new LazyValue<>(DoHelper.class);


  public List<ItemDo> list(ItemRestrictionDo restriction) {
    return BEANS.get(IItemRepository.class).list(restriction)
      .toList();
  }

  public ItemDo getById(UUID uuid) {
    return BEANS.get(IItemRepository.class).getById(uuid)
      .orElseThrow(() -> new EntityNotFoundException("Item", uuid));
  }

  public ItemDo create(ItemDo item) {
    // Permission check required
    helper.get().validateRequiredProperty(item.categoryId());
    helper.get().validateRequiredProperty(item.vatId());
    helper.get().validateRequiredProperty(item.name());
    helper.get().validateRequiredProperty(item.price());
    helper.get().validateRequiredProperty(item.available());

    return BEANS.get(IItemRepository.class).create(item);
  }

  public ItemDo update(UUID id, ItemDo item) {
    // Permission check required
    helper.get().validateRequiredProperty(item.categoryId());
    helper.get().validateRequiredProperty(item.vatId());
    helper.get().validateRequiredProperty(item.name());
    helper.get().validateRequiredProperty(item.price());
    helper.get().validateRequiredProperty(item.available());

    int affectedRows = BEANS.get(IItemRepository.class).store(id, item);
    if (affectedRows != 1) {
      throw new EntityNotFoundException("Item", id);
    }
    return item;
  }

  public void delete(UUID id) {
    // Check permissions
    int affectedRows = BEANS.get(IItemRepository.class).delete(id);
    if (affectedRows != 1) {
      throw new EntityNotFoundException("Item", id);
    }
  }
}
