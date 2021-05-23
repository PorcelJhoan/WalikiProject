package com.example.Waliki.bl;
import com.example.Waliki.dao.EmprendedorDao;
import com.example.Waliki.dto.Emprendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.List;

@Service
public class GestionEmprendedorBl {
    @Autowired
    EmprendedorDao emprendedorDao;

    public Emprendedor CrearEmprendedor(Emprendedor usuario)throws SQLException {
        return emprendedorDao.CrearEmprendedor(usuario);
    }
    public List<Emprendedor> SeleccionarEmprendedores() throws SQLException {
        return emprendedorDao.SeleccionarEmprendedores();
    }
    public Emprendedor SeleccionarEmprendedor(Integer usuarioId) throws SQLException {

        return emprendedorDao.SeleccionarEmprendedor(usuarioId);
    }
    public Emprendedor EliminarEmprendedor(Integer usuarioId) throws SQLException {

        return emprendedorDao.EliminarEmprendedor(usuarioId);
    }

    public Emprendedor ActualizarEmprendedor(Emprendedor ob) throws SQLException {

        return emprendedorDao.ActualizarEmprendedor(ob);
    }
}
