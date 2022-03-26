
package com.ProyectoFinalArgProg.crud.dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author fungirak
 */


public class EducacionDto {

    @NotBlank
    private String institucion;
    @NotBlank
    private String titulo;  
    @NotBlank
    private String periodo;
    @NotBlank
    private String estado;
    @NotBlank
    private String detalles;


    public EducacionDto(){
    
    }

    public EducacionDto(@NotBlank  String institucion, @NotBlank String titulo, @NotBlank String periodo, @NotBlank String estado, @NotBlank String detalles){
       this.institucion = institucion;
       this.titulo = titulo;
       this.periodo = periodo;
       this.estado = estado;
       this.detalles = detalles;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }


    
}
