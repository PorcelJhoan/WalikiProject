package com.example.Waliki.api;

import com.example.Waliki.bl.GestionTipo_IdentificacionBl;
import com.example.Waliki.bl.Tipo_ArtesaniaBl;
import com.example.Waliki.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
@RestController
public class Tipo_ArtesaniaController {

    @Autowired
    private Tipo_ArtesaniaBl tipo_artesaniaBl;

    @GetMapping(path= "/TipoArtesania")
    public ResponseDto SeleccionarTiposIdentificacion() throws SQLException {
        return new ResponseDto(true,tipo_artesaniaBl.SeleccionarArtesanias(),"");
    }
}
