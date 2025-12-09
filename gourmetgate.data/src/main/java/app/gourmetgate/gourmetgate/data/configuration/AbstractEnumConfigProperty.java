package app.gourmetgate.gourmetgate.data.configuration;

import org.eclipse.scout.rt.platform.config.AbstractConfigProperty;
import org.eclipse.scout.rt.platform.exception.PlatformException;

public abstract class AbstractEnumConfigProperty<ENUM> extends AbstractConfigProperty<ENUM, String> {

  @Override
  protected ENUM parse(String value) {
    try {
      return mappingFunction(value);
    } catch (IllegalArgumentException e) {
      throw new PlatformException("Invalid config property value {}. Cannot be mapped to enum type", value, e);
    }
  }

  protected abstract ENUM mappingFunction(String rawValue);
}
