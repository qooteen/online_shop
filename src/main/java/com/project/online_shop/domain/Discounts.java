package com.project.online_shop.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "discounts")
public class Discounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discount_id;

    public Discounts() {
    }

    @Column(name = "descriprion_discount")
    private String descriprion_discount;

    @Column(name = "value")
    private Double value;

    @OneToMany(mappedBy = "discount_id", cascade = CascadeType.ALL)
    private Set<Users> users = new HashSet<>();

    public Long getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(Long discount_id) {
        this.discount_id = discount_id;
    }

    public String getDescriprion_discount() {
        return descriprion_discount;
    }

    public void setDescriprion_discount(String descriprion_discount) {
        this.descriprion_discount = descriprion_discount;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Discounts{" +
                "discount_id=" + discount_id +
                ", descriprion_discount='" + descriprion_discount + '\'' +
                ", value=" + value +
                '}';
    }
}
