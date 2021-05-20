package com.hdsoft.config;

import com.hdsoft.model.Event;
import com.hdsoft.model.User;
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.hdsoft")
@EnableTransactionManagement
public class Config {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds=new DriverManagerDataSource("jdbc:mysql://localhost:3306/springhibtest?createDatabaseIfNotExist=true", "hrishav", "hrishav");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");

        return ds;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource ds){
        LocalSessionFactoryBean ls=new LocalSessionFactoryBean();
        ls.setDataSource(ds);
        ls.setAnnotatedClasses(Event.class, User.class);
        Properties prop=new Properties();
        prop.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        prop.setProperty("hibernate.show_sql","true");
        prop.setProperty("hibernate.hbm2ddl.auto","update");
        ls.setHibernateProperties(prop);
        return ls;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sf){
        HibernateTransactionManager hs=new HibernateTransactionManager();
        hs.setSessionFactory(sf);
        return hs;
    }

    @Bean
    public HibernateTemplate hibernateTemplate(SessionFactory sf){
        HibernateTemplate ht=new HibernateTemplate(sf);
        ht.setCheckWriteOperations(false);
        return ht;
    }
}
