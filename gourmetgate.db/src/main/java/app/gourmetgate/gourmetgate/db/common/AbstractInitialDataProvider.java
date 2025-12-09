package app.gourmetgate.gourmetgate.db.common;

import org.eclipse.scout.rt.platform.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public abstract class AbstractInitialDataProvider<ENTITY extends ISchemaEntity> {

  public abstract List<ENTITY> getInitialData();
}
