
package com.ProyectoFinalArgProg.crud.dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author fungirak
 */


public class ExperienciaDto {

    @NotBlank
    private String empresa;
    @NotBlank
    private String ubicacion;  
    @NotBlank
    private String puesto;
    @NotBlank
    private String periodo;
    @NotBlank
    private String actividades;


    public ExperienciaDto(){
    
    }

    public ExperienciaDto( @NotBlank String empresa,  @NotBlank String ubicacion,  @NotBlank String puesto, @NotBlank String periodo,  @NotBlank String actividades){
       this.empresa = empresa;
       this.ubicacion = ubicacion;
       this.puesto = puesto;
       this.periodo = periodo;
       this.actividades = actividades;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }


    
}
