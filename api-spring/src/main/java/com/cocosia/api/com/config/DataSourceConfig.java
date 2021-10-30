package com.cocosia.api.com.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//import java.sql.SQLException;

/*
import java.util.Properties;

import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;

import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.orm.jpa.JpaTransactionManager;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.PlatformTransactionManager;
*/

@Configuration
//@EnableTransactionManagement
public class DataSourceConfig {
//public class PersistenceJPAConfig

    @Value("${spring.datasource.url}")
    private static String url;

    @Value("${spring.datasource.username}")
    private static String userName;

    @Value("${spring.datasource.password}")
    private static String pw;


    @Bean
    public DataSource datasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        dataSource.setUsername(userName);
        dataSource.setPassword(pw);
        dataSource.setUrl(url);

        return dataSource;
    }

    /*

    DON'T WANT TO USE SPRINGBOOT CODES(FOR SPRING FRAMEWORKS).
    SEE THIS : https://www.baeldung.com/the-persistence-layer-with-spring-and-jpa

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setDataSource(datasource());
        lcemfb.setPackagesToScan(new String[] {"com.cocosia.api.web"});

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        lcemfb.setJpaVendorAdapter(vendorAdapter);
        lcemfb.setJpaProperties(additionalProperties());

        return lcemfb;

    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

        return properties;
    }
    */
}
