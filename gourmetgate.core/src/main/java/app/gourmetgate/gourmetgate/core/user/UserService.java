package app.gourmetgate.gourmetgate.core.user;

import app.gourmetgate.gourmetgate.core.common.DoHelper;
import app.gourmetgate.gourmetgate.core.common.EntityNotFoundException;
import app.gourmetgate.gourmetgate.data.item.IItemRepository;
import app.gourmetgate.gourmetgate.data.item.ItemDo;
import app.gourmetgate.gourmetgate.data.mapping.IItemToVariantRepository;
import app.gourmetgate.gourmetgate.data.mapping.ItemToVariantDo;
import app.gourmetgate.gourmetgate.data.query.ItemRestrictionDo;
import app.gourmetgate.gourmetgate.data.query.UserRestrictionDo;
import app.gourmetgate.gourmetgate.data.user.IUserRepository;
import app.gourmetgate.gourmetgate.data.user.UserDo;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.exception.VetoException;
import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.platform.util.LazyValue;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserService implements IService {
  protected LazyValue<DoHelper> helper = new LazyValue<>(DoHelper.class);

  public List<UserDo> list(UserRestrictionDo restriction) {
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

    user.withSalt(createSalt());
    user.withPassword(hasPassword(user.getPassword(), user.getSalt()));

    return BEANS.get(IUserRepository.class).create(user);
  }

  public UserDo update(UUID id, UserDo user) {
    // Permission check required
    checkMandetoryProperties(user);

    String salt = BEANS.get(IUserRepository.class).getById(user.getUserId()).get().getSalt();
    user.withPassword(hasPassword(user.getPassword(), salt));

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

  private String createSalt(){
    SecureRandom random = new SecureRandom();
    byte[] salt = new byte[16];
    random.nextBytes(salt);
    return Arrays.toString(salt);
  }

  private String hasPassword(String password, String salt) {
    KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 128);
    try {
      SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
      return Arrays.toString(factory.generateSecret(spec).getEncoded());
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
      throw new RuntimeException(e);
    }
  }

  private void checkMandetoryProperties(UserDo user) {
    helper.get().validateRequiredProperty(user.userName());
    helper.get().validateRequiredProperty(user.password());
  }
}
