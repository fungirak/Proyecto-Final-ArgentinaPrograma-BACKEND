
package com.ProyectoFinalArgProg.crud.controller;

import com.ProyectoFinalArgProg.crud.dto.Mensaje;
import com.ProyectoFinalArgProg.crud.entity.Skill;
import com.ProyectoFinalArgProg.crud.dto.SkillDto;
import com.ProyectoFinalArgProg.crud.service.SkillService;

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
public class SkillController {
    


//-------------------------- SKILL CONTROLLER ----------------------------------
    @Autowired
    private SkillService skServ;

    @PreAuthorize("hasRole('USER')")
        @GetMapping("/skills")
            public ResponseEntity<List<Skill>> list(){
                List<Skill> list = skServ.verSkills();
                return new ResponseEntity(list, HttpStatus.OK);
            }

    @PreAuthorize("hasRole('USER')")
        @GetMapping("/skills/{id}")
            public ResponseEntity<Skill> getById(@PathVariable("id") Long id){
                if(!skServ.existsSkill(id))
                    return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
                Skill sk = skServ.buscarSkill(id);
                return new ResponseEntity(sk, HttpStatus.OK);
            }
    
    @PreAuthorize("hasRole('USER')")
        @PostMapping("/skills")
        public ResponseEntity<?> create(@RequestBody SkillDto sk){
            Skill skNuevo = new Skill( sk.getTecnologia(), sk.getImagen() );
            skServ.crearSkill(skNuevo);
            return new ResponseEntity(new Mensaje("Skill Item creado."), HttpStatus.OK);
        }

   @PreAuthorize("hasRole('USER')")
        @DeleteMapping("/skills/{id}")
        public ResponseEntity<?> delete(@PathVariable("id")Long id){
            if(!skServ.existsSkill(id))
                return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
            skServ.borrarSkill(id);
            return new ResponseEntity(new Mensaje("Item Skill eliminado."), HttpStatus.OK);
        }

    @PreAuthorize("hasRole('USER')")
        @PutMapping("/skills/{id}")
        public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody SkillDto skDto){
            if(!skServ.existsSkill(id))
                return new ResponseEntity(new Mensaje("No existe el item buscado."), HttpStatus.NOT_FOUND);
            if(StringUtils.isBlank(skDto.getTecnologia()))
                return new ResponseEntity(new Mensaje("Ingresar la Tecnología es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(skDto.getImagen()))
                return new ResponseEntity(new Mensaje("Ingresar la Imagen es obligatorio."), HttpStatus.BAD_REQUEST);
           

            Skill skEdit = skServ.buscarSkill(id);
            skEdit.setTecnologia(skDto.getTecnologia());
            skEdit.setImagen(skDto.getImagen());
            skServ.crearSkill(skEdit);
            return new ResponseEntity(new Mensaje("Item Skill actualizado."), HttpStatus.OK);
        }
    
  //-------------------------- FIN SKILL CONTROLLER ----------------------------------
 
  // ************************************************************************************




}
