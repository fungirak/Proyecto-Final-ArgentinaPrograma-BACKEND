
package com.ProyectoFinalArgProg.crud.dto;

import javax.validation.constraints.NotBlank;


/**
 *
 * @author fungirak
 */

public class SkillDto {

    @NotBlank
    private String tecnologia;
    @NotBlank
    private String imagen;
  
   


    public SkillDto(){
    
    }

    public SkillDto( @NotBlank String tecnologia,  @NotBlank String imagen){
       this.tecnologia = tecnologia;
       this.imagen = imagen;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    

}
