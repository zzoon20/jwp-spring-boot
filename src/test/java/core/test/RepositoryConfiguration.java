package core.test;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SuppressWarnings("deprecation")
@Configuration
@EntityScan("next.model")
@EnableJpaRepositories("next.dao")
@EnableTransactionManagement
public class RepositoryConfiguration {
}