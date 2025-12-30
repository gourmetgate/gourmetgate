package app.gourmetgate.gourmetgate.data.common;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import org.eclipse.scout.rt.platform.util.StringUtility;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDeserializer extends FromStringDeserializer<BigDecimal> {

  protected BigDecimalDeserializer() {
    super(BigDecimal.class);
  }

  @Override
  protected BigDecimal _deserialize(String value, DeserializationContext ctxt) throws IOException {
    if (!StringUtility.hasText(value)) {
      return null;
    }

    try {
      return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);
    } catch (NumberFormatException e) {
      return (BigDecimal) ctxt.handleWeirdStringValue(
        BigDecimal.class,
        value,
        "Invalid BigDecimal value"
      );
    }
  }
}
