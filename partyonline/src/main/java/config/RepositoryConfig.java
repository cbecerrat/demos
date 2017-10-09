package config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("repositories")
public class RepositoryConfig{
	@Bean(name = "dataSource")
    public DataSource dataSource() throws NamingException {
        return (DataSource) new JndiTemplate().lookup("java:jboss/datasources/MySQLDS");
    }	
	
	@Bean(name = "hibernateJpaVendorAdapter")
	public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setDatabase(org.springframework.orm.jpa.vendor.Database.MYSQL);
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		return hibernateJpaVendorAdapter;
	}

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		
		try {
			localContainerEntityManagerFactoryBean.setDataSource(dataSource());
			localContainerEntityManagerFactoryBean.setPackagesToScan("domain");
			localContainerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return localContainerEntityManagerFactoryBean;
	}

	@Bean(name = "transactionManager")
	public JpaTransactionManager jpaTransactionManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		return jpaTransactionManager;
	}
}
