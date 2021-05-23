package com.example.Waliki.api;
import com.example.Waliki.bl.GestionDireccionBl;
import com.example.Waliki.dto.Direccion;
import com.example.Waliki.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.sql.SQLException;
import java.util.List;

@RestController
public class DireccionController {
    @Autowired
    private GestionDireccionBl gestionDireccionBl;

    @GetMapping(path= "/direccion")
    public ResponseDto SeleccionarTodasImagenes() throws SQLException {
        return new ResponseDto(true,gestionDireccionBl.SeleccionarTodasDirecciones(),"");
    }

    @GetMapping(path= "/direccion/{direccionId}")
    public ResponseDto SeleccionarImagen(@PathVariable Integer direccionId) throws SQLException {
        Direccion direccion= gestionDireccionBl.SeleccionarDireccion(direccionId);
        if(direccion==null){
            return new ResponseDto(false,null,null);
        }
            return new ResponseDto(true,direccion,"");
    }
    @PostMapping(path= "/direccion")
    public ResponseDto CrearImagen(@RequestBody Direccion direccion) throws SQLException {
        Direccion imagen2 = gestionDireccionBl.CrearDireccion(direccion);
        if(imagen2.getZona() ==null || imagen2.getZona().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(imagen2.getCalle() ==null || imagen2.getCalle().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(imagen2.getLatitud() ==null ){
            return new ResponseDto(false,null,null);
        }
        if(imagen2.getLongitud()==null){
            return new ResponseDto(false,null,null);
        }
        if(imagen2.getNumero() ==null || imagen2.getNumero().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        return new ResponseDto(true,imagen2,"");
    }

    @DeleteMapping(path= "/direccion/{direccionId}")
    public ResponseDto EliminarImagen(@PathVariable Integer direccionId) throws SQLException {
        Direccion direccion = gestionDireccionBl.EliminarDireccion(direccionId);
        if(direccion==null){
            return new ResponseDto(false,null,null);
        }
        return new ResponseDto(true,direccion,"");
    }
    @PutMapping(path= "/direccion")
    public ResponseDto ActualizarImagen(@RequestBody Direccion ob) throws SQLException {
        Direccion imagen2 = gestionDireccionBl.ActualizarDireccion(ob);
        if(imagen2.getZona() ==null || imagen2.getZona().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(imagen2.getCalle() ==null || imagen2.getCalle().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(imagen2.getLatitud() ==null ){
            return new ResponseDto(false,null,null);
        }
        if(imagen2.getLongitud()==null){
            return new ResponseDto(false,null,null);
        }
        if(imagen2.getNumero() ==null || imagen2.getNumero().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        return new ResponseDto(true,imagen2,"");

    }
}
