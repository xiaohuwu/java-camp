package com.example.springbootjpa.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "account_detail")
public class AccountDetail {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;


    String address;


    String email;


    String phone;

    String realName;

    @OneToOne
    Account account;


    @Override
    public String toString() {
        return "AccountDetail{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }
}
