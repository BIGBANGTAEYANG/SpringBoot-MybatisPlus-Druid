package com.ybb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@MapperScan("com.ybb.sys.mapper")
@EnableTransactionManagement
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) //添加了数据库的依赖，启动时会检测数据库配置信息
public class SalemanageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalemanageApplication.class, args);
	}

}

