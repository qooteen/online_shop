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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Users user;

    @Temporal(TemporalType.DATE)
    @Column(name = "order_date")
    private Date order_date;

    @Column(name = "order_time")
    private LocalTime order_time;

    @OneToMany(mappedBy = "order_id", cascade = CascadeType.ALL)
    private Set<Products_buy> products_buys;

    public Set<Products_buy> getProducts_buys() {
        return products_buys;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order_id=" + order_id +
                ", user_id=" + user +
                ", order_date=" + order_date +
                ", order_time=" + order_time +
                '}';
    }

    public void setProducts_buys(Set<Products_buy> products_buys) {
        this.products_buys = products_buys;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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


}
