package com.example.Waliki.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

@Service
public class SequenceDao {

    @Autowired
    public DataSource dataSource;

    public int getLLaveprincipal(String table){
        String nombreSecuencia=table.toLowerCase()+"_"+table.toLowerCase()+"_id_seq";
        int resultado=0;
        Connection con=null;
        try{
            con=dataSource.getConnection();
            Statement stat =con.createStatement();
            ResultSet res= stat.executeQuery("select nextval('"+nombreSecuencia+"')");
            if(res.next()){

               resultado=res.getInt(1);

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
        return resultado;
    }
}
