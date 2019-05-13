package com.project.online_shop.domain;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Item {
    private Products products;
    private int quantity;




    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item(Products products, int quantity) {
        this.products = products;
        this.quantity = quantity;
        Hibernate.unproxy(this.products);
    }

    public Item() {
    }
}
