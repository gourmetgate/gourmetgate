package app.gourmetgate.gourmetgate.core;

import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.text.AbstractDynamicNlsTextProviderService;

@Order(3550)
public class TextProviderService extends AbstractDynamicNlsTextProviderService {

  @Override
  public String getDynamicNlsBaseName() {
    return "app.gourmetgate.gourmetgate.core.texts.Texts";
  }
}
