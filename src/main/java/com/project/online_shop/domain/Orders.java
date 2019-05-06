package com.project.online_shop.domain;

import javax.persistence.*;
import java.sql.Time;
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

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "post_index", length = 50)
    private String post_index;

    @Column(name = "first_name", length = 50)
    private String first_name;

    @Column(name = "second_name", length = 50)
    private String second_name;

    @Column(name = "phone_number", length = 50)
    private String phone_number;

    @Column(name = "order_date")
    private Date order_date;

    @Column(name = "order_time")
    private Time order_time;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPost_index() {
        return post_index;
    }

    public void setPost_index(String post_index) {
        this.post_index = post_index;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Time getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Time order_time) {
        this.order_time = order_time;
    }

    public Orders() {
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", post_index='" + post_index + '\'' +
                ", first_name='" + first_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", order_date=" + order_date +
                ", order_time=" + order_time +
                '}';
    }
}
