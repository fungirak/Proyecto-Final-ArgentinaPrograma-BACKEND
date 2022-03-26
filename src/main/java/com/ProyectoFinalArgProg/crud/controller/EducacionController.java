
package com.ProyectoFinalArgProg.crud.controller;

import com.ProyectoFinalArgProg.crud.dto.Mensaje;
import com.ProyectoFinalArgProg.crud.entity.Educacion;
import com.ProyectoFinalArgProg.crud.dto.EducacionDto;
import com.ProyectoFinalArgProg.crud.service.EducacionService;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fungirak
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class EducacionController {
    

//-------------------------- EDUCACION CONTROLLER ----------------------------------
    @Autowired
    private EducacionService eduServ;

    @PreAuthorize("hasRole('USER')")
        @GetMapping("/educacion") 
            public ResponseEntity<List<Educacion>> list(){
                List<Educacion> list = eduServ.verEducacion();
                return new ResponseEntity(list, HttpStatus.OK);
            }

    @PreAuthorize("hasRole('USER')")
        @GetMapping("/educacion/{id}")
            public ResponseEntity<Educacion> getById(@PathVariable("id") Long id){
                if(!eduServ.existsEducacion(id))
                    return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
                Educacion educ = eduServ.buscarEducacion(id);
                return new ResponseEntity(educ, HttpStatus.OK);
            }
    
    @PreAuthorize("hasRole('USER')")
        @PostMapping("/educacion")
        public ResponseEntity<?> create(@RequestBody EducacionDto edu){
            Educacion eduNuevo = new Educacion( edu.getInstitucion(), edu.getTitulo(), edu.getPeriodo(), edu.getEstado(), edu.getDetalles() );
            eduServ.crearEducacion(eduNuevo);
            return new ResponseEntity(new Mensaje("Educacion Item Creado."), HttpStatus.OK);
        }

    @PreAuthorize("hasRole('USER')")
        @DeleteMapping("/educacion/{id}")
        public ResponseEntity<?> delete(@PathVariable("id")Long id){
            if(!eduServ.existsEducacion(id))
                return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
            eduServ.borrarEducacion(id);
            return new ResponseEntity(new Mensaje("Item Educación eliminado."), HttpStatus.OK);
        }


    @PreAuthorize("hasRole('USER')")
        @PutMapping("/educacion/{id}")
        public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody EducacionDto eduDto){
            if(!eduServ.existsEducacion(id))
                return new ResponseEntity(new Mensaje("No existe el item buscado."), HttpStatus.NOT_FOUND);
            if(StringUtils.isBlank(eduDto.getInstitucion()))
                return new ResponseEntity(new Mensaje("Ingresar la Institucion es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(eduDto.getTitulo()))
                return new ResponseEntity(new Mensaje("Ingresar el Titulo es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(eduDto.getPeriodo()))
                return new ResponseEntity(new Mensaje("Ingresar el Periodo es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(eduDto.getEstado()))
                return new ResponseEntity(new Mensaje("Ingresar el Estado  es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(eduDto.getDetalles()))
                return new ResponseEntity(new Mensaje("Ingresar Detalles es obligatorio."), HttpStatus.BAD_REQUEST);
            

            Educacion eduEdit = eduServ.buscarEducacion(id);
            eduEdit.setInstitucion(eduDto.getInstitucion());
            eduEdit.setTitulo(eduDto.getTitulo());
            eduEdit.setPeriodo(eduDto.getPeriodo());
            eduEdit.setEstado(eduDto.getEstado());
            eduEdit.setDetalles(eduDto.getDetalles());
            eduServ.crearEducacion(eduEdit);
            return new ResponseEntity(new Mensaje("Item Educacion actualizado."), HttpStatus.OK);
        }
    
  //-------------------------- FIN EDUCACION CONTROLLER ----------------------------------
 
  // ************************************************************************************




}
