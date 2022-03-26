package com.ProyectoFinalArgProg.crud.dto;

import javax.validation.constraints.NotBlank;

public class AcercaDeDto {

    @NotBlank
    private String fullname;
    @NotBlank
    private String posicion;
    @NotBlank
    private String descripcion;
   

    

    public AcercaDeDto(@NotBlank String fullname, @NotBlank String posicion, @NotBlank String descripcion) {
        this.fullname = fullname;
        this.posicion = posicion;
        this.descripcion = descripcion;
      
    }

    public AcercaDeDto() {
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion (String descripcion) {
        this.descripcion = descripcion;
    }


    
}
