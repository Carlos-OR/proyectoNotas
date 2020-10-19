package com.bytecode.crudnotas.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {
    @Id
    @Column(nullable = false, unique = true, length = 45)
    private String usuario;

    @Column(nullable = false, length = 60)
    private String contra;

    @Column(nullable = false)
    private boolean disponible;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<UserRole> userRole = new HashSet<UserRole>();

    public Usuario(String usuario, String contra, boolean disponible) {
        this.usuario = usuario;
        this.contra = contra;
        this.disponible = disponible;
    }

    public Usuario(String usuario, String contra, boolean disponible, Set<UserRole> userRole) {
        this.usuario = usuario;
        this.contra = contra;
        this.disponible = disponible;
        this.userRole = userRole;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Set<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }
}
