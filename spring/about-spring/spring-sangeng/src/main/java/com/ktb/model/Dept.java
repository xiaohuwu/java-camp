package com.ktb.model;

public class Dept {
    private String name;
    private Employee employee;

    public Dept() {
    }

    public Dept(String name, Employee employee) {
        this.name = name;
        this.employee = employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Dept{");
        sb.append("name='").append(name).append('\'');
        sb.append(", employee=").append(employee);
        sb.append('}');
        return sb.toString();
    }
}
