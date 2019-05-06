package com.project.online_shop.domain;


import javax.persistence.*;

@Entity
@Table(name = "products_images")
public class Products_images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long products_image_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Products product_id;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "image_name", length = 100)
    private String image_name;

    public Products_images() {
    }

    public Long getProducts_image_id() {
        return products_image_id;
    }

    public void setProducts_image_id(Long products_image_id) {
        this.products_image_id = products_image_id;
    }

    public Products getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Products product_id) {
        this.product_id = product_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    @Override
    public String toString() {
        return "Products_imagesDAO{" +
                "products_image_id=" + products_image_id +
                ", product_id=" + product_id +
                ", title='" + title + '\'' +
                ", image_name='" + image_name + '\'' +
                '}';
    }
}
