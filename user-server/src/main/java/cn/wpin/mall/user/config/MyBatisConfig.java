package cn.wpin.mall.user.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan({"cn.wpin.mall.user.mapper","cn.wpin.mall.user.dao"})
public class MyBatisConfig {
}