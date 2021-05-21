package com.example.Waliki.api;

import com.example.Waliki.bl.GestionUsuarioBl;
import com.example.Waliki.dto.ResponseDto;

import waliki.demo.dto.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;



import java.sql.SQLException;
import java.util.List;

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
        if(usuario.getUsuario_id() !=null){

            return new ResponseDto(false, gestionUsuarioBl.SeleccionarUsuario(usuarioId), "");
        }else{
            return new ResponseDto( false, null, "id inexistente");
        }
    }

    @PostMapping(path= "/usuario")
    public ResponseDto CrearUsuario(@RequestBody Usuario usuario) throws SQLException {
        Usuario usuario2 = gestionUsuarioBl.CrearUsuario(usuario);
        if(usuario2.getUsuario_id() !=null){
            return new ResponseDto(false, gestionUsuarioBl.CrearUsuario(usuario), "");

        }else{
            return new ResponseDto( false, null, "id inexistente");
        }

    }

    @DeleteMapping(path= "/usuario/{usuarioId}")
    public ResponseDto EliminarUsuario(@PathVariable Integer usuarioId) throws SQLException {
        Usuario usuario = gestionUsuarioBl.EliminarUsuario(usuarioId);

        if(usuario.getUsuario_id() !=null){
            return new ResponseDto(false, gestionUsuarioBl.EliminarUsuario(usuarioId), "");

        }else{
            return new ResponseDto( false, null, "id inexistente");
        }



    }
    @PutMapping(path= "/usuario")
    public Usuario ActualizarUsuario(@RequestBody Usuario ob) throws SQLException {
        return gestionUsuarioBl.ActualizarUsuario(ob);
    }

}
