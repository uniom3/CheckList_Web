
package com.mendonca.checklist;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@Profile("developers")
public class DataConfiguration {
/*
	@Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        System.out.println("teste01");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        System.out.println("teste02");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db_checklist?useTimezone=true&serverTimezone=UTC");
        System.out.println("teste03");
         dataSource.setUsername("root");
        System.out.println("teste04");
        dataSource.setPassword("Admin@123");
        System.out.println("teste05");
        
        return dataSource;
    }*/
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		adapter.setPrepareConnection(true);
		return adapter;
	}
}

