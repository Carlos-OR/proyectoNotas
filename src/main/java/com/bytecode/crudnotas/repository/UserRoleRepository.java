package com.bytecode.crudnotas.repository;

import com.bytecode.crudnotas.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Serializable> {
}
