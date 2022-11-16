package com.ktb;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.sql.Timestamp;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public void methodBreak() {
        System.out.println("\"test\" = " + "test");
        int a = 0;
        int b = 0;
        int result = a + b;
        Iservice service = new IserviceImpl();
        service.execute("test");
        System.out.println("result = " + result);
    }


    public void exceptBreak() {
        Object o = null;
        o.toString();
        System.out.println("this lien will be println");
    }

    public void field() {
        Person p = new Person("agege", 16);
        p.setAge(187);
        System.out.println(p);
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        System.out.println("this is a test");
//        methodBreak();
//        exceptBreak();
        field();
    }

}
