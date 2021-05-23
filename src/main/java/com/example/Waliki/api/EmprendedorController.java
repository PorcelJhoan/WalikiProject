package com.example.Waliki.api;
import com.example.Waliki.bl.GestionEmprendedorBl;
import com.example.Waliki.dto.Emprendedor;
import com.example.Waliki.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.sql.SQLException;
import java.util.List;

@RestController
public class EmprendedorController {
    @Autowired
    private GestionEmprendedorBl gestionEmprendedorBl;

    @GetMapping(path= "/Emprendedor")
    public ResponseDto SeleccionarTodasImagenes() throws SQLException {
        return new ResponseDto(true,gestionEmprendedorBl.SeleccionarEmprendedores(),"");
    }

    @GetMapping(path= "/Emprendedor/{EmprendedorId}")
    public ResponseDto SeleccionarImagen(@PathVariable Integer EmprendedorId) throws SQLException {
        Emprendedor imagen = gestionEmprendedorBl.SeleccionarEmprendedor(EmprendedorId);
        if(imagen==null){
            return new ResponseDto(false,null,null);
        }
        return new ResponseDto(true,imagen,"");
    }

    @PostMapping(path= "/Emprendedor")
    public ResponseDto CrearEmprendedor(@RequestBody Emprendedor imagen) throws SQLException {
        Emprendedor imagen2 = gestionEmprendedorBl.CrearEmprendedor(imagen);
        if(imagen2.getContrato_id() ==null ){
            return new ResponseDto(false,null,null);
        }
        if(imagen2.getImagen_id() ==null ){
            return new ResponseDto(false,null,null);
        }
        if(imagen2.getUsuario_id() ==null ){
            return new ResponseDto(false,null,null);
        }
        if(imagen2.getTipo_emprendimiento_id() ==null ){
            return new ResponseDto(false,null,null);
        }
        return  new ResponseDto(true,imagen2,"");

    }

    @DeleteMapping(path= "/Emprendedor/{EmprendedorId}")
    public ResponseDto EliminarEmprendedor(@PathVariable Integer EmprendedorId) throws SQLException {
        Emprendedor imagen = gestionEmprendedorBl.EliminarEmprendedor(EmprendedorId);

        if(imagen==null){
            return new ResponseDto(false,null,null);
        }
        return new ResponseDto(true,imagen,"");



    }
    @PutMapping(path= "/Emprendedor")
    public ResponseDto ActualizarEmprendedor(@RequestBody Emprendedor ob) throws SQLException {

        Emprendedor imagen2 =gestionEmprendedorBl.ActualizarEmprendedor(ob);
        if(imagen2.getContrato_id() ==null ){
            return new ResponseDto(false,null,null);
        }
        if(imagen2.getImagen_id() ==null ){
            return new ResponseDto(false,null,null);
        }
        if(imagen2.getUsuario_id() ==null ){
            return new ResponseDto(false,null,null);
        }
        if(imagen2.getTipo_emprendimiento_id() ==null ){
            return new ResponseDto(false,null,null);
        }
        return  new ResponseDto(true,imagen2,"");
    }



}
