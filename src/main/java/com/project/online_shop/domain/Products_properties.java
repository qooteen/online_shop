package com.project.online_shop.domain;

import javax.persistence.*;

@Entity
@Table(name = "products_properties")
public class Products_properties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long products_property_id;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "value", length = 50)
    private String value;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
                ", title='" + title + '\'' +
                ", value='" + value + '\'' +
                ", product_id=" + product_id +
                '}';
    }
}
