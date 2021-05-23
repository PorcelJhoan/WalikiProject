package com.example.Waliki.api;
import com.example.Waliki.bl.GestionPersonaBl;
import com.example.Waliki.dto.Persona;
import com.example.Waliki.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.sql.*;
import java.util.*;

@RestController
public class PersonaController {

    @Autowired
    private GestionPersonaBl gestionPersonaBl;



    @GetMapping(path= "/persona")
    public ResponseDto SeleccionarTodasPersonas() throws SQLException {
        return new ResponseDto(true,gestionPersonaBl.SeleccionarTodasPersonas(),"");
    }

    @GetMapping(path= "/persona/{PersonId}")
    public ResponseDto SeleccionarPersona(@PathVariable Integer PersonId) throws SQLException {
        Persona persona = gestionPersonaBl.EliminarPersona(PersonId);
        if(persona==null){
            return new ResponseDto(false,null,null);
        }
        return new ResponseDto(true,persona,null);

    }

    @PostMapping(path= "/persona")
    public ResponseDto Crearpersona(@RequestBody Persona persona) throws SQLException {
        Persona persona2 = gestionPersonaBl.CrearPersona(persona);
        if(persona2.getNombre() !=null || persona2.getNombre().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(persona2.getApellido_casado() !=null || persona2.getApellido_casado().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(persona2.getApellido_materno() !=null || persona2.getApellido_materno().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(persona2.getApellido_paterno() !=null || persona2.getApellido_paterno().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(persona2.getCorreo_electronico() !=null || persona2.getCorreo_electronico().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(persona2.getFecha_nacimiento() !=null || persona2.getFecha_nacimiento().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(persona2.getNumero_identificacion() !=null || persona2.getNumero_identificacion().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(persona2.getTelefono() !=null || persona2.getTelefono().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        return new ResponseDto(true,persona2,"");
    }

    @DeleteMapping(path= "/persona/{PersonId}")
    public ResponseDto EliminarPersona(@PathVariable Integer PersonId) throws SQLException {
        Persona persona = gestionPersonaBl.EliminarPersona(PersonId);
        if(persona==null){
            return new ResponseDto(false,null,null);
        }
        return new ResponseDto(true,persona,null);



    }
    @PutMapping(path= "/persona")
    public ResponseDto ActualizarPersona(@RequestBody Persona ob) throws SQLException {
        Persona persona2 = gestionPersonaBl.ActualizarPersona(ob);
        if(persona2.getNombre() !=null || persona2.getNombre().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(persona2.getApellido_casado() !=null || persona2.getApellido_casado().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(persona2.getApellido_materno() !=null || persona2.getApellido_materno().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(persona2.getApellido_paterno() !=null || persona2.getApellido_paterno().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(persona2.getCorreo_electronico() !=null || persona2.getCorreo_electronico().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(persona2.getFecha_nacimiento() !=null || persona2.getFecha_nacimiento().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(persona2.getNumero_identificacion() !=null || persona2.getNumero_identificacion().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(persona2.getTelefono() !=null || persona2.getTelefono().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        return new ResponseDto(true,persona2,"");

    }
}
