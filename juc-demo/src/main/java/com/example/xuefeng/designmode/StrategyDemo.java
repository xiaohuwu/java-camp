package com.example.xuefeng.designmode;

import java.math.BigDecimal;
import java.math.RoundingMode;

//策略模式
public class StrategyDemo {
    public static void main(String[] args) {
        DiscountContext discountContext = new DiscountContext();

        discountContext.setStrategy(new OverDiscountStrategy());
        BigDecimal bigDecimal = discountContext.calculatePrice(new BigDecimal(102));
        double v = bigDecimal.doubleValue();
        System.out.println("v = " + v);

        discountContext.setStrategy(new UserDiscountStrategy());
        bigDecimal = discountContext.calculatePrice(new BigDecimal(102));
        v = bigDecimal.doubleValue();
        System.out.println("v = " + v);
    }
}

interface DiscountStrategy{
    BigDecimal getDiscount(BigDecimal total);
}

class  DiscountContext{
    private DiscountStrategy strategy = new UserDiscountStrategy();

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public BigDecimal calculatePrice(BigDecimal total){
        return total.subtract(this.strategy.getDiscount(total)).setScale(2);
    }
}



class UserDiscountStrategy implements DiscountStrategy {
    public BigDecimal getDiscount(BigDecimal total) {
        // 普通会员打九折:
        return total.multiply(new BigDecimal("0.1")).setScale(2, RoundingMode.DOWN);
    }
}



class OverDiscountStrategy implements DiscountStrategy{
    public BigDecimal getDiscount(BigDecimal total) {
        // 满100减20优惠:
        return total.compareTo(BigDecimal.valueOf(100)) >= 0 ? BigDecimal.valueOf(20) : BigDecimal.ZERO;
    }
}