package com.ktb.design_pattern.chain;

/**
 * 责任链模式
 */
public abstract class Handler {
    private Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    //处理请求
    public abstract void handleRequest(int info);

}
