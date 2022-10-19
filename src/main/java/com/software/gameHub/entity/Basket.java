package com.software.gameHub.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int basketId;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinTable(
            joinColumns = @JoinColumn,
            inverseJoinColumns = @JoinColumn)
    private List<Game> games;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "basket")
    private Customer customer;

    public Basket(Customer customer) {
        this.customer = customer;
    }
}
