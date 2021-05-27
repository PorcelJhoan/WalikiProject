package com.example.Waliki.bl;

import com.example.Waliki.dao.Tipo_ArtesaniaDao;
import com.example.Waliki.dto.Tipo_Artesania;
import com.example.Waliki.dto.Tipo_identificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class Tipo_ArtesaniaBl {
    @Autowired
    Tipo_ArtesaniaDao tipoArtesaniaDao;

    public List<Tipo_Artesania> SeleccionarArtesanias() throws SQLException {
        return tipoArtesaniaDao.SeleccionarTiposArtesania();
    }
}
