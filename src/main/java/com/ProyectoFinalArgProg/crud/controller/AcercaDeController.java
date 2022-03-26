
package com.ProyectoFinalArgProg.crud.controller;

import com.ProyectoFinalArgProg.crud.dto.Mensaje;
import com.ProyectoFinalArgProg.crud.entity.AcercaDe;
import com.ProyectoFinalArgProg.crud.dto.AcercaDeDto;
import com.ProyectoFinalArgProg.crud.service.AcercaDeService;
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
public class AcercaDeController {
    


//-------------------------- ACERCA DE CONTROLLER ----------------------------------
    @Autowired
    private AcercaDeService acercadeServ;

    @PreAuthorize("hasRole('USER')")
        @GetMapping("/acerca_de")
            public ResponseEntity<List<AcercaDe>> list(){
                List<AcercaDe> list = acercadeServ.verAcercaDe();
                return new ResponseEntity(list, HttpStatus.OK);
            }
    @PreAuthorize("hasRole('USER')")
        @GetMapping("/acerca_de/{id}")
            public ResponseEntity<AcercaDe> getById(@PathVariable("id") Long id){
                if(!acercadeServ.existsAcercaDe(id))
                    return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
                AcercaDe acercade = acercadeServ.buscarAcercaDe(id);
                return new ResponseEntity(acercade, HttpStatus.OK);
            }
    
    @PreAuthorize("hasRole('USER')")
        @PostMapping("/acerca_de")
        public ResponseEntity<?> create(@RequestBody AcercaDeDto acerc){
            AcercaDe acercaNuevo = new AcercaDe( acerc.getFullname(), acerc.getPosicion(), acerc.getDescripcion() );
            acercadeServ.crearAcercaDe(acercaNuevo);
            return new ResponseEntity(new Mensaje("acerca de creado"), HttpStatus.OK);
        }

    @PreAuthorize("hasRole('USER')")
        @DeleteMapping("/acerca_de/{id}")
        public ResponseEntity<?> delete(@PathVariable("id")Long id){
            if(!acercadeServ.existsAcercaDe(id))
                return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
            acercadeServ.borrarAcercaDe(id);
            return new ResponseEntity(new Mensaje("Item AcercaDe eliminado."), HttpStatus.OK);
        }

     
    @PreAuthorize("hasRole('USER')")
        @PutMapping("/acerca_de/{id}")
        public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody AcercaDeDto acercDto){
            if(!acercadeServ.existsAcercaDe(id))
                return new ResponseEntity(new Mensaje("No existe el item buscado."), HttpStatus.NOT_FOUND);
            if(StringUtils.isBlank(acercDto.getFullname()))
                return new ResponseEntity(new Mensaje("Ingresar el Fullname es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(acercDto.getPosicion()))
                return new ResponseEntity(new Mensaje("Ingresar la Posicion es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(acercDto.getDescripcion()))
                return new ResponseEntity(new Mensaje("Ingresar la Descripcion es obligatorio."), HttpStatus.BAD_REQUEST);
            

            AcercaDe acercEdit = acercadeServ.buscarAcercaDe(id);
            acercEdit.setFullname(acercDto.getFullname());
            acercEdit.setPosicion(acercDto.getPosicion());
            acercEdit.setDescripcion(acercDto.getDescripcion());
            acercadeServ.crearAcercaDe(acercEdit);
            return new ResponseEntity(new Mensaje("Item AcercaDe actualizado."), HttpStatus.OK);
        }

    
  //-------------------------- FIN ACERCA DE CONTROLLER ----------------------------------
 
  // ************************************************************************************




}
