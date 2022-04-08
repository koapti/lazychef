package com.koapti.lazychef.model.entity;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false)
    private Integer id;

    @Column(name = "table_nr", nullable = false)
    private Integer tableNr;

    @Column(name = "state", nullable = false)
    private String state;

    @OneToMany(mappedBy = "idOrder")
    private Set<OrdersDishesDrink> ordersDishesDrinks = new LinkedHashSet<>();

    public Set<OrdersDishesDrink> getOrdersDishesDrinks() {
        return ordersDishesDrinks;
    }

    public void setOrdersDishesDrinks(Set<OrdersDishesDrink> ordersDishesDrinks) {
        this.ordersDishesDrinks = ordersDishesDrinks;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getTableNr() {
        return tableNr;
    }

    public void setTableNr(Integer tableNr) {
        this.tableNr = tableNr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}