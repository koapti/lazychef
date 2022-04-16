package com.koapti.lazychef.model.entity;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.koapti.lazychef.model.states.FoodState;
import com.koapti.lazychef.model.states.OrderState;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false)
    private Integer id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "state", nullable = false)
    private OrderState state;

    @Column(name = "table_nr", nullable = false)
    private Integer tableNr;

    @OneToMany(mappedBy = "order")
    private Set<OrdersFood> ordersFoods = new LinkedHashSet<>();

    public Set<OrdersFood> getOrdersFoods() {
        return ordersFoods;
    }

    public void setOrdersFoods(Set<OrdersFood> ordersFoods) {
        this.ordersFoods = ordersFoods;
    }

    public Integer getTableNr() {
        return tableNr;
    }

    public void setTableNr(Integer tableNr) {
        this.tableNr = tableNr;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}