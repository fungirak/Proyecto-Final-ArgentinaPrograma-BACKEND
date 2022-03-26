package com.ProyectoFinalArgProg.crud.security.repository;

import com.ProyectoFinalArgProg.crud.security.entity.Rol;
import com.ProyectoFinalArgProg.crud.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
