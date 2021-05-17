package com.example.Waliki.bl;

import com.example.Waliki.dao.UsuarioDao;
import com.example.Waliki.dto.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.SQLException;
import java.util.List;

@Service
public class GestionUsuarioBl {

    @Autowired
    UsuarioDao usuarioDao;

    public Usuario CrearUsuario(Usuario usuario)throws SQLException {
        return usuarioDao.CrearUsuario(usuario);
    }
    public List<Usuario> SeleccionarTodosUsuarios() throws SQLException {
        return usuarioDao.SeleccionarTodosUsuarios();
    }
    public Usuario SeleccionarUsuario(Integer usuarioId) throws SQLException {

        return usuarioDao.SeleccionarUsuario(usuarioId);
    }
    public Usuario EliminarUsuario(Integer usuarioId) throws SQLException {

        return usuarioDao.EliminarUsuario(usuarioId);
    }

    public Usuario ActualizarUsuario(Usuario ob) throws SQLException {

        return usuarioDao.ActualizarUsuario(ob);
    }

}
