package com.example.Waliki.dto;

import org.springframework.web.bind.annotation.RestController;

@RestController

public class Persona {
    private  Integer persona_id;
    private Integer direccion_id;
    private  Integer tipo_identificacion_id;
    private String nombre;
    private  String apellido_paterno;
    private String apellido_materno;
    private String apellido_casado;
    private String telefono;
    private String correo_electronico;
    private String numero_identificacion;
    private String fecha_nacimiento;


    public Integer getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(Integer persona_id) {
        this.persona_id = persona_id;
    }

    public Integer getDireccion_id() {
        return direccion_id;
    }

    public void setDireccion_id(Integer direccion_id) {
        this.direccion_id = direccion_id;
    }

    public Integer getTipo_identificacion_id() {
        return tipo_identificacion_id;
    }

    public void setTipo_identificacion_id(Integer tipo_identificacion_id) {
        this.tipo_identificacion_id = tipo_identificacion_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getApellido_casado() {
        return apellido_casado;
    }

    public void setApellido_casado(String apellido_casado) {
        this.apellido_casado = apellido_casado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getNumero_identificacion() {
        return numero_identificacion;
    }

    public void setNumero_identificacion(String numero_identificacion) {
        this.numero_identificacion = numero_identificacion;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }




}
