package com.project.online_shop.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "address", length = 100)
    private String address;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Roles roles;

    @Column(name = "post_index", length = 50)
    private String post_index;

    @Column(name = "first_name", length = 50)
    private String first_name;

    @Column(name = "second_name", length = 50)
    private String second_name;

    @Column(name = "phone_number", length = 50)
    private String phone_number;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "discount_id")
    private Discounts discount_id;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "active")
    private Boolean active;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Roles getRoles() {
        return roles;
    }

    public Users() {
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Discounts getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(Discounts discount_id) {
        this.discount_id = discount_id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", roles=" + roles +
                ", post_index='" + post_index + '\'' +
                ", first_name='" + first_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", discount_id=" + discount_id +
                ", birthday=" + birthday +
                ", active=" + active +
                '}';
    }
}
