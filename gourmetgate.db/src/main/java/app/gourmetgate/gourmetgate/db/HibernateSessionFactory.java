package app.gourmetgate.gourmetgate.db;

import app.gourmetgate.gourmetgate.db.schema.ExampleEntity;
import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

@ApplicationScoped
public class HibernateSessionFactory {

  public static SessionFactory SESSION_FACTORY;

  public static SessionFactory getSessionFactory() {
    if (SESSION_FACTORY == null) {
      SESSION_FACTORY = new HibernateSessionFactory().buildSessionFactory();
    }
    return SESSION_FACTORY;
  }

  protected void registerEntityClasses(Configuration configuration) {
    configuration.addAnnotatedClass(ExampleEntity.class);
  }

  public SessionFactory buildSessionFactory() {
    Configuration configuration = new Configuration();

    // Database connection settings
    configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
    configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/demo_db");
    configuration.setProperty("hibernate.connection.username", "root");
    configuration.setProperty("hibernate.connection.password", "password");

    // Hibernate settings
    configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
    configuration.setProperty("hibernate.hbm2ddl.auto", "update");
    configuration.setProperty("hibernate.show_sql", "true");
    configuration.setProperty("hibernate.format_sql", "true");

    registerEntityClasses(configuration);

    // Build service registry
    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
      .applySettings(configuration.getProperties())
      .build();

    return configuration.buildSessionFactory(serviceRegistry);
  }
}
