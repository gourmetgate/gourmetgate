package app.gourmetgate.gourmetgate.core.user;

import app.gourmetgate.gourmetgate.core.common.DoHelper;
import app.gourmetgate.gourmetgate.core.common.EntityNotFoundException;
import app.gourmetgate.gourmetgate.data.item.IItemRepository;
import app.gourmetgate.gourmetgate.data.item.ItemDo;
import app.gourmetgate.gourmetgate.data.mapping.IItemToVariantRepository;
import app.gourmetgate.gourmetgate.data.mapping.ItemToVariantDo;
import app.gourmetgate.gourmetgate.data.query.ItemRestrictionDo;
import app.gourmetgate.gourmetgate.data.user.IUserRepository;
import app.gourmetgate.gourmetgate.data.user.UserDo;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.platform.util.LazyValue;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserService implements IService {
  protected LazyValue<DoHelper> helper = new LazyValue<>(DoHelper.class);

  public List<UserDo> list(UserDo restriction) {
    return BEANS.get(IUserRepository.class).list(restriction)
      .toList();

  }

  public UserDo getById(UUID uuid) {
    UserDo user = BEANS.get(IUserRepository.class).getById(uuid)
      .orElseThrow(() -> new EntityNotFoundException("User", uuid));

    return user;
  }

  public UserDo create(UserDo user) {
    // Permission check required
    checkMandetoryProperties(user);

    return BEANS.get(IUserRepository.class).create(user);
  }

  public UserDo update(UUID id, UserDo user) {
    // Permission check required
    checkMandetoryProperties(user);

    int affectedRows = BEANS.get(IUserRepository.class).store(id, user);
    if (affectedRows != 1) {
      throw new EntityNotFoundException("Item", id);
    }
    return user;
  }

  public void delete(UUID id) {
    // Check permissions
    int affectedRows = BEANS.get(IItemRepository.class).delete(id);
    if (affectedRows != 1) {
      throw new EntityNotFoundException("Item", id);
    }
    BEANS.get(IItemToVariantRepository.class).deleteByItemId(id);
  }

  private void checkMandetoryProperties(UserDo user) {
    helper.get().validateRequiredProperty(user.userName());
    helper.get().validateRequiredProperty(user.password());
  }
}
