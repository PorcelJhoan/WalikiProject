package com.example.Waliki.dto;

public class A_Emprendedor {

    private Integer emprendedor_id;
    private String nombre;
    private String telefono;
    private String correo;
    private String tipo_identificacion;
    private String numero_identificacion;
    private String ciudad;
    private Integer persona_id;
    private String numero_cuenta;
    private Integer numero_proyectos;
    private Integer direccion_id;

    public Integer getEmprendedor_id() {
        return emprendedor_id;
    }

    public void setEmprendedor_id(Integer emprendedor_id) {
        this.emprendedor_id = emprendedor_id;
    }

    public Integer getDireccion_id() {
        return direccion_id;
    }

    public void setDireccion_id(Integer direccion_id) {
        this.direccion_id = direccion_id;
    }


    public Integer getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(Integer persona_id) {
        this.persona_id = persona_id;
    }



    public String getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(String numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }




    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo_identificacion() {
        return tipo_identificacion;
    }

    public void setTipo_identificacion(String tipo_identificacion) {
        this.tipo_identificacion = tipo_identificacion;
    }

    public String getNumero_identificacion() {
        return numero_identificacion;
    }

    public void setNumero_identificacion(String numero_identificacion) {
        this.numero_identificacion = numero_identificacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }



    public Integer getNumero_proyectos() {
        return numero_proyectos;
    }

    public void setNumero_proyectos(Integer numero_proyectos) {
        this.numero_proyectos = numero_proyectos;
    }
}
