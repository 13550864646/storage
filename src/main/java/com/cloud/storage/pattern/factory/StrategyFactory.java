package com.cloud.storage.pattern.factory;

import com.cloud.storage.pattern.strategy.Strategy;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

/**
 * 策略工厂， 根据不同的App Type 来生产对应的策略处理类
 */
public class StrategyFactory {
    private Strategy strategy;

    public StrategyFactory(ServletContext sc, String appType) {
        ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
        strategy = (Strategy) ctx.getBean(appType + "databean");
    }

    public Strategy getInstance() {
        return strategy;
    }
}
