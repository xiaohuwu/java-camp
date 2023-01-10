package com.example.springbootjpa.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    int id;


    String username;


    String password;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    AccountDetail accountDetail;


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
