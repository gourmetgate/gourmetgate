package app.gourmetgate.gourmetgate.core.common;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.exception.ProcessingException;

public class DataValidationException extends ProcessingException {

  public DataValidationException(String reason) {
    super(reason);
  }

  public ErrorDo toErrorDo() {
    return BEANS.get(ErrorDo.class)
      .withCode(400)
      .withTitle("Bad data received")
      .withMessage(getMessage());
  }
}
