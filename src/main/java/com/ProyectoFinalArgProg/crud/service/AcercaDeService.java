
package com.ProyectoFinalArgProg.crud.service;

import com.ProyectoFinalArgProg.crud.entity.AcercaDe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.ProyectoFinalArgProg.crud.repository.AcercaDeRepository;


/**
 *
 * @author fungirak
 */

@Service
public class AcercaDeService  {

    @Autowired
    public AcercaDeRepository acercadeRepo;


   
    public List<AcercaDe> verAcercaDe(){
      return acercadeRepo.findAll();
    }

   
    public void crearAcercaDe(AcercaDe acercade){
      acercadeRepo.save(acercade);
    }

   
    
    public void borrarAcercaDe (Long id){
      acercadeRepo.deleteById(id);
    } 
 
    
    public AcercaDe buscarAcercaDe(Long id){
      return acercadeRepo.findById(id).orElse(null);
    }

   
    public void editarAcercaDe (Long id, AcercaDe acercade){
         acercadeRepo.findById(id).map( editAcerc -> {
         editAcerc.setFullname(acercade.getFullname());
         editAcerc.setPosicion(acercade.getPosicion());
         editAcerc.setDescripcion(acercade.getDescripcion());

         return acercadeRepo.save(editAcerc);
      });
        //.orElseGet(() -> {
        //  acercade.setId(id);
        //  return acercadeRepo.save(acercade);
        //});
    }
    

      
           
           public Boolean existsAcercaDe(Long id){
                try {
                  acercadeRepo.findById(id);
                  return true;
                 } catch(Exception e){
                    return false;
                 }
           }

          

          

}
