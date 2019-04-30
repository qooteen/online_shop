package com.project.online_shop.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "manufacturers")
public class Manufacturers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long manufacturer_id;

    @Column(name = "manufacturer_name", length = 50)
    private String manufacturer_name;

    @Column(name = "logo", length = 50)
    private String logo;

    @Column(name = "description_manufacturer", length = 100)
    private String description_manufacturer;

    @Column(name = "site", length = 100)
    private String site;

    @OneToMany(mappedBy = "manufacturer_id", cascade = CascadeType.ALL)
    private Set<Products> products = new HashSet<>();

    public Set<Products> getProducts() {
        return products;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }

    public Manufacturers() {
    }

    public Long getManufacturer_id() {
        return manufacturer_id;
    }

    public void setManufacturer_id(Long manufacturer_id) {
        this.manufacturer_id = manufacturer_id;
    }

    public String getManufacturer_name() {
        return manufacturer_name;
    }

    public void setManufacturer_name(String manufacturer_name) {
        this.manufacturer_name = manufacturer_name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription_manufacturer() {
        return description_manufacturer;
    }

    public void setDescription_manufacturer(String description_manufacturer) {
        this.description_manufacturer = description_manufacturer;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public String toString() {
        return "Manufacturers{" +
                "manufacturer_id=" + manufacturer_id +
                ", manufacturer_name='" + manufacturer_name + '\'' +
                ", logo='" + logo + '\'' +
                ", description_manufacturer='" + description_manufacturer + '\'' +
                ", site='" + site + '\'' +
                '}';
    }
}
