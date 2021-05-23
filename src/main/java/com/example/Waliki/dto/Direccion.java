package com.example.Waliki.dto;

public class Direccion {
    private Integer direccion_id;
    private String zona;
    private String calle;
    private Double Longitud;
    private Double Latitud;
    private String numero;

    public Integer getDireccion_id() {
        return direccion_id;
    }

    public void setDireccion_id(Integer direccion_id) {
        this.direccion_id = direccion_id;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Double getLongitud() {
        return Longitud;
    }

    public void setLongitud(Double longitud) {
        Longitud = longitud;
    }

    public Double getLatitud() {
        return Latitud;
    }

    public void setLatitud(Double latitud) {
        Latitud = latitud;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
