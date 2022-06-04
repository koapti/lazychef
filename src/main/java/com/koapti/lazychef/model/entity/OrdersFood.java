package com.koapti.lazychef.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.koapti.lazychef.model.states.FoodState;
import com.koapti.lazychef.model.states.OrderState;

@Entity
@Table(name = "orders_food")
public class OrdersFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orders_food", nullable = false)
    private Integer id;

    @Column(name = "comments")
    private String comments;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "state", nullable = false)
    private FoodState state;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_food_fk", nullable = false)
    private Food idFoodFk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_order_fk", nullable = false)
    private Order idOrderFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public FoodState getState() {
        return state;
    }

    public void setState(FoodState state) {
        this.state = state;
    }

    public Food getIdFoodFk() {
        return idFoodFk;
    }

    public void setIdFoodFk(Food idFoodFk) {
        this.idFoodFk = idFoodFk;
    }

    public Order getIdOrderFk() {
        return idOrderFk;
    }

    public void setIdOrderFk(Order idOrderFk) {
        this.idOrderFk = idOrderFk;
    }

}