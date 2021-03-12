package com.example.jucdemo.lambda;


import com.example.jucdemo.model.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestLambda {
    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );


    @Test
    public void test1() {
//        MyFunction myFunction = (str) -> {
//            String tr = str.toUpperCase();
//            return tr;
//        };
//        MyFunction myFunction2 = (str) -> String.valueOf(str.startsWith("hee"));
//
//        String out = setHandler("helloworld", myFunction);
//        System.out.println("myFunction out:" + out);
//
//        out = setHandler("helloworld", myFunction2);
//        System.out.println(" myFunction2 out:" + out);



        compute(100,200,(param1,param2) -> {
            return  param1 * param2;
        });

        compute(100,200,(param1,param2) -> {
            return  param1 / param2;
        });
    }


    public String setHandler(String str, MyFunction myFunction) {
        return myFunction.getValue(str);
    }

    public void compute(long param1, long param2, MyFunction2<Long,Long> myFunction) {
        System.out.println(myFunction.getValue(param1, param2));
    }


}
