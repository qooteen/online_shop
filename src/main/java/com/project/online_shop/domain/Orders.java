package com.project.online_shop.domain;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema = "public", name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Users user_id;

    @Temporal(TemporalType.DATE)
    @Column(name = "order_date")
    private Date order_date;


    @Column(name = "order_time")
    private LocalTime order_time;

    @OneToMany(mappedBy = "order_id", cascade = CascadeType.ALL)
    private Set<Products> products = new HashSet<>();

    public Set<Products> getProducts() {
        return products;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Users getUser_id() {
        return user_id;
    }

    public void setUser_id(Users user_id) {
        this.user_id = user_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public LocalTime getOrder_time() {
        return order_time;
    }

    public void setOrder_time(LocalTime order_time) {
        this.order_time = order_time;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", order_date=" + order_date +
                ", order_time=" + order_time +
                '}';
    }
}
