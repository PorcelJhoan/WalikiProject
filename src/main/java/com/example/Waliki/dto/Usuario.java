package com.example.Waliki.dto;

public class Usuario {

    private Integer usuario_id;
    private  Integer tipo_usuario_id;
    private  String usuario;
    private  String contrasena;
    private String fecha_registro;
    private  String codigo_verificacion;
    private Integer persona_id;

    public Usuario() {
    }

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Integer getTipo_usuario_id() {
        return tipo_usuario_id;
    }

    public void setTipo_usuario_id(Integer tipo_usuario_id) {
        this.tipo_usuario_id = tipo_usuario_id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getCodigo_verificacion() {
        return codigo_verificacion;
    }

    public void setCodigo_verificacion(String codigo_verificacion) {
        this.codigo_verificacion = codigo_verificacion;
    }

    public Integer getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(Integer persona_id) {
        this.persona_id = persona_id;
    }



}
