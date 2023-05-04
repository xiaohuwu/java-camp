package com.ktb.proxy;

public class ProxyTest implements Person {
    private Person person;



    public void setPerson(Person person) {
        this.person = person;
    }

    public static void main(String[] args) {
        ProxyTest proxyTest = new ProxyTest();
        Student student = new Student();
        proxyTest.setPerson(student);
        proxyTest.sayHello("hello", 10);
        System.out.println("******");
        proxyTest.sayGoodBye(true, 10.0);
    }

    @Override
    public void sayHello(String content, int age) {
        System.out.println("\"sayHello begin\" = " + "sayHello begin");
        person.sayHello(content, age);
        System.out.println("\"sayHello end\" = " + "sayHello end");
    }

    @Override
    public void sayGoodBye(boolean seeAgin, double time) {
        System.out.println("\"sayGoodBye begin\" = " + "sayGoodBye begin");
        person.sayGoodBye(seeAgin, time);
        System.out.println("\"sayGoodBye end\" = " + "sayGoodBye end");
    }
}
