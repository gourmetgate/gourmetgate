package app.gourmetgate.gourmetgate.persistence;

import org.eclipse.scout.rt.platform.service.IService;
import org.jooq.DSLContext;

public interface IJooqService extends IService {

  DSLContext getContext();

}
