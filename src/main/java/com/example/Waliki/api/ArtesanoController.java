package com.example.Waliki.api;

import com.example.Waliki.bl.ArtesanoBl;
import com.example.Waliki.dto.Artesano;
import com.example.Waliki.dto.Persona;
import com.example.Waliki.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class ArtesanoController {

    @Autowired
    ArtesanoBl artesanoBl;

    @PostMapping(path= "/artesano")
    public ResponseDto Crearpersona(@RequestBody Artesano p) throws SQLException {
        Artesano persona2 = artesanoBl.CrearArtesano(p);
        if(persona2.getNombre() ==null || persona2.getNombre().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(persona2.getApellido_casado() ==null || persona2.getApellido_casado().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(persona2.getApellido_materno() ==null || persona2.getApellido_materno().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(persona2.getApellido_paterno() ==null || persona2.getApellido_paterno().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(persona2.getCorreo_electronico() ==null || persona2.getCorreo_electronico().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(persona2.getFecha_nacimiento() ==null || persona2.getFecha_nacimiento().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(persona2.getTelefono() ==null || persona2.getTelefono().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if (persona2.getUsuario() == null || persona2.getUsuario().trim().equals("")) {
            return new ResponseDto( false, null, "El nombre de usuario debe ser obligatorio");
        }
        if (persona2.getContrasena() == null || persona2.getContrasena().trim().equals("")) {
            return new ResponseDto( false, null, "La contraseña debe ser obligatoria");
        }
        return new ResponseDto(true,persona2,"");
    }
}
