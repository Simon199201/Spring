package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean("dataSource")
    public DataSource getDataSource() {
        Properties properties = new Properties();
        properties.setProperty("driverClassName", driver);
        properties.setProperty("url", url);
        properties.setProperty("username", username);
        properties.setProperty("password", password);
        try {
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            return dataSource;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
