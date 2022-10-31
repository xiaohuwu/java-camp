package com.ktb.newbee.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.tomcat.jni.Address;
import org.javers.core.metamodel.annotation.Id;
import org.javers.core.metamodel.annotation.TypeName;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@TypeName("Employee")
@Accessors(chain = true)
@Data
public class Employee {
    @Id
    private String name;


    private int salary;

    private int age;

    private Employee boss;

    private List<Employee> subordinates = new ArrayList<>();

    private Address primaryAddress;

    private Set<String> skills;


}
