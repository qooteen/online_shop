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
    private String description_role;

    @OneToMany(mappedBy = "role_id", cascade = CascadeType.ALL)
    private Set<Users> users = new HashSet<>();

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

    public Roles() {
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getDescription_role() {
        return description_role;
    }

    public void setDescription_role(String description_role) {
        this.description_role = description_role;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "role_id=" + role_id +
                ", description_role='" + description_role + '\'' +
                '}';
    }
}
