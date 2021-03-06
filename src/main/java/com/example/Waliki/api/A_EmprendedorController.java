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
    @GetMapping(path= "/emprendedor/{busqueda}")
    public ResponseDto SeleccionarTodosEmprendedores(@PathVariable String busqueda) throws SQLException {
        return new ResponseDto( true,gestionA_emprendedor.SeleccionarEmprendedores(busqueda), null);

    }

    @GetMapping(path="/emprendedor")
    public ResponseDto SeleccionarEmprendedores() throws SQLException{
        return new ResponseDto (true,gestionA_emprendedor.SeleccionarEmprendedores()," EMPRENDEDORES, VISTA ADMINISTRADOR");
    }

    @GetMapping(path="/A_Emprendedor/{personaId}/{direccionId}/{cuentaId}")
    public ResponseDto EditarEmprendedores(@PathVariable Integer personaId,@PathVariable Integer direccionId,@PathVariable Integer cuentaId,Model model) throws SQLException {
        List<A_Emprendedor> Emprendedores=gestionA_emprendedor.SeleccionarEmprendedor(personaId,cuentaId,direccionId);

        return new ResponseDto(true,Emprendedores,"");
    }
    @PutMapping(path="/A_Emprendedor")
    public ResponseDto ActualizarEmprendedor(@RequestBody A_Emprendedor ob) throws SQLException {
        A_Emprendedor A= gestionA_emprendedor.ActualizarEmprendedor(ob);
        if (A.getNombre() == null || A.getNombre().trim().equals("")) {
            return new ResponseDto( false, null, "El nombre de emprendedor debe ser obligatorio");
        }
        if (A.getCiudad() == null || A.getCiudad().trim().equals("")) {
            return new ResponseDto( false, null, "La ciudad debe ser obligatorio");
        }
        if (A.getCorreo() == null || A.getCorreo().trim().equals("")) {
            return new ResponseDto( false, null, "El correo  debe ser obligatorio");
        }
        if (A.getNumero_cuenta() == null || A.getNumero_cuenta().trim().equals("")) {
            return new ResponseDto( false, null, "El numero de cuenta debe ser obligatorio");
        }
        if (A.getNumero_identificacion() == null || A.getNumero_identificacion().trim().equals("")) {
            return new ResponseDto( false, null, "El numero de identificacion debe ser obligatorio");
        }
        if (A.getTelefono() == null || A.getTelefono().trim().equals("")) {
            return new ResponseDto( false, null, "El telefono debe ser obligatorio");
        }
        return new ResponseDto(true,A,"");
    }

}
