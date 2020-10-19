package com.bytecode.crudnotas.repository;

import com.bytecode.crudnotas.entity.Notas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface NotaRepository extends JpaRepository<Notas, Serializable> {
}
