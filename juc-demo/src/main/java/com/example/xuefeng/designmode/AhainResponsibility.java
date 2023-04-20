package com.example.xuefeng.designmode;

import lombok.extern.slf4j.Slf4j;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class AhainResponsibility {
    public static void main(String[] args) {
// 构造责任链:
        HandlerChain1 chain = new HandlerChain1();
        chain.addHandler(new ManagerHandler());
        chain.addHandler(new DirectorHandler());
        chain.addHandler(new CEOHandler());
// 处理请求:
//        chain.process(new Request("Bob", new BigDecimal("123.45")));
//        chain.process(new Request("Alice", new BigDecimal("1234.56")));
        chain.process(new Request("Bill", new BigDecimal("12345.67")));
//        chain.process(new Request("John", new BigDecimal("123456.78")));

    }
}


class Request {
    private String name;
    private BigDecimal amount;

    public Request(String name, BigDecimal amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}


interface Handler {
    // 返回Boolean.TRUE = 成功
    // 返回Boolean.FALSE = 拒绝
    // 返回null = 交下一个处理
    Boolean process(Request request);
}

class HandlerChain1 {
    private List<Handler> handlers = new ArrayList<>();

    public void addHandler(Handler handler) {
        handlers.add(handler);
    }

    public boolean process(Request request) {
        for (Handler handler : handlers) {
            Boolean process = handler.process(request);
            if (process != null) {
                System.out.println(request + " " + (process ? "Approved by " : "Denied by ") + handler.getClass().getSimpleName());
                return process;
            }
        }
        throw new RuntimeException("not found");
    }
}


class ManagerHandler implements Handler {
    public Boolean process(Request request) {
        // 如果超过1000元，处理不了，交下一个处理:
        if (request.getAmount().compareTo(BigDecimal.valueOf(1000)) > 0) {
            return null;
        }
        // 对Bob有偏见:
        return !request.getName().equalsIgnoreCase("bob");
    }
}


class DirectorHandler implements Handler {
    public Boolean process(Request request) {
        // 如果超过1000元，处理不了，交下一个处理:
        if (request.getAmount().compareTo(BigDecimal.valueOf(2000)) > 0) {
            return null;
        }
        // 对Bob有偏见:
        return !request.getName().equalsIgnoreCase("bob");
    }
}

@Slf4j
class CEOHandler implements Handler {
    public Boolean process(Request request) {
        // 如果超过1000元，处理不了，交下一个处理:
        String s = "CEOHandler 已经处理";
        log.info("s:{}", s);
        return true;
    }
}


