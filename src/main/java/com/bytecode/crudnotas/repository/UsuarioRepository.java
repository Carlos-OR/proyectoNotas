package com.bytecode.crudnotas.repository;

import com.bytecode.crudnotas.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable> {

    public Usuario findByusuario(String username);

}
