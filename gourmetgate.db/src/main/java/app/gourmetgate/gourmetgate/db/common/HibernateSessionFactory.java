package app.gourmetgate.gourmetgate.db.common;

import app.gourmetgate.gourmetgate.persistence.PersistenceProperties;
import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.config.CONFIG;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

@ApplicationScoped
public class HibernateSessionFactory {

  public static SessionFactory SESSION_FACTORY;

  public static SessionFactory getSessionFactory() {
    return getSessionFactory(false);
  }

  public static SessionFactory getSessionFactory(boolean reset) {
    if (SESSION_FACTORY == null) {
      SESSION_FACTORY = new HibernateSessionFactory().buildSessionFactory(reset);
    }
    return SESSION_FACTORY;
  }

  protected void registerEntityClasses(Configuration configuration) {
    BEANS.all(ISchemaEntity.class)
      .forEach(entity -> configuration.addAnnotatedClass(entity.getClass()));
  }

  public SessionFactory buildSessionFactory(boolean reset) {
    Configuration configuration = new Configuration();

    // Database connection settings
    configuration.setProperty("hibernate.connection.driver_class", CONFIG.getPropertyValue(PersistenceProperties.DriverProperty.class));
    configuration.setProperty("hibernate.connection.url", CONFIG.getPropertyValue(PersistenceProperties.JdbcMappingNameProperty.class));
    configuration.setProperty("hibernate.connection.username", CONFIG.getPropertyValue(PersistenceProperties.UsernameProperty.class));
    configuration.setProperty("hibernate.connection.password", CONFIG.getPropertyValue(PersistenceProperties.PasswordProperty.class));
    configuration.setProperty("hibernate.default_schema", CONFIG.getPropertyValue(PersistenceProperties.SchemaProperty.class));

    // Hibernate settings
    configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
    configuration.setProperty("hibernate.hbm2ddl.auto", reset ? "create" : "update");
    configuration.setProperty("hibernate.show_sql", "true");
    configuration.setProperty("hibernate.format_sql", "true");
    configuration.setProperty("hibernate.physical_naming_strategy", "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy");

    registerEntityClasses(configuration);

    // Build service registry
    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
      .applySettings(configuration.getProperties())
      .build();

    return configuration.buildSessionFactory(serviceRegistry);
  }
}
