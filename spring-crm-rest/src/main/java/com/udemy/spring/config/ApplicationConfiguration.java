package com.udemy.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * @author alexander.shakhov on 28.05.2018 12:50
 */

@EnableWebMvc
@Configuration
@EnableTransactionManagement
@ComponentScan("com.udemy.spring")
@PropertySource({"classpath:persistence-mysql.properties"})
public class ApplicationConfiguration {

    @Autowired
    private Environment e;

    private Logger logger = Logger.getLogger(getClass().getName());

    @Bean
    public FreeMarkerViewResolver freemarkerViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();

        resolver.setCache(true);
        resolver.setPrefix("");
        resolver.setSuffix(".ftl");

        return resolver;
    }

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource db = new ComboPooledDataSource();

        try {
            db.setDriverClass(e.getProperty("jdbc.driver"));
        } catch (PropertyVetoException exc) {
            exc.printStackTrace();
            throw new RuntimeException(exc);
        }
        logger.info("JDBC URL: \t" + e.getProperty("jdbc.url"));
        logger.info("JDBC USER:\t" + e.getProperty("jdbc.user"));

        db.setJdbcUrl(e.getProperty("jdbc.url"));
        db.setUser(e.getProperty("jdbc.user"));
        db.setPassword(e.getProperty("jdbc.password"));

        db.setInitialPoolSize(getIntProperty(e.getProperty("connection.pool.initialPoolSize")));
        db.setMinPoolSize(getIntProperty(e.getProperty("connection.pool.minPoolSize")));
        db.setMaxPoolSize(getIntProperty(e.getProperty("connection.pool.maxPoolSize")));
        db.setMaxIdleTime(getIntProperty(e.getProperty("connection.pool.maxIdleTime")));

        return db;
    }

    private Properties getHibernateProperties() {
        Properties p = new Properties();

        p.setProperty("hibernate.dialect", e.getProperty("hibernate.dialect"));
        p.setProperty("hibernate.show_sql", e.getProperty("hibernate.show_sql"));
        p.setProperty("hibernate.packagesToScan", e.getProperty("hibernate.packagesToScan"));

        return p;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();

        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan(e.getProperty("hibernate.packagesToScan"));
        sessionFactoryBean.setHibernateProperties(getHibernateProperties());

        return sessionFactoryBean;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {

        // setup transaction manager based on session factory
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;
    }

    private Integer getIntProperty(String name) {
        return Integer.parseInt(name);
    }

}
