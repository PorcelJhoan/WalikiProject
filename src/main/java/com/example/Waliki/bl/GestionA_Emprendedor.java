package com.example.Waliki.bl;

import com.example.Waliki.dao.A_EmprendedorDao;
import com.example.Waliki.dto.A_Emprendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class GestionA_Emprendedor {
    @Autowired
    A_EmprendedorDao a_emprendedorDao;

    public List<A_Emprendedor> SeleccionarEmprendedores(String busqueda) throws SQLException {
        return a_emprendedorDao.SeleccionarEmprendedores(busqueda);
    }

    public List<A_Emprendedor> SeleccionarEmprendedor(int a, int b, int c) throws SQLException {
        return a_emprendedorDao.SeleccionarEmprendedor(a,b,c);
    }

    public List<A_Emprendedor> SeleccionarEmprendedores() throws SQLException {
        return a_emprendedorDao.SeleccionarEmprendedores();
    }

    public A_Emprendedor EliminarEmprendedor(Integer usuarioId) throws SQLException {

        return a_emprendedorDao.EliminarEmprendedor(usuarioId);
    }

    public A_Emprendedor ActualizarEmprendedor(A_Emprendedor ob) throws SQLException {

        return a_emprendedorDao.ActualizarEmprendedor(ob);
    }
}
