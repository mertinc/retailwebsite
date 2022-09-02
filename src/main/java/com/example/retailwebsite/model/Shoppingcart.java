package com.example.retailwebsite.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="shoppingcart")
public class Shoppingcart {
    @Id
    @Column(name = "id")
    private Long id;

    @JoinColumn(name= "userid")
    @OneToOne(mappedBy = "shoppingcart")
    private User userId;

    @Column(name = "productId")
    @OneToMany(mappedBy = "shoppingcart")
    private Set<Inventory> inventoryId;

    @Column(name="totalprice")
    private double totalprice;

    public Shoppingcart() {
    }
    @JsonCreator
    public Shoppingcart(@JsonProperty("userId") User userId, @JsonProperty("inventoryId") Set<Inventory> inventoryId, @JsonProperty("totalprice") double totalprice) {

        this.userId = userId;
        this.inventoryId = inventoryId;
        this.totalprice = totalprice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Set<Inventory> getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Set<Inventory> inventoryId) {
        this.inventoryId = inventoryId;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    @Override
    public String toString() {
        return "Shoppingcart{" +
                "id=" + id +
                ", userId=" + userId +
                ", inventoryId=" + inventoryId +
                ", totalprice=" + totalprice +
                '}';
    }
}