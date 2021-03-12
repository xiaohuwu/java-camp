package com.example.dockerdemo;

class ExtendTest{
	public static void main(String[] args) {
		Student s = new Student("zhangsan",'m',1,3333,89,65,88);
		String info = s.toString1();
		System.out.println("s\'info"+info);

		double aver = s.aver();
		System.out.println("averange is"+aver);
 
		int max = s.max();
		System.out.println("max is"+max);
	}
}
class Person{
	public String name;
	public char sex;
	public int age;
	Person(){
	}
	Person(String name,char sex,int age){
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	String toString1(){
		return this.name+this.sex+this.age;
	}
}
class Student extends Person{
	long number;
	int math;
	int english;
	int computer;
//
//	Student(String name,char sex,int age){
//		super();
//		this.name = name;
//		this.sex = sex;
//		this.age = age;
//	}
	Student(String name,char sex,int age,long number,int math,int english,int computer){
		super(name,sex,age);
		this.number = number;
		this.math = math;
		this.english = english;
		this.computer = computer;
	}
	double aver(){
		return (this.math+this.english+this.computer)/3.0;
	}
	int max(){
		int max = 0;
		if(this.math>max)max=this.math;
		if(this.english>max)max=this.english;
		if(this.computer>max)max=this.computer;
		return max;
	}
}