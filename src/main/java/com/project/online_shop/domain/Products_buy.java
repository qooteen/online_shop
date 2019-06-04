package com.project.online_shop.domain;

import javax.persistence.*;

@Entity
@Table(name = "products_buy")
public class Products_buy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buy_id;

    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "short_description")
    private String short_description;

    @Column(name = "price")
    private Integer price;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Orders order_id;

    @Column(name = "quantity")
    private Integer quantity;

    public Products_buy() {
    }

    public Long getBuy_id() {
        return buy_id;
    }

    public void setBuy_id(Long buy_id) {
        this.buy_id = buy_id;
    }

    public Orders getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Orders order_id) {
        this.order_id = order_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Products_buy{" +
                "buy_id=" + buy_id +
                ", product_id=" + product_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", short_description='" + short_description + '\'' +
                ", price=" + price +
                ", order_id=" + order_id +
                ", quantity=" + quantity +
                '}';
    }
}
