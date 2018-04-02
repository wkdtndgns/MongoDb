package net.skhu;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableAutoConfiguration(exclude = {JpaRepositoriesAutoConfiguration.class})
@EnableMongoRepositories(basePackages = "net.skhu.repository")
@EntityScan(basePackages = "net.skhu.domain")
@ComponentScan(basePackages = "net.skhu")
@SpringBootApplication
public class Example01Application {
	public static void main(String[] args) {
		SpringApplication.run(Example01Application.class, args);
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.data.db-main")
	public DataSource mainDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.data.db-log")
	public DataSource contractDataSource() {
		return DataSourceBuilder.create().build();
	}
}
