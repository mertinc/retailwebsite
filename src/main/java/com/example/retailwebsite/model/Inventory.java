package com.example.retailwebsite.model;


import javax.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "product")
    private String product;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private int price;
    @Column(name = "stock")
    private boolean stock;

    public Inventory() {
    }

    public Inventory(String product, String description, int price,boolean stock) {
        this.product = product;
        this.description = description;
        this.price = price;
        this.stock =stock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", description='" + description + '\'' +
                ", stock='" + stock + '\'' +
                ", price=" + price +
                '}';
    }
}
