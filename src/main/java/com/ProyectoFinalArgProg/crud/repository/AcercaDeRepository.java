
package com.ProyectoFinalArgProg.crud.repository;


import com.ProyectoFinalArgProg.crud.entity.AcercaDe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fungirak
 */

@Repository
public interface AcercaDeRepository extends JpaRepository <AcercaDe, Long> {
       

}
