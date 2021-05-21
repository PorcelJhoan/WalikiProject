/*
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
    @Autowired
    private SequenceDao sequenceDao;

    @Autowired
    public DataSource dataSource;

    public Tipo_identificacion CrearTipoIdentificacion(Tipo_identificacion ob)throws SQLException {
        ob.tipo_identificacion_id=sequenceDao.getLLaveprincipal("tipo_identificacion");
        Connection con=null;
        try{
            con=dataSource.getConnection();
            PreparedStatement preesta;
            preesta = con.prepareStatement("INSERT INTO tipo_identificacion(tipo_identificacion_id,tipo_identificacion)" + " VALUES (?,?)");
            preesta.setInt(1, ob.tipo_identificacion_id);
            preesta.setString(2, ob.tipo_identificacion);

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
    public List<Tipo_identificacion> SeleccionarTiposIdentificacion() throws SQLException {
        List<Tipo_identificacion> array=new ArrayList<>();
        Connection con=null;
        try{
            con=dataSource.getConnection();
            Statement stat =con.createStatement();
            ResultSet res= stat.executeQuery("select tipo_identificacion_id,tipo_identificacion from tipo_identificacion ");
            while(res.next()){
                Tipo_identificacion ob = new Tipo_identificacion();
                ob.tipo_identificacion_id=res.getInt("tipo_identificacion_id");
                ob.tipo_identificacion=res.getString("tipo_identificacion");

                array.add(ob);
            }
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

        return array;
    }
    public Tipo_identificacion SeleccionarIdentificacion(Integer tipoidenId) throws SQLException {
        Connection con=null;
        Tipo_identificacion ob=new Tipo_identificacion();
        try{
            con=dataSource.getConnection();
            Statement stat =con.createStatement();
            ResultSet res= stat.executeQuery("select tipo_identificacion_id,tipo_identificacion from tipo_identificacion WHERE tipo_identificacion_id="+tipoidenId);
            if(res.next()){
                ob.tipo_identificacion_id=res.getInt("tipo_identificacion_id");
                ob.tipo_identificacion=res.getString("tipo_identificacion");
            }else{
                ob=null;
            }
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
    public Tipo_identificacion EliminarTipoIdentificacion(Integer tipoidenId) throws SQLException {
        Connection con=null;
        Tipo_identificacion ob=new Tipo_identificacion();
        try{
            con=dataSource.getConnection();
            Statement stat =con.createStatement();
            stat.execute("delete from tipo_identificacion WHERE tipo_identificacion_id="+tipoidenId);

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

    public Tipo_identificacion ActualizarTipoIdentificacion(Tipo_identificacion ob) throws SQLException {
        Connection con=null;
        try{
            con=dataSource.getConnection();
            Statement stat =con.createStatement();
            PreparedStatement preesta;
            preesta = con.prepareStatement("UPDATE imagen SET tipo_identificacion=? WHERE tipo_identificacion_id=?");
            preesta.setInt(2, ob.tipo_identificacion_id);
            preesta.setString(1, ob.tipo_identificacion);

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
*/