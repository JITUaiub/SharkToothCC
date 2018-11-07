package org.sharktooth.gms.ApplicationConfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "org.sharktooth.gms.controller", "org.sharktooth.gms.dao.implementation",
		"org.sharktooth.gms.service.implementation" })
public class AppConfig extends WebMvcConfigurerAdapter {

	// JSP view resolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	// Hibernate
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan(new String[] { "org.sharktooth.gms.model" });
		sessionFactory.setHibernateProperties(getHibernateProperties());
		return sessionFactory;
	}

	// Database Connectivity
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sharktoothdb");
		dataSource.setUsername("root");
		return dataSource;
	}

	@Bean
	public Properties getHibernateProperties() {

		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		hibernateProperties.put("hibernate.show_sql", false);
		hibernateProperties.put("hibernate.generate_statistics", false);
		hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.put("hibernate.use_sql_comments", false);
		hibernateProperties.put("hibernate.format_sql", true);
		hibernateProperties.put("hibernate.id.new_generator_mappings", false);

		return hibernateProperties;
	}

	@Bean
	public static ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
		reloadableResourceBundleMessageSource.setBasename("/WEB-INF/errorMessage");

		return reloadableResourceBundleMessageSource;
	}
}
