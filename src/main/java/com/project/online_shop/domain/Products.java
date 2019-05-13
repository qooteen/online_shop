package com.project.online_shop.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;

    @Column(name = "image", length = 50)
    private String image;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturers manufacturer_id;

    @Column(name = "short_description", length = 50)
    private String short_description;

    @Column(name = "avalible")
    private Boolean avalible;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Orders order_id;

    @OneToMany(mappedBy = "product_id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Products_properties> productsProperties = new HashSet<>();

    @OneToMany(mappedBy = "product_id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Products_images> productsImages = new HashSet<>();

    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
    private Set<Category> categories;

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Products_images> getProductsImages() {
        return productsImages;
    }

    public void setProductsImages(Set<Products_images> productsImages) {
        this.productsImages = productsImages;
    }

    public Set<Products_properties> getProductsProperties() {
        return productsProperties;
    }

    public void setProductsProperties(Set<Products_properties> productsProperties) {
        this.productsProperties = productsProperties;
    }

    public Products() {
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Manufacturers getManufacturer_id() {
        return manufacturer_id;
    }

    public void setManufacturer_id(Manufacturers manufacturer_id) {
        this.manufacturer_id = manufacturer_id;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public Boolean getAvalible() {
        return avalible;
    }

    public void setAvalible(Boolean avalible) {
        this.avalible = avalible;
    }

    public Orders getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Orders order_id) {
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "Products{" +
                "product_id=" + product_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", manufacturer_id=" + manufacturer_id +
                ", short_description='" + short_description + '\'' +
                ", avalible=" + avalible +
                ", order_id=" + order_id +
                '}';
    }
}
