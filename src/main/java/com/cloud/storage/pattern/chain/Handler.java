package com.cloud.storage.pattern.chain;

import com.cloud.storage.pattern.state.Context;

/**
 * 责任抽象类（责任链模式）
 */
public abstract class Handler {
//    下一个责任类的引用
    protected Handler successor;

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    /**
     * deal the request
     * @param context
     * @return
     */
    public abstract boolean HandleRequest(Context context);
}
