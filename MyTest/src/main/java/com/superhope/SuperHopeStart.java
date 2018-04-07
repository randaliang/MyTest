package com.superhope;


import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class SuperHopeStart {

	
	@Bean(name = "primaryJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(
            @Qualifier("primaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(
            @Qualifier("secondaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


	  
	@Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    public DataSource primaryDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver ");
		ds.setUrl("jdbc:mysql://192.168.80.135:3306/rdl?useUnicode=true&characterEncoding=utf8&useSSL=false");
		ds.setUsername("root");
		ds.setPassword("123456");
		return ds;
    }

    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @Primary
    public DataSource secondaryDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver ");
		ds.setUrl("jdbc:mysql://192.168.80.142:3306/rdl?useUnicode=true&characterEncoding=utf8&useSSL=false");
		ds.setUsername("root");
		ds.setPassword("123456");
		return ds;
        }


	  public static void main( String args[] ){
		  ApplicationContext ctx = SpringApplication.run(SuperHopeStart.class, args);
	  }
	  
}
