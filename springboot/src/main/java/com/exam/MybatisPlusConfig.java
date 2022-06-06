package com.exam;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement // 开启注解事务管理，等价于xml配置方式的 <tx:annotation-driven />
@Configuration
@MapperScan("com.exam.service.*.mapper*") // 指定要变成实现类的接口所在的包，然后包下面的所有接口在编译之后都会生成相应的实现类
public class MybatisPlusConfig {
    /**
     * 分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
