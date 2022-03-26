
package com.ProyectoFinalArgProg.crud.service;

import com.ProyectoFinalArgProg.crud.entity.Educacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ProyectoFinalArgProg.crud.repository.EducacionRepository;

/**
 *
 * @author fungirak
 */

@Service
public class EducacionService  {

    @Autowired
    public EducacionRepository educacionRepo;

   
    public List<Educacion> verEducacion(){
      return educacionRepo.findAll();
    }

   
    public void crearEducacion(Educacion edu){
      educacionRepo.save(edu);
    }
   
   
    public void borrarEducacion (Long id){
      educacionRepo.deleteById(id);
    } 
 
   
    public Educacion buscarEducacion(Long id){
      return educacionRepo.findById(id).orElse(null);
    }
    
    
    public void editarEducacion (Long id, Educacion edu){
         educacionRepo.findById(id).map( editEdu -> {
         editEdu.setInstitucion(edu.getInstitucion());
         editEdu.setTitulo(edu.getTitulo());
         editEdu.setPeriodo(edu.getPeriodo());
         editEdu.setEstado(edu.getEstado());
         editEdu.setDetalles(edu.getDetalles());

         return educacionRepo.save(editEdu);
      });
        //.orElseGet(() -> {
        //  acercade.setId(id);
        //  return acercadeRepo.save(acercade);
        //});
    }

     
            public Boolean existsEducacion(Long id){
                try {
                  educacionRepo.findById(id);
                     return true;
                 } catch(Exception e){
                     return false;
                 }
            }

        
      
    
}
