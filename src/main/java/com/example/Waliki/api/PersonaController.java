
/*package com.example.Waliki.api;

import com.example.Waliki.bl.GestionPersonaBl;
import com.example.Waliki.dto.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.sql.*;
import java.util.*;

@Controller
public class PersonaController {

    @Autowired
    private GestionPersonaBl gestionPersonaBl;


    @GetMapping("/home")
    public String Home(Model model){
        model.addAttribute("nombre","nombre");
        return "index";
    }


    @GetMapping(path= "/persona")
    public List<Persona> SeleccionarTodasPersonas() throws SQLException {
        return gestionPersonaBl.SeleccionarTodasPersonas();
    }

    @GetMapping(path= "/persona/{PersonId}")
    public Persona SeleccionarPersona(@PathVariable Integer PersonId) throws SQLException {
        Persona persona = gestionPersonaBl.EliminarPersona(PersonId);
        if(persona.persona_id !=null){
            return gestionPersonaBl.EliminarPersona(PersonId);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe la persona con codigo"+PersonId);
        }
    }

    @PostMapping(path= "/persona")
    public Persona insert_person(@RequestBody Persona persona) throws SQLException {
        Persona persona2 = gestionPersonaBl.CrearPersona(persona);
        if(persona2.persona_id !=null){
            return gestionPersonaBl.CrearPersona(persona);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe la persona con codigo");
        }

    }

    @DeleteMapping(path= "/persona/{PersonId}")
    public Persona EliminarPersona(@PathVariable Integer PersonId) throws SQLException {
        Persona persona = gestionPersonaBl.EliminarPersona(PersonId);

        if(persona.persona_id !=null){
            return gestionPersonaBl.EliminarPersona(PersonId);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe la persona con codigo"+PersonId);
        }



    }
    @PutMapping(path= "/persona")
    public Persona ActualizarPersona(@RequestBody Persona ob) throws SQLException {
        return gestionPersonaBl.ActualizarPersona(ob);
    }
}
*/