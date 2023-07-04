package com.ktb.design_pattern.chain;

public class Handler2 extends Handler {

    @Override
    public void handleRequest(int info) {
        if (info >= 10 && info <=20) {
            System.out.println("Handler2完成处理");
        }else{
            if (getNext()!=null){
                getNext().handleRequest(info);
            }else {
                System.out.println("没有处理者进行处理");
            }
        }
    }
}
