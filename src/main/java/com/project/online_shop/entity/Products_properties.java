package com.project.online_shop.entity;

import javax.persistence.*;

@Entity
@Table(name = "products_properties")
public class Products_properties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long products_property_id;

    @Column(name = "property_name", length = 50)
    private String property_name;

    @Column(name = "property_value", length = 50)
    private String property_value;

    @Column(name = "property_price")
    private Double property_price;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Products product_id;

    public Products_properties() {
    }

    public Long getProducts_property_id() {
        return products_property_id;
    }

    public void setProducts_property_id(Long products_property_id) {
        this.products_property_id = products_property_id;
    }

    public String getProperty_name() {
        return property_name;
    }

    public void setProperty_name(String property_name) {
        this.property_name = property_name;
    }

    public String getProperty_value() {
        return property_value;
    }

    public void setProperty_value(String property_value) {
        this.property_value = property_value;
    }

    public Double getProperty_price() {
        return property_price;
    }

    public void setProperty_price(Double property_price) {
        this.property_price = property_price;
    }

    public Products getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Products product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return "Products_properties{" +
                "products_property_id=" + products_property_id +
                ", property_name='" + property_name + '\'' +
                ", property_value='" + property_value + '\'' +
                ", property_price=" + property_price +
                ", product_id=" + product_id +
                '}';
    }
}
