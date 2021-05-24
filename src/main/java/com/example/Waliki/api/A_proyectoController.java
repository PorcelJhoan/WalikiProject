package com.example.Waliki.api;


import com.example.Waliki.bl.GestionA_Proyecto;

import com.example.Waliki.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class A_proyectoController {

    @Autowired
    GestionA_Proyecto gestionA_proyecto;

/*
    @PostMapping ("/A_proyecto")
    public String Home(Busqueda_fecha fecha, Model model)throws SQLException {
        List<A_Proyecto> proyecto=gestionA_proyecto.SeleccionarProyectos(fecha);
        model.addAttribute("emp",proyecto);
        System.out.println(fecha.getFecha_inicio()+"------"+fecha.getFecha_fin());
        return "A_proyecto";
    }

    @GetMapping("/A_proyecto")
    public String emprendedor()throws SQLException {

        return "A_proyecto";
    }

*/
    @PostMapping(path= "/proyecto")
    public ResponseDto SeleccionarProyecto(@RequestBody Busqueda_fecha fecha) throws SQLException {

        return new ResponseDto( true,gestionA_proyecto.SeleccionarProyectos(fecha), null);
    }
}
