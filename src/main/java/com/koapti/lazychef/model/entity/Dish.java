package com.koapti.lazychef.model.entity;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dishes", indexes = {
        @Index(name = "dishes_name_uindex", columnList = "name", unique = true)
})
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dish", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "cost", nullable = false)
    private Double cost;

    @OneToMany(mappedBy = "idDish")
    private Set<OrdersDishesDrink> ordersDishesDrinks = new LinkedHashSet<>();

    public Set<OrdersDishesDrink> getOrdersDishesDrinks() {
        return ordersDishesDrinks;
    }

    public void setOrdersDishesDrinks(Set<OrdersDishesDrink> ordersDishesDrinks) {
        this.ordersDishesDrinks = ordersDishesDrinks;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}