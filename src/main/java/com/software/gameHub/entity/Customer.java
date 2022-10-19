package com.software.gameHub.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    private String mail;

    private String name;

    private String surname;

    private String password;

    private String passwordMatch;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn
    private Library library;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn()
    private Wallet wallet;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn
    private Basket basket;

    @OneToMany(fetch = FetchType.LAZY ,cascade = CascadeType.MERGE,mappedBy = "customer")
    private List<Comment> comments;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "customer")
    private Buy buy;

}
