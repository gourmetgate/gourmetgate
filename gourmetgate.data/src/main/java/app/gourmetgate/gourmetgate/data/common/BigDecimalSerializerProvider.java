package app.gourmetgate.gourmetgate.data.common;

import com.fasterxml.jackson.databind.*;
import org.eclipse.scout.rt.jackson.dataobject.IDataObjectSerializerProvider;
import org.eclipse.scout.rt.jackson.dataobject.ScoutDataObjectModuleContext;

import java.math.BigDecimal;

public class BigDecimalSerializerProvider implements IDataObjectSerializerProvider {

  @Override
  public JsonSerializer<?> findSerializer(ScoutDataObjectModuleContext moduleContext, JavaType type, SerializationConfig config, BeanDescription beanDesc) {
    if (BigDecimal.class.isAssignableFrom(type.getRawClass())) {
      return new BigDecimalSerializer();
    }
    return null;
  }

  @Override
  public JsonDeserializer<?> findDeserializer(ScoutDataObjectModuleContext moduleContext, JavaType type, DeserializationConfig config, BeanDescription beanDesc) {
    if (BigDecimal.class.isAssignableFrom(type.getRawClass())) {
      return new BigDecimalDeserializer();
    }
    return null;
  }
}
