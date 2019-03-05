package com.wesly.manage.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.wesly.manage.mapper")
public class MyBatisConfig {
}
