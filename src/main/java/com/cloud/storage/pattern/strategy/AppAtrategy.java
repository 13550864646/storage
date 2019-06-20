package com.cloud.storage.pattern.strategy;

import com.cloud.storage.pattern.chain.Handler;
import com.cloud.storage.pattern.chain.StepCountChainHandler;
import com.cloud.storage.pattern.chain.StepDetailChainHandler;
import com.cloud.storage.pattern.state.Context;
import com.cloud.storage.util.Log;
import org.springframework.stereotype.Component;

/**
 * unitA 公司的Ap pA 业务数据处理策略类
 */
@Component("AppAdatabean")
public class AppAtrategy extends Strategy {
    @Override
    public boolean dealData(Context context) {
        Log.getLogger().d(" Strategy data start save in db !");
        Handler newStepCountChainHandler = new StepCountChainHandler();
        Handler newStepDetailChainHandler = new StepDetailChainHandler();
        newStepCountChainHandler.setSuccessor(newStepDetailChainHandler);
        return newStepCountChainHandler.HandleRequest(context);
    }
}
