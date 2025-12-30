package app.gourmetgate.gourmetgate.data.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalSerializer extends ToStringSerializer {

  public BigDecimalSerializer() {
    super(BigDecimal.class);
  }

  @Override
  public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {
    gen.writeString(((BigDecimal) value).setScale(2, RoundingMode.HALF_UP).toString());
  }
}
