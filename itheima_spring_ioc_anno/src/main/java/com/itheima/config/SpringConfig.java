package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@ComponentScan("com.itheima")
@Configuration
@Import({DataSourceConfig.class})
public class SpringConfig {

}
