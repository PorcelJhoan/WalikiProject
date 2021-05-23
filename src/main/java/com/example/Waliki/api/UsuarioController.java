package com.example.Waliki.api;
import com.example.Waliki.bl.GestionUsuarioBl;
import com.example.Waliki.dto.ResponseDto;
import com.example.Waliki.dto.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class UsuarioController {

    @Autowired
    private GestionUsuarioBl gestionUsuarioBl;

    @GetMapping(path= "/usuario")
    public ResponseDto SeleccionarTodosUsuarios() throws SQLException {
        return new ResponseDto( true,gestionUsuarioBl.SeleccionarTodosUsuarios(), null);

    }

    @GetMapping(path= "/usuario/{usuarioId}")
    public ResponseDto SeleccionarUsuario(@PathVariable Integer usuarioId) throws SQLException {
        Usuario usuario = gestionUsuarioBl.SeleccionarUsuario(usuarioId);
        if(usuario==null){
            return new ResponseDto( false, null, "No existe el usuario con codigo:"+usuarioId);
        }else{
            return new ResponseDto( true, usuario, null);
        }
    }

    @PostMapping(path= "/usuario")
    public ResponseDto CrearUsuario(@RequestBody Usuario usuario2) throws SQLException {
        Usuario usuario = gestionUsuarioBl.CrearUsuario(usuario2);

        if (usuario.getUsuario() == null || usuario.getUsuario().trim().equals("")) {
            return new ResponseDto( false, null, "El nombre de usuario debe ser obligatorio");
        }
        if (usuario.getContrasena() == null || usuario.getContrasena().trim().equals("")) {
            return new ResponseDto( false, null, "La contraseña debe ser obligatoria");
        }
        if (usuario.getFecha_registro() == null || usuario.getFecha_registro().trim().equals("")) {
            return new ResponseDto( false, null, "La fecha de registro debe ser obligatorio");
        }
        if (usuario.getCodigo_verificacion() == null || usuario.getCodigo_verificacion().trim().equals("")) {
            return new ResponseDto( false, null, "el codigo de verificacion debe ser obligatorio");
        }
        return new ResponseDto(true, usuario, null);
    }

    @DeleteMapping(path= "/usuario/{usuarioId}")
    public ResponseDto EliminarUsuario(@PathVariable Integer usuarioId) throws SQLException {
        Usuario usuario = gestionUsuarioBl.EliminarUsuario(usuarioId);
        if(usuario.getUsuario_id() !=null){
            return new ResponseDto(false, gestionUsuarioBl.EliminarUsuario(usuarioId), "");
        }else{
            return new ResponseDto( false, null, "No existe el usuario con codigo:"+usuarioId);
        }
    }

    @PutMapping(path= "/usuario")
    public ResponseDto ActualizarUsuario(@RequestBody Usuario ob) throws SQLException {
        Usuario usuario = gestionUsuarioBl.ActualizarUsuario(ob);
        if (usuario.getUsuario() == null || usuario.getUsuario().trim().equals("")) {
            return new ResponseDto( false, null, "El nombre de usuario debe ser obligatorio");
        }
        if (usuario.getContrasena() == null || usuario.getContrasena().trim().equals("")) {
            return new ResponseDto( false, null, "La contraseña debe ser obligatoria");
        }
        if (usuario.getFecha_registro() == null || usuario.getFecha_registro().trim().equals("")) {
            return new ResponseDto( false, null, "La fecha de registro debe ser obligatorio");
        }
        if (usuario.getCodigo_verificacion() == null || usuario.getCodigo_verificacion().trim().equals("")) {
            return new ResponseDto( false, null, "el codigo de verificacion debe ser obligatorio");
        }
        return new ResponseDto(true, usuario, null);
    }

}
