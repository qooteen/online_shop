package com.project.online_shop.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.project.online_shop.service.EntityIdResolver;

import javax.persistence.*;
import java.util.Set;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "products_property_id",
        resolver = EntityIdResolver.class,
        scope = Products_properties.class)
@Entity
@Table(name = "products_properties")
public class Products_properties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long products_property_id;

    @Column(name = "size", length = 50)
    private String size;

    @Column(name = "size_value")
    private Integer size_value;

    @OneToMany(mappedBy = "property", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Set<Products> products;

    public Products_properties() {
    }

    public Set<Products> getProducts() {
        return products;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }

    public Long getProducts_property_id() {
        return products_property_id;
    }

    public void setProducts_property_id(Long products_property_id) {
        this.products_property_id = products_property_id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getSize_value() {
        return size_value;
    }

    public void setSize_value(Integer size_value) {
        this.size_value = size_value;
    }

    @Override
    public String toString() {
        return "Products_properties{" +
                "products_property_id=" + products_property_id +
                ", size='" + size + '\'' +
                ", size_value=" + size_value +
                '}';
    }
}
