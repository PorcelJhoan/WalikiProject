package com.example.Waliki.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waliki.demo.dto.Usuario;


import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioDao {

    @Autowired
    private SequenceDao sequenceDao;

    @Autowired
    public DataSource dataSource;

    public Usuario CrearUsuario(Usuario ob)throws SQLException {
        ob.setUsuario_id(sequenceDao.getLLaveprincipal("usuario"));
        Connection con=null;
        try{
            con=dataSource.getConnection();

            PreparedStatement preesta;
            preesta = con.prepareStatement("INSERT INTO usuario(usuario_id,tipo_usuario_id,usuario,contrasena,fecha_registro,codigo_verificacion,persona_id) VALUES (?,?,?,?,TO_DATE(?,'YYYYMMDD'),?,?)");
            preesta.setInt(1, ob.getUsuario_id());
            preesta.setInt(2, ob.getTipo_usuario_id());
            preesta.setString(3, ob.getUsuario());
            preesta.setString(4, ob.getContrasena());
            preesta.setString(5, ob.getFecha_registro());
            preesta.setString(6, ob.getCodigo_verificacion());
            preesta.setInt(7, ob.getPersona_id());

            preesta.executeUpdate();


        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException sqex) {
                    // No hacer nada intencionalemte;
                }
            }
        }
        return ob;
    }
    public List<Usuario> SeleccionarTodosUsuarios() throws SQLException {
        List<Usuario> array=new ArrayList<>();

        try (Connection con=dataSource.getConnection();
            Statement stat =con.createStatement();
            PreparedStatement pre= con.prepareStatement("select usuario_id,tipo_usuario_id,usuario,contrasena,fecha_registro,codigo_verificacion,persona_id from usuario ");)
        {
            ResultSet res=pre.executeQuery();
            while(res.next()){
                Usuario ob = new Usuario();
                ob.setUsuario_id(res.getInt("usuario_id"));
                ob.setUsuario(res.getString("usuario"));
                ob.setTipo_usuario_id(res.getInt("tipo_usuario_id"));
                ob.setContrasena(res.getString("contrasena"));
                ob.setFecha_registro(res.getString("fecha_registro"));
                ob.setCodigo_verificacion(res.getString("codigo_verificacion"));
                ob.setPersona_id(res.getInt("persona_id"));

                array.add(ob);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return array;
    }
    public Usuario SeleccionarUsuario(Integer usuarioId) throws SQLException {

        Usuario ob=new Usuario();

        try(Connection con=dataSource.getConnection();
            Statement stat =con.createStatement();
            PreparedStatement pre=con.prepareStatement("select usuario_id,tipo_usuario_id,usuario,contrasena,fecha_registro,codigo_verificacion,persona_id from usuario WHERE usuario_id=?");)
        { pre.setInt(1, usuarioId);
            pre.executeQuery();
            ResultSet res=pre.executeQuery();
            if(res.next()){
                ob.setUsuario_id(res.getInt("usuario_id"));
                ob.setUsuario(res.getString("usuario"));
                ob.setTipo_usuario_id(res.getInt("tipo_usuario_id"));
                ob.setContrasena(res.getString("contrasena"));
                ob.setFecha_registro(res.getString("fecha_registro"));
                ob.setCodigo_verificacion(res.getString("codigo_verificacion"));
                ob.setPersona_id(res.getInt("persona_id"));
            }else{
                ob=null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ob;
    }
    public Usuario EliminarUsuario(Integer usuarioId) throws SQLException {

        Usuario ob=new Usuario();
        Connection con=null;
        try{
            con=dataSource.getConnection();
            Statement stat =con.createStatement();
            stat.execute("delete from usuario WHERE usuario_id="+usuarioId);

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException sqex) {
                    // No hacer nada intencionalemte;
                }
            }
        }

        return ob;
    }

    public Usuario ActualizarUsuario(Usuario ob) throws SQLException {
        Connection con=null;
        try{
            con=dataSource.getConnection();
            Statement stat =con.createStatement();
            PreparedStatement preesta;
            preesta = con.prepareStatement("UPDATE usuario SET tipo_usuario_id=?,usuario=?,contrasena=?,fecha_registro=?,codigo_verificacion=?,persona_id=? WHERE usuario_id=?");
            preesta.setInt(7, ob.getUsuario_id());
            preesta.setInt(1, ob.getTipo_usuario_id());
            preesta.setString(2, ob.getUsuario());
            preesta.setString(3, ob.getContrasena());
            preesta.setString(1, ob.getFecha_registro());
            preesta.setString(5, ob.getCodigo_verificacion());
            preesta.setInt(6, ob.getPersona_id());

            preesta.executeUpdate();
            preesta.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException sqex) {
                    // No hacer nada intencionalemte;
                }
            }
        }

        return ob;
    }

}
