package spring.onconditonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import com.superhope.redis.Application;

@SpringBootApplication(exclude = {
		 
        DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class
}
)
public class CondtionalApplication {

	public static void main( String args[] ){
        SpringApplication.run(CondtionalApplication.class,args);
	}
}
