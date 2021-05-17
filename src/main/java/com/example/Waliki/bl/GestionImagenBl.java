package com.example.Waliki.bl;

import com.example.Waliki.dao.ImagenDao;
import com.example.Waliki.dto.Imagen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.sql.SQLException;
import java.util.List;

@Service
public class GestionImagenBl {
    @Autowired
    ImagenDao imagenDao;

    public Imagen CrearImagen(Imagen imagen)throws SQLException {
        return imagenDao.CrearImagen(imagen);
    }
    public List<Imagen> SeleccionarTodasImagenes() throws SQLException {
        return imagenDao.SeleccionarTodasImagenes();
    }
    public Imagen SeleccionarImagen(Integer imagenId) throws SQLException {

        return imagenDao.SeleccionarImagen(imagenId);
    }
    public Imagen EliminarImagen(Integer imagenId) throws SQLException {

        return imagenDao.EliminarImagen(imagenId);
    }

    public Imagen ActualizarImagen(Imagen ob) throws SQLException {

        return imagenDao.ActualizarImagen(ob);
    }
}
