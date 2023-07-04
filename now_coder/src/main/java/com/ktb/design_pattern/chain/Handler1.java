package com.ktb.design_pattern.chain;

public class Handler1 extends Handler{

    @Override
    public void handleRequest(int info) {
        if (info < 10) {
            System.out.println("Handler1完成处理");
        }else{
            if (getNext()!=null){
                getNext().handleRequest(info);
            }else {
                System.out.println("没有处理者进行处理");
            }
        }
    }





}
