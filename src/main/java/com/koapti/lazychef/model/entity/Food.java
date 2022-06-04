package com.koapti.lazychef.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import com.koapti.lazychef.model.types.FoodType;

@Entity
@Table(name = "food", indexes = {
        @Index(name = "food_name_uindex", columnList = "name", unique = true)
})
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_food", nullable = false)
    private Integer id;

    @Column(name = "cost", nullable = false)
    private Double cost;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "type", nullable = false)
    private FoodType type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public FoodType getType() {
        return type;
    }

    public void setType(FoodType type) {
        this.type = type;
    }

}