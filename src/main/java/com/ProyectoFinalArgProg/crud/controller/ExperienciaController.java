
package com.ProyectoFinalArgProg.crud.controller;

import com.ProyectoFinalArgProg.crud.dto.Mensaje;
import com.ProyectoFinalArgProg.crud.entity.Experiencia;
import com.ProyectoFinalArgProg.crud.dto.ExperienciaDto;
import com.ProyectoFinalArgProg.crud.service.ExperienciaService;

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
public class ExperienciaController {
    


//-------------------------- EXPERIENCIA CONTROLLER ----------------------------------
    @Autowired
    private ExperienciaService expeServ;

    @PreAuthorize("hasRole('USER')")
        @GetMapping("/experiencias")
            public ResponseEntity<List<Experiencia>> list(){
                List<Experiencia> list = expeServ.verExperiencias();
                return new ResponseEntity(list, HttpStatus.OK);
            }

    @PreAuthorize("hasRole('USER')")
        @GetMapping("/experiencias/{id}")
            public ResponseEntity<Experiencia> getById(@PathVariable("id") Long id){
                if(!expeServ.existsExperiencia(id))
                    return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
                Experiencia exp = expeServ.buscarExperiencia(id);
                return new ResponseEntity(exp, HttpStatus.OK);
            }
    
    @PreAuthorize("hasRole('USER')")
        @PostMapping("/experiencias")
        public ResponseEntity<?> create(@RequestBody ExperienciaDto expe){
            Experiencia expeNuevo = new Experiencia( expe.getEmpresa(), expe.getUbicacion(), expe.getPuesto(), expe.getPeriodo(), expe.getActividades() );
            expeServ.crearExperiencia(expeNuevo);
            return new ResponseEntity(new Mensaje("Experiencia Item creado."), HttpStatus.OK);
        }

    @PreAuthorize("hasRole('USER')")
        @DeleteMapping("/experiencias/{id}")
        public ResponseEntity<?> delete(@PathVariable("id")Long id){
            if(!expeServ.existsExperiencia(id))
                return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
            expeServ.borrarExperiencia(id);
            return new ResponseEntity(new Mensaje("Item Experiencia eliminado."), HttpStatus.OK);
        }

    @PreAuthorize("hasRole('USER')")
        @PutMapping("/experiencias/{id}")
        public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody ExperienciaDto expeDto){
            if(!expeServ.existsExperiencia(id))
                return new ResponseEntity(new Mensaje("No existe el item buscado."), HttpStatus.NOT_FOUND);
            if(StringUtils.isBlank(expeDto.getEmpresa()))
                return new ResponseEntity(new Mensaje("Ingresar la Empresa es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(expeDto.getUbicacion()))
                return new ResponseEntity(new Mensaje("Ingresar la Ubicacion es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(expeDto.getPuesto()))
                return new ResponseEntity(new Mensaje("Ingresar el Puesto es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(expeDto.getPeriodo()))
                return new ResponseEntity(new Mensaje("Ingresar el Periodo es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(expeDto.getActividades()))
                return new ResponseEntity(new Mensaje("Ingresar Actividades  es obligatorio."), HttpStatus.BAD_REQUEST);
            

            Experiencia expeEdit = expeServ.buscarExperiencia(id);
            expeEdit.setEmpresa(expeDto.getEmpresa());
            expeEdit.setUbicacion(expeDto.getUbicacion());
            expeEdit.setPuesto(expeDto.getPuesto());
            expeEdit.setPeriodo(expeDto.getPeriodo());
            expeEdit.setActividades(expeDto.getActividades());
            expeServ.crearExperiencia(expeEdit);
            return new ResponseEntity(new Mensaje("Item Experiencia actualizado."), HttpStatus.OK);
        }
    
  //-------------------------- FIN EXPERIENCIA CONTROLLER ----------------------------------
 
  // ************************************************************************************




}
