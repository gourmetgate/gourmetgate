package app.gourmetgate.gourmetgate.core.common;

import org.eclipse.scout.rt.dataobject.DoList;
import org.eclipse.scout.rt.dataobject.DoNode;
import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.eclipse.scout.rt.platform.util.StringUtility;

import java.util.UUID;

@ApplicationScoped
public class DoHelper {

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

    if ((node instanceof DoList<?> && ((DoList<?>) node).isEmpty()) || !node.exists() || !valueValid) {
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
