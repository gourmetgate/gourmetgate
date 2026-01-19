package app.gourmetgate.gourmetgate.core.common;

import jakarta.annotation.PostConstruct;
import org.eclipse.scout.rt.dataobject.DataObjectHelper;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoNode;
import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.eclipse.scout.rt.platform.BEANS;

import java.util.function.Function;

@ApplicationScoped
public class DoHelper {

  protected DataObjectHelper m_dataObjectHelper;

  @PostConstruct
  protected void init() {
    m_dataObjectHelper = BEANS.get(DataObjectHelper.class);
  }

  public <T extends DoEntity> T autoMap(Class<? extends T> targetClass, DoEntity source) {
    T targetDo = BEANS.get(targetClass);
    return m_dataObjectHelper.applyValues(targetDo, source);
  }

  public <T extends DoEntity> void deleteNode(DoEntity entity, Class<T> doClass, Function<T, DoNode<?>> nodeGetter) {
    String attributeName = nodeGetter.apply(BEANS.get(doClass)).getAttributeName();
    entity.remove(attributeName);
  }
}
