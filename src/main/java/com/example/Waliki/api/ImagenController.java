package com.example.Waliki.api;
import com.example.Waliki.bl.GestionImagenBl;
import com.example.Waliki.dto.Imagen;
import com.example.Waliki.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.sql.SQLException;
import java.util.List;

@RestController
public class ImagenController {
    @Autowired
    private GestionImagenBl gestionImagenBl;

    @GetMapping(path= "/imagen")
    public ResponseDto SeleccionarTodasImagenes() throws SQLException {
        return new ResponseDto(true,gestionImagenBl.SeleccionarTodasImagenes(),"");
    }

    @GetMapping(path= "/imagen/{imagenId}")
    public ResponseDto SeleccionarImagen(@PathVariable Integer imagenId) throws SQLException {
        Imagen imagen = gestionImagenBl.SeleccionarImagen(imagenId);
        if(imagen ==null){
            return new ResponseDto(false,null,null);
        }
        return new ResponseDto(true,imagen,"");
    }

    @PostMapping(path= "/imagen")
    public ResponseDto CrearImagen(@RequestBody Imagen imagen) throws SQLException {
        Imagen imagen2 = gestionImagenBl.CrearImagen(imagen);
        if(imagen2.getSrc_imagen() ==null || imagen2.getSrc_imagen().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(imagen2.getNombre()==null || imagen2.getNombre().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        return new ResponseDto(true,imagen2,"");
    }

    @DeleteMapping(path= "/imagen/{imagenId}")
    public ResponseDto EliminarImagen(@PathVariable Integer imagenId) throws SQLException {
        Imagen imagen = gestionImagenBl.EliminarImagen(imagenId);
        if(imagen ==null){
            return new ResponseDto(false,null,null);
        }
        return new ResponseDto(true,imagen,"");
    }
    @PutMapping(path= "/imagen")
    public ResponseDto ActualizarImagen(@RequestBody Imagen ob) throws SQLException {
        Imagen imagen2 =gestionImagenBl.ActualizarImagen(ob);
        if(imagen2.getSrc_imagen() ==null || imagen2.getSrc_imagen().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(imagen2.getNombre()==null || imagen2.getNombre().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        return new ResponseDto(true,imagen2,"");
    }
}
