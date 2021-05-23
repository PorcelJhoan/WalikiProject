package com.example.Waliki.dto;

import javax.print.DocFlavor;

public class A_Proyecto {
    private String nombre;
    private String nombrep;
    private String fecha_publicacion;
    private String fecha_fin;
    private Integer proyecto_id;
    private String Descripcion;
    private Double Monto_requerido;
    private Double Monto_recaudado;
    private Integer persona_id;
    private String Estado;

    public String getNombrep() {
        return nombrep;
    }

    public void setNombrep(String nombrep) {
        this.nombrep = nombrep;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Integer getProyecto_id() {
        return proyecto_id;
    }

    public void setProyecto_id(Integer proyecto_id) {
        this.proyecto_id = proyecto_id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Double getMonto_requerido() {
        return Monto_requerido;
    }

    public void setMonto_requerido(Double monto_requerido) {
        Monto_requerido = monto_requerido;
    }

    public Double getMonto_recaudado() {
        return Monto_recaudado;
    }

    public void setMonto_recaudado(Double monto_recaudado) {
        Monto_recaudado = monto_recaudado;
    }

    public Integer getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(Integer persona_id) {
        this.persona_id = persona_id;
    }
}
