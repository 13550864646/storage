package com.cloud.storage.pattern.strategy;

import com.cloud.storage.pattern.state.Context;
import org.springframework.stereotype.Component;

/**
 * unitA 公司的AppB 业务数据处理策略类
 */
@Component("AppBdatabean")
public class AppBtrategy extends Strategy {
    @Override
    public boolean dealData(Context context) {
        return false;
    }
}
