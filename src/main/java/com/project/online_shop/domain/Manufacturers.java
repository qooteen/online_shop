package com.project.online_shop.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.project.online_shop.service.EntityIdResolver;
import javax.persistence.*;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "manufacturer_id",
        resolver = EntityIdResolver.class,
        scope = Manufacturers.class)
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

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
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
