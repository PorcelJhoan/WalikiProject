package com.example.Waliki.api;


import com.example.Waliki.bl.GestionA_Emprendedor;
import com.example.Waliki.dto.A_Emprendedor;
import com.example.Waliki.dto.Busqueda;
import com.example.Waliki.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
public class A_EmprendedorController {

    @Autowired
    GestionA_Emprendedor gestionA_emprendedor;
/*
    @PostMapping ("/A_emprendedor")
    public String Home(Busqueda busqueda,Model model)throws SQLException {
        List<A_Emprendedor> Emprendedores=gestionA_emprendedor.SeleccionarEmprendedores(busqueda.getBusqueda());
        model.addAttribute("emp",Emprendedores);
        return "index";
    }
    @GetMapping("/A_emprendedor")
    public String PantallaEmprendedores() {
        return "index";
    }

    @GetMapping("/A_Emprendedor/{personaId}/{direccionId}/{cuentaId}")
    public String EditarEmprendedores(@PathVariable Integer personaId,@PathVariable Integer direccionId,@PathVariable Integer cuentaId,Model model) throws SQLException {
        List<A_Emprendedor> Emprendedores=gestionA_emprendedor.SeleccionarEmprendedor(personaId,cuentaId,direccionId);
        model.addAttribute("emp",Emprendedores);
        return "EditarEmprendedor";
    }

    @DeleteMapping(path= "/A_emprendedor/{emprendedorId}")
    public ResponseDto EliminarEmprendedor(@PathVariable Integer emprendedorId) throws SQLException {
        A_Emprendedor r = gestionA_emprendedor.EliminarEmprendedor(emprendedorId);

        if(r.getEmprendedor_id() !=null){
            return new ResponseDto(false, r, "");

        }else{
            return new ResponseDto( false, null, "id inexistente");
        }

    }
    @PostMapping("/A_Emprendedor")
    public String ActualizarEmprendedor(A_Emprendedor ob) throws SQLException {
        A_Emprendedor A= gestionA_emprendedor.ActualizarEmprendedor(ob);

        return "index";
    }
*/

    /*-----------------------------------------------------------------------*/
    @PostMapping(path= "/emprendedor")
    public ResponseDto SeleccionarTodosEmprendedores(@RequestBody Busqueda busqueda) throws SQLException {
        System.out.println("---------"+busqueda.getBusqueda());
        return new ResponseDto( true,gestionA_emprendedor.SeleccionarEmprendedores(busqueda.getBusqueda()), null);

    }


    @GetMapping(path="/emprendedor")
    public ResponseDto SeleccionarEmprendedores() throws SQLException{
        return new ResponseDto (true,gestionA_emprendedor.SeleccionarEmprendedores()," EMPRENDEDORES, VISTA ADMINISTRADOR");
    }
    @DeleteMapping(path= "/emprendedor/{usuarioId}")
    public ResponseDto EliminarUsuario(@PathVariable Integer usuarioId) throws SQLException {
        A_Emprendedor r = gestionA_emprendedor.EliminarEmprendedor(usuarioId);

        if(r.getEmprendedor_id() !=null){
            return new ResponseDto(false, gestionA_emprendedor.EliminarEmprendedor(usuarioId), "");

        }else{
            return new ResponseDto( false, null, "id inexistente");
        }
    }
    @PutMapping(path= "/emprendedor")
    public A_Emprendedor ActualizarUsuario(@RequestBody A_Emprendedor ob) throws SQLException {
        return gestionA_emprendedor.ActualizarEmprendedor(ob);
    }

}
