package com.bytecode.crudnotas.entity;

import javax.persistence.*;

@Entity
@Table(name="user_role", uniqueConstraints = @UniqueConstraint(
        columnNames = { "role", "username" }))
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userroleid", unique = true, nullable = false)
    private Integer userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username", nullable = false)
    private Usuario user;

    @Column(nullable = false, length = 45)
    private String role;

    public UserRole(Usuario user, String role) {
        this.user = user;
        this.role = role;
    }

    public UserRole(){}

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
