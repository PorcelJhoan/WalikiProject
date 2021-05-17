package com.example.Waliki.api;

import com.example.Waliki.bl.GestionDireccionBl;
import com.example.Waliki.dto.Direccion;
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
    public List<Direccion> SeleccionarTodasImagenes() throws SQLException {
        return gestionDireccionBl.SeleccionarTodasDirecciones();
    }

    @GetMapping(path= "/direccion/{direccionId}")
    public Direccion SeleccionarImagen(@PathVariable Integer direccionId) throws SQLException {
        Direccion direccion= gestionDireccionBl.SeleccionarDireccion(direccionId);
        if(direccion.direccion_id !=null){
            return gestionDireccionBl.SeleccionarDireccion(direccionId);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe la persona con codigo");
        }
    }

    @PostMapping(path= "/direccion")
    public Direccion CrearImagen(@RequestBody Direccion direccion) throws SQLException {
        Direccion imagen2 = gestionDireccionBl.CrearDireccion(direccion);
        if(imagen2.direccion_id !=null){
            return gestionDireccionBl.CrearDireccion(direccion);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe la persona con codigo");
        }

    }

    @DeleteMapping(path= "/direccion/{direccionId}")
    public Direccion EliminarImagen(@PathVariable Integer direccionId) throws SQLException {
        Direccion direccion = gestionDireccionBl.EliminarDireccion(direccionId);

        if(direccion.direccion_id !=null){
            return gestionDireccionBl.EliminarDireccion(direccionId);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe la persona con codigo");
        }



    }
    @PutMapping(path= "/direccion")
    public Direccion ActualizarImagen(@RequestBody Direccion ob) throws SQLException {
        return gestionDireccionBl.ActualizarDireccion(ob);
    }
}
