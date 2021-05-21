package com.example.Waliki.bl;


import com.example.Waliki.dao.A_ProyectoDao;
import com.example.Waliki.dto.A_Proyecto;
import com.example.Waliki.dto.Busqueda_fecha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class GestionA_Proyecto {
    @Autowired
    A_ProyectoDao a_emprendedorDao;

    public List<A_Proyecto> SeleccionarProyectos(Busqueda_fecha fecha) throws SQLException {
        return a_emprendedorDao.SeleccionarProyectos(fecha);
    }
/*
    public List<A_Proyecto> SeleccionarEmprendedor(int a, int b, int c) throws SQLException {
        return a_emprendedorDao.SeleccionarEmprendedor(a,b,c);
    }

    public A_Proyecto EliminarEmprendedor(Integer usuarioId) throws SQLException {

        return a_emprendedorDao.EliminarEmprendedor(usuarioId);
    }

    public A_Proyecto ActualizarEmprendedor(A_Proyecto ob) throws SQLException {

        return a_emprendedorDao.ActualizarEmprendedor(ob);
    }

 */
}
