package com.kanishka.productbackendboot.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    // @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String category;
    private Integer code;
    private double price;
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name="PRODUCT_ID")
    private List<Detail> details;

    public Product(String name, String category, Integer code, double price, List<Detail> details) {
        this.name = name;
        this.category = category;
        this.code = code;
        this.price = price;
        this.details = details;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }
}

