package app.gourmetgate.gourmetgate.core.common;

import org.eclipse.scout.rt.dataobject.DataObjectHelper;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoNode;
import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.util.LazyValue;
import org.eclipse.scout.rt.platform.util.StringUtility;

import java.util.UUID;
import java.util.function.Function;

@ApplicationScoped
public class DoHelper {

  protected LazyValue<DataObjectHelper> helper = new LazyValue<>(DataObjectHelper.class);

  public <T extends DoEntity> T autoMap(Class<? extends T> targetClass, DoEntity source) {
    T targetDo = BEANS.get(targetClass);
    return helper.get().applyValues(targetDo, source);
  }

  public <T extends DoEntity> void deleteNode(DoEntity entity, Class<T> doClass, Function<T, DoNode<?>> nodeGetter) {
    String attributeName = nodeGetter.apply(BEANS.get(doClass)).getAttributeName();
    entity.remove(attributeName);
  }

  public UUID ensureUuid(String id) {
    try {
      return UUID.fromString(id);
    } catch (IllegalArgumentException e) {
      throw new DataValidationException(String.format("Id %s is not a valid UUID", id));
    }
  }

  public <T> void validateRequiredProperty(DoNode<T> node) {
    boolean valueValid = node.get() instanceof String
      ? StringUtility.hasText(((String) node.get()))
      : node.get() != null;

    if (!node.exists() || !valueValid) {
      String error = String.format("%s is a required value", node.getAttributeName());
      throw new DataValidationException(error);
    }
  }

  public void validateSameId(UUID expectedId, DoNode<UUID> node) {
    boolean idEquals = node.exists() && expectedId.equals(node.get());

    if (!idEquals) {
      String error = String.format("Not allowed to modify id of entity. Old: %s, new: %s", expectedId, node.get());
      throw new DataValidationException(error);
    }
  }

  public void validateReplacementId(UUID deleted, UUID replacement) {
    boolean idEquals = deleted.equals(replacement);
    if (idEquals) {
      String error = String.format("Not allowed to replace old id with same id. Old: %s, new: %s", deleted, replacement);
      throw new DataValidationException(error);
    }
  }
}
