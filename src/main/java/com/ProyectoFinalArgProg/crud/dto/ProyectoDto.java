
package com.ProyectoFinalArgProg.crud.dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author fungirak
 */


public class ProyectoDto {

    @NotBlank
    private String titulo;
    @NotBlank
    private String imagen;
    @NotBlank
    private String descripcion;  
   


    public ProyectoDto(){
    
    }

    public ProyectoDto( @NotBlank String titulo,  @NotBlank String imagen,  @NotBlank String descripcion){
       this.titulo = titulo;
       this.imagen = imagen;
       this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
 

   
}
