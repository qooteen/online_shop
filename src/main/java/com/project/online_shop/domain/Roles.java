package com.project.online_shop.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id;


    @Column(name = "description_role", length = 100)
    private String descriptionrole;

    public Roles() {
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getDescriptionrole() {
        return descriptionrole;
    }

    public void setDescriptionrole(String description_role) {
        this.descriptionrole = description_role;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "role_id=" + role_id +
                ", descriptionrole='" + descriptionrole + '\'' +
                '}';
    }
}
