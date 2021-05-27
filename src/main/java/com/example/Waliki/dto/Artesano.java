package com.example.Waliki.dto;

public class Artesano {
    private  Integer persona_id;
    private String nombre;
    private  String apellido_paterno;
    private String apellido_materno;
    private String apellido_casado;
    private String telefono;
    private String correo_electronico;
    private String fecha_nacimiento;
    private Integer tipo_artesania;
    private Integer usuario_id;
    private Integer emprendedor_id;
    private Integer tipo_emprendimiento_id;
    private Integer contrato_id;

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    private String codigo;

    public Integer getTipo_identificacion_id() {
        return tipo_identificacion_id;
    }

    public void setTipo_identificacion_id(Integer tipo_identificacion_id) {
        this.tipo_identificacion_id = tipo_identificacion_id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    private Integer tipo_identificacion_id;
    private String identificacion;
    public Integer getEmprendedor_id() {
        return emprendedor_id;
    }

    public void setEmprendedor_id(Integer emprendedor_id) {
        this.emprendedor_id = emprendedor_id;
    }

    public Integer getTipo_emprendimiento_id() {
        return tipo_emprendimiento_id;
    }

    public void setTipo_emprendimiento_id(Integer tipo_emprendimiento_id) {
        this.tipo_emprendimiento_id = tipo_emprendimiento_id;
    }

    public Integer getContrato_id() {
        return contrato_id;
    }

    public void setContrato_id(Integer contrato_id) {
        this.contrato_id = contrato_id;
    }

    public Integer getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(Integer persona_id) {
        this.persona_id = persona_id;
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


    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Integer getTipo_artesania() {
        return tipo_artesania;
    }

    public void setTipo_artesania(Integer tipo_artesania) {
        this.tipo_artesania = tipo_artesania;
    }

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
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



    private String usuario;
    private String contrasena;


}
