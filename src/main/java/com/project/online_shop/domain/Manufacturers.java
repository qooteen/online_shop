package com.project.online_shop.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "manufacturers")
public class Manufacturers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long manufacturer_id;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "logo", length = 50)
    private String logo;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "site", length = 100)
    private String site;

    @OneToMany(mappedBy = "manufacturer_id", cascade = CascadeType.ALL)
    private Set<Products> products;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                ", title='" + title + '\'' +
                ", logo='" + logo + '\'' +
                ", description='" + description + '\'' +
                ", site='" + site + '\'' +
                '}';
    }
}
