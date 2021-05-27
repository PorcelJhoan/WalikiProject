package com.example.Waliki.dao;

import com.example.Waliki.dto.Tipo_Artesania;
import com.example.Waliki.dto.Tipo_identificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class Tipo_ArtesaniaDao {

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

    public List<Tipo_Artesania> SeleccionarTiposArtesania() throws SQLException {
        List<Tipo_Artesania> array=new ArrayList<>();
        Connection con=null;
        try{
            con=dataSource.getConnection();
            Statement stat =con.createStatement();
            ResultSet res= stat.executeQuery("select tipo_emprendimiento_id,tipo_emprendimiento from tipo_emprendimiento ");
            while(res.next()){
                Tipo_Artesania ob = new Tipo_Artesania();
                ob.setTipo_artesania_id (res.getInt("tipo_emprendimiento_id"));
                ob.setTipo_artesania(res.getString("tipo_emprendimiento"));
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

}
