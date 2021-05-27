package com.example.Waliki.bl;


import com.example.Waliki.dao.ArtesanoDao;
import com.example.Waliki.dto.Artesano;
import com.example.Waliki.dto.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ArtesanoBl {

    @Autowired
    ArtesanoDao artesanoDao;

    public Artesano CrearArtesano(Artesano a)throws SQLException {
        a.setCodigo("");
        a.setContrato_id(1);
        return artesanoDao.CrearArtesano(a);
    }
}
