package com.project.online_shop.domain;

import javax.persistence.*;

@Entity
@Table(name = "products_buy")
public class Products_buy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buy_id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Products product_id;

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

    public Products getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Products product_id) {
        this.product_id = product_id;
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

    @Override
    public String toString() {
        return "Products_buy{" +
                "buy_id=" + buy_id +
                ", product_id=" + product_id +
                ", order_id=" + order_id +
                ", quantity=" + quantity +
                '}';
    }
}
