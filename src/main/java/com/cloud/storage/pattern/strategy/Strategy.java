package com.cloud.storage.pattern.strategy;

import com.cloud.storage.pattern.state.Context;

/**
 * 策略的抽象类（策略模式）
 */
public abstract class Strategy {
    //策略的处理方法， context 为多参数的封装类
    public abstract boolean dealData(Context context) ;
}
