package com.cloud.storage.pattern.state;

/**
 * 状态抽象类（状态模式）
 */
public abstract class State {
    //数据处理方法， Context 为参数封装类
    public abstract void handle(Context context);
}
