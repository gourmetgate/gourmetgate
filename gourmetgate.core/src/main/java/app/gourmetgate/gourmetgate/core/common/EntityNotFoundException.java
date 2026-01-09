package app.gourmetgate.gourmetgate.core.common;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.exception.ProcessingException;

import java.util.UUID;

public class EntityNotFoundException extends ProcessingException {

  public EntityNotFoundException(String dataObjectName, UUID id) {
    super(String.format("Entity %s with id %s could not be found.", dataObjectName, id));
  }

  public ErrorDo toErrorDo() {
    return BEANS.get(ErrorDo.class)
      .withCode(404)
      .withTitle("Entity not found")
      .withMessage(getMessage());
  }
}
