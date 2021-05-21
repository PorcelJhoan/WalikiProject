package waliki.demo.dto;

public class Emprendedor {
    private Integer emprendedor_id;
    private Integer imagen_id;
    private Integer tipo_emprendimiento_id;
    private Integer contrato_id;
    private Integer usuario_id;

    public Integer getEmprendedor_id() {
        return emprendedor_id;
    }

    public void setEmprendedor_id(Integer emprendedor_id) {
        this.emprendedor_id = emprendedor_id;
    }

    public Integer getImagen_id() {
        return imagen_id;
    }

    public void setImagen_id(Integer imagen_id) {
        this.imagen_id = imagen_id;
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

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }
}
