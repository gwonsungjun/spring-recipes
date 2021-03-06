package ch16.com.springrecipes.bank.config;

import ch16.com.springrecipes.bank.dao.AccountDao;
import ch16.com.springrecipes.bank.dao.InMemoryAccountDao;
import ch16.com.springrecipes.bank.dao.JdbcAccountDao;
import ch16.com.springrecipes.bank.service.AccountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class BankConfiguration {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:h2:mem:bank-testing");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean
    public AccountDao accountDao() {
        JdbcAccountDao accountDao = new JdbcAccountDao();
        accountDao.setDataSource(dataSource());
        return accountDao;

        //return new InMemoryAccountDao();
    }

    @Bean
    public AccountServiceImpl accountService() {
        return new AccountServiceImpl(accountDao());
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
