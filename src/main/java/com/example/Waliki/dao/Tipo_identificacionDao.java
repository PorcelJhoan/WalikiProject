package com.example.Waliki.dao;
import com.example.Waliki.dto.Tipo_identificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class Tipo_identificacionDao {

    /**
     * Inicializamos sequenceDao para simular el "AUTO INCREMENT" de las llaves PRIMARIAS requeridas"
     **/

    @Autowired
    private SequenceDao sequenceDao;

    /**
     * Inicializamos datasource para la conexión a la base de datos
     **/

    @Autowired
    public DataSource dataSource;

    /**
     * La siguiente función se encargará  de almacenar un Tipo de identificacion en la tabla "tipo_identificacion",
     * el cual tiene como parámetro el objeto "Tipo_identificacion", y una vez realizado el almacenamiento,
     * retornará el ya mencionado objeto.
     **/

    public Tipo_identificacion CrearTipoIdentificacion(Tipo_identificacion ob)throws SQLException {
        ob.setTipo_identificacion_id(sequenceDao.getLLaveprincipal("tipo_identificacion"));
        Connection con=null;
        try{
            con=dataSource.getConnection();
            PreparedStatement preesta;
            preesta = con.prepareStatement("INSERT INTO tipo_identificacion(tipo_identificacion_id,tipo_identificacion) VALUES (?,?)");
            preesta.setInt(1, ob.getTipo_identificacion_id());
            preesta.setString(2, ob.getTipo_identificacion());
            preesta.executeUpdate();
            preesta.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException sqex) {}
            }
        }
        return ob;
    }

    /**
     * La siguiente función se encargará  de seleccionar todos LOS Tipos de identificacion existentes en la tabla "tipo_identificacion",
     * el cual no tiene parámetros  y una vez realizada la busqueda, retornará un array de objetos "Tipo_identificacion".
     **/

    public List<Tipo_identificacion> SeleccionarTiposIdentificacion() throws SQLException {
        List<Tipo_identificacion> array=new ArrayList<>();
        Connection con=null;
        try{
            con=dataSource.getConnection();
            Statement stat =con.createStatement();
            ResultSet res= stat.executeQuery("select tipo_identificacion_id,tipo_identificacion from tipo_identificacion ");
            while(res.next()){
                Tipo_identificacion ob = new Tipo_identificacion();
                ob.setTipo_identificacion_id(res.getInt("tipo_identificacion_id"));
                ob.setTipo_identificacion(res.getString("tipo_identificacion"));
                array.add(ob);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException sqex) {}
            }
        }
        return array;
    }

    /**
     * La siguiente función se encargará  seleccionar un Tipo de identificacion de la tabla "tipo_identificacion",
     * el cual tiene como parámetro un entero simulando ser el id del tipo de identificacion, y una vez realizada la busqueda,
     * retornará un objeto Tipo_identificacion.
     **/

    public Tipo_identificacion SeleccionarIdentificacion(Integer tipoidenId) throws SQLException {

        Tipo_identificacion ob=new Tipo_identificacion();
        try(Connection con=dataSource.getConnection();
            PreparedStatement pre=con.prepareStatement("select tipo_identificacion_id,tipo_identificacion from tipo_identificacion WHERE tipo_identificacion_id=?");)
        {
            pre.setInt(1, tipoidenId);
            ResultSet res=pre.executeQuery();
            if(res.next()){
                ob.setTipo_identificacion_id(res.getInt("tipo_identificacion_id"));
                ob.setTipo_identificacion(res.getString("tipo_identificacion"));
            }else{
                ob=null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ob;
    }

    /**
     * La siguiente función se encargará  eliminar un Tipo de identificacion de la tabla "tipo_identificacion",
     * el cual tiene como parámetro un entero simulando ser el id del tipo de identificacion , y una vez realizada la eliminación,
     * retornará un objeto Tipo_identificacion.
     **/

    public Tipo_identificacion EliminarTipoIdentificacion(Integer tipoidenId) throws SQLException {

        Tipo_identificacion ob=new Tipo_identificacion();
        try(Connection  con=dataSource.getConnection();
            PreparedStatement pre=con.prepareStatement("delete from tipo_identificacion WHERE tipo_identificacion_id=?");)
        {
            pre.setInt(1, tipoidenId);
            pre.executeQuery();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ob;
    }

    /**
     * La siguiente función se encargará  actualizar un usuario de la tabla "usuario",
     * el cual tiene como parámetro un objeto "Usuario", y una vez realizado la actualizacion,
     * retornará un objeto Usuario.
     **/

    public Tipo_identificacion ActualizarTipoIdentificacion(Tipo_identificacion ob) throws SQLException {
        Connection con=null;
        try{
            con=dataSource.getConnection();
            Statement stat =con.createStatement();
            PreparedStatement preesta;
            preesta = con.prepareStatement("UPDATE imagen SET tipo_identificacion=? WHERE tipo_identificacion_id=?");
            preesta.setInt(2, ob.getTipo_identificacion_id());
            preesta.setString(1, ob.getTipo_identificacion());
            preesta.executeUpdate();
            preesta.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException sqex) {}
            }
        }
        return ob;
    }
}
