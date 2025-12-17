package app.gourmetgate.gourmetgate.db.common;

import org.eclipse.scout.rt.platform.Bean;

import java.util.List;

@Bean
public abstract class AbstractInitialDataProvider<ENTITY extends ISchemaEntity> {

  public abstract List<ENTITY> getInitialData();
}
