
package com.ProyectoFinalArgProg.crud.controller;

import com.ProyectoFinalArgProg.crud.dto.Mensaje;
import com.ProyectoFinalArgProg.crud.entity.Proyecto;
import com.ProyectoFinalArgProg.crud.dto.ProyectoDto;
import com.ProyectoFinalArgProg.crud.service.ProyectoService;

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
public class ProyectoController {
    


//-------------------------- PROYECTO CONTROLLER ----------------------------------
    @Autowired
    private ProyectoService proServ;

    @PreAuthorize("hasRole('USER')")
        @GetMapping("/proyectos")
            public ResponseEntity<List<Proyecto>> list(){
                List<Proyecto> list = proServ.verProyectos();
                return new ResponseEntity(list, HttpStatus.OK);
            }

    @PreAuthorize("hasRole('USER')")
        @GetMapping("/proyectos/{id}")
            public ResponseEntity<Proyecto> getById(@PathVariable("id") Long id){
                if(!proServ.existsProyecto(id))
                    return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
                Proyecto proy = proServ.buscarProyecto(id);
                return new ResponseEntity(proy, HttpStatus.OK);
            }
    
    @PreAuthorize("hasRole('USER')")
        @PostMapping("/proyectos")
        public ResponseEntity<?> create(@RequestBody ProyectoDto proyect){
            Proyecto proyectNuevo = new Proyecto( proyect.getTitulo(), proyect.getImagen(), proyect.getDescripcion() );
            proServ.crearProyecto(proyectNuevo);
            return new ResponseEntity(new Mensaje("Proyecto Item creado."), HttpStatus.OK);
        }

     @PreAuthorize("hasRole('USER')")
        @DeleteMapping("/proyectos/{id}")
        public ResponseEntity<?> delete(@PathVariable("id")Long id){
            if(!proServ.existsProyecto(id))
                return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
            proServ.borrarProyecto(id);
            return new ResponseEntity(new Mensaje("Item Proyecto eliminado."), HttpStatus.OK);
        }

    @PreAuthorize("hasRole('USER')")
        @PutMapping("/proyectos/{id}")
        public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody ProyectoDto proyDto){
            if(!proServ.existsProyecto(id))
                return new ResponseEntity(new Mensaje("No existe el item buscado."), HttpStatus.NOT_FOUND);
            if(StringUtils.isBlank(proyDto.getTitulo()))
                return new ResponseEntity(new Mensaje("Ingresar el Titulo es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(proyDto.getImagen()))
                return new ResponseEntity(new Mensaje("Ingresar la Imagen es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(proyDto.getDescripcion()))
                return new ResponseEntity(new Mensaje("Ingresar la Descripcion es obligatorio."), HttpStatus.BAD_REQUEST);
            

            Proyecto proyEdit = proServ.buscarProyecto(id);
            proyEdit.setTitulo(proyDto.getTitulo());
            proyEdit.setImagen(proyDto.getImagen());
            proyEdit.setDescripcion(proyDto.getDescripcion());
            proServ.crearProyecto(proyEdit);
            return new ResponseEntity(new Mensaje("Item Proyecto actualizado."), HttpStatus.OK);
        }
  //-------------------------- FIN PROYECTO CONTROLLER ----------------------------------
 
  // ************************************************************************************




}
