package app.gourmetgate.gourmetgate.db;

import app.gourmetgate.gourmetgate.db.common.JooqEnvironment;
import app.gourmetgate.gourmetgate.persistence.PersistenceProperties.SchemaProperty;
import app.gourmetgate.gourmetgate.persistence.common.DateConverter;
import org.eclipse.scout.rt.platform.config.CONFIG;
import org.eclipse.scout.rt.platform.exception.PlatformException;
import org.jooq.DSLContext;
import org.jooq.codegen.GenerationTool;
import org.jooq.codegen.JavaGenerator;
import org.jooq.meta.jaxb.*;
import org.jooq.meta.postgres.PostgresDatabase;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.UUID;

public class GeneratorApplication {

  public static final String OUTPUT_DIRECTORY = "../gourmetgate.persistence/src/generated/java";
  public static final String OUTPUT_PACKAGE = "app.gourmetgate.gourmetgate.persistence";

  public static void main(String[] args) {
    new JooqEnvironment().runWithConfig(new GeneratorApplication()::generate);
  }

  public void generate(DSLContext context) {
    Configuration configuration = new Configuration().withGenerator(new Generator()
        .withName(JavaGenerator.class.getName())
        .withDatabase(new Database()
            .withForcedTypes(
                new ForcedType().withName(UUID.class.getName()).withIncludeTypes("varchar(36)"),
                new ForcedType().withUserType(Date.class.getName())
                    .withConverter(DateConverter.class.getName()).withIncludeTypes("timestamp"),
                new ForcedType().withName(BigDecimal.class.getName()).withIncludeTypes("bigint"))
            .withName(PostgresDatabase.class.getName()).withIncludes(".*")
            .withInputSchema(CONFIG.getPropertyValue(SchemaProperty.class)).withOutputSchema("Schema")
            .withExcludes("SYS*.*"))
      .withTarget(new Target()
        .withDirectory(OUTPUT_DIRECTORY)
        .withPackageName(OUTPUT_PACKAGE)));

    GenerationTool tool = new GenerationTool();
    try {
      Connection connection = context.configuration().connectionProvider().acquire();
      connection.setSchema(CONFIG.getPropertyValue(SchemaProperty.class));
      tool.setConnection(connection);
      tool.run(configuration);
    } catch (Exception e) {
      throw new PlatformException("Error generating jooq classes.", e);
    }
  }
}
