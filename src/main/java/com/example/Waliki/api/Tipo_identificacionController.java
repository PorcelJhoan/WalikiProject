package com.example.Waliki.api;
import com.example.Waliki.bl.GestionTipo_IdentificacionBl;
import com.example.Waliki.dto.ResponseDto;
import com.example.Waliki.dto.Tipo_identificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.sql.SQLException;
import java.util.List;

@RestController
public class Tipo_identificacionController {
    @Autowired
    private GestionTipo_IdentificacionBl gestionTipo_identificacionBl;

    @GetMapping(path= "/Tipo_identificacion")
    public ResponseDto SeleccionarTiposIdentificacion() throws SQLException {
        return new ResponseDto(true,gestionTipo_identificacionBl.SeleccionarTipoIdentificaciones(),"");
    }

    @GetMapping(path= "/Tipo_identificacion/{Tipo_identificacionId}")
    public ResponseDto SeleccionarTipoIdentificacion(@PathVariable Integer Tipo_identificacionId) throws SQLException {
        Tipo_identificacion tipo_identificacion = gestionTipo_identificacionBl.SeleccionarTipoIdentificacion(Tipo_identificacionId);
        if(tipo_identificacion==null){
            return new ResponseDto(false,null,"no existe identificacion con ese ID");
        }
        return new ResponseDto(true,tipo_identificacion,null);
    }

    @PostMapping(path= "/Tipo_identificacion")
    public ResponseDto CrearTipoIdentificacion(@RequestBody Tipo_identificacion i) throws SQLException {
        Tipo_identificacion tipo_identificacion= gestionTipo_identificacionBl.CrearTipoIdentificacion(i);
        if(tipo_identificacion.getTipo_identificacion() ==null || tipo_identificacion.getTipo_identificacion().trim().equals("")){
            return new ResponseDto(false,null,"no existe identificacion con ese ID");
        }
        return new ResponseDto(true,tipo_identificacion,null);
    }

    @DeleteMapping(path= "/Tipo_identificacion/{Tipo_identificacionId}")
    public ResponseDto EliminarImagen(@PathVariable Integer imagenId) throws SQLException {
        Tipo_identificacion i = gestionTipo_identificacionBl.EliminarTipoIdentificacion(imagenId);

        if(i==null){
            return new ResponseDto(false,null,"no existe identificacion con ese ID");
        }else{
            return new ResponseDto(true,i,null);
        }
    }
    @PutMapping(path= "/Tipo_identificacion")
    public ResponseDto ActualizarImagen(@RequestBody Tipo_identificacion ob) throws SQLException {
        Tipo_identificacion tipo_identificacion = gestionTipo_identificacionBl.ActualizarTipoIdentificacion(ob);
        if(tipo_identificacion.getTipo_identificacion() ==null || tipo_identificacion.getTipo_identificacion().trim().equals("")){
            return new ResponseDto(false,null,"no existe identificacion con ese ID");
        }
        return new ResponseDto(true,tipo_identificacion,null);
    }

}
