package com.xkcoding.log4j2;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class SpringBootDemoLog4j2Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootDemoLog4j2Application.class, args);
        int length = context.getBeanDefinitionNames().length;
        log.trace("Spring boot启动初始化了 {} 个 Bean", length);
        log.debug("Spring boot启动初始化了 {} 个 Bean", length);
        log.info("Spring boot启动初始化了 {} 个 Bean", length);
        log.warn("Spring boot启动初始化了 {} 个 Bean", length);
        log.error("Spring boot启动初始化了 {} 个 Bean", length);
        try {
            int i = 0;
            int j = 1 / i;
        } catch (Exception e) {
            log.error("【SpringBootDemoLogbackApplication】启动异常：", e);
        }
        ConfigurationFactory factory;
    }
}
/**
 * pom中要添加两个相关包才能开启异步日志。配置日志流程时先设置appender，然后设置loggers，loggers分两类
 * 一类是root一类时普通logger，前者是对所有生效，后者是对符合设置的相应的报名生效。
 * appender是上面两类日志复合条件时，要记录（append）的方式，一般输出到console和文件两类。文件又可以
 * 有更详细的设置。
 */
