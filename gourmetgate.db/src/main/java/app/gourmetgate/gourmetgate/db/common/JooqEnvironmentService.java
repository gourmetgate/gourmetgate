package app.gourmetgate.gourmetgate.db.common;

import app.gourmetgate.gourmetgate.persistence.PersistenceProperties.SchemaProperty;
import org.eclipse.scout.rt.platform.config.CONFIG;
import org.eclipse.scout.rt.platform.service.IService;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.MappedSchema;
import org.jooq.conf.RenderMapping;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public class JooqEnvironmentService implements IService {

  private static final Logger LOG = LoggerFactory.getLogger(JooqEnvironmentService.class);

  public void runInJooq(Consumer<DSLContext> task, String jdbcMappingName, SQLDialect dialect, String username, String password) {
    try (Connection connection = DriverManager.getConnection(jdbcMappingName, username, password)) {
      Configuration configuration = new DefaultConfiguration()
          .set(connection)
          .set(dialect);
      Settings s = configuration.settings();
      s.withRenderMapping(new RenderMapping()
          .withSchemata(new MappedSchema()
              .withInputExpression(Pattern.compile("Schema"))
              .withOutput(CONFIG.getPropertyValue(SchemaProperty.class))));
      configuration.set(s);
      task.accept(DSL.using(configuration));
    } catch (SQLException e) {
      LOG.error("Failed to create connection.", e);
    }
  }
}
