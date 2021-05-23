package com.example.Waliki.dao;
import com.example.Waliki.dto.Direccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DireccionDao {

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
     * La siguiente función se encargará  de almacenar una direccion en la tabla "direccion",
     * el cual tiene como parámetro el objeto "Direccion", y una vez realizado el almacenamiento,
     * retornará el ya mencionado objeto.
     **/

    public Direccion CrearDireccion(Direccion ob)throws SQLException {
        ob.setDireccion_id(sequenceDao.getLLaveprincipal("direccion"));
        Connection con=null;
        try{
            con=dataSource.getConnection();
            PreparedStatement preesta;
            preesta = con.prepareStatement("INSERT INTO direccion(direccion_id,zona,calle,Longitud,Latitud,numero)" + " VALUES (?,?,?,?,?,?)");
            preesta.setInt(1, ob.getDireccion_id());
            preesta.setString(2, ob.getZona());
            preesta.setString(3, ob.getCalle());
            preesta.setDouble(4, ob.getLongitud());
            preesta.setDouble(5, ob.getLatitud());
            preesta.setString(6, ob.getNumero());
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
     * La siguiente función se encargará  de seleccionar todas las direcciones de la tabla "direccion",
     * el cual no tiene parámetros  y una vez realizada la busqueda, retornará un array de objetos "Direccion".
     **/

    public List<Direccion> SeleccionarTodasDirecciones() throws SQLException {
        List<Direccion> array=new ArrayList<>();
        Connection con=null;
        try{
            con=dataSource.getConnection();
            Statement stat =con.createStatement();
            ResultSet res= stat.executeQuery("select direccion_id,zona,calle,Longitud,Latitud,numero from direccion ");
            while(res.next()){
                Direccion ob = new Direccion();
                ob.setDireccion_id(res.getInt("direccion_id"));
                ob.setZona(res.getString("zona"));
                ob.setCalle(res.getString("calle"));
                ob.setLongitud(res.getDouble("Longitud"));
                ob.setLatitud(res.getDouble("Latitud"));
                ob.setNumero(res.getString("numero"));
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
     * La siguiente función se encargará  seleccionar una direccion de la tabla "direccion",
     * el cual tiene como parámetro un entero simulando ser el id de la direccion, y una vez realizado la busqueda,
     * retornará un objeto Direccion.
     **/

    public Direccion SeleccionarDireccion(Integer direccionId) throws SQLException {
        Direccion ob=new Direccion();
        try(Connection con=dataSource.getConnection();
            PreparedStatement pre=con.prepareStatement("select direccion_id,zona,calle,Longitud,Latitud,numero from direccion WHERE direccion_id=?");)
        {
            pre.setInt(1, direccionId);
            ResultSet res=pre.executeQuery();
            if(res.next()){
                ob.setDireccion_id(res.getInt("direccion_id"));
                ob.setZona(res.getString("zona"));
                ob.setCalle(res.getString("calle"));
                ob.setLongitud(res.getDouble("Longitud"));
                ob.setLatitud(res.getDouble("Latitud"));
                ob.setNumero(res.getString("numero"));
            }else{
                ob=null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ob;
    }

    /**
     * La siguiente función se encargará  eliminar una direccion de la tabla "direccion",
     * el cual tiene como parámetro un entero simulando ser el id de la direccion, y una vez realizada la eliminación,
     * retornará un objeto Direccion.
     **/

    public Direccion EliminarDireccion(Integer direccionId) throws SQLException {
        Direccion ob=new Direccion();
        try(Connection con=dataSource.getConnection();
            PreparedStatement pre=con.prepareStatement("delete from direccion WHERE direccion_id=?");)
        {
            pre.setInt(1, direccionId);
            pre.executeQuery();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ob;
    }

    /**
     * La siguiente función se encargará  actualizar una direccion de la tabla "direccion",
     * el cual tiene como parámetro un objeto "Direccion", y una vez realizado la actualizacion,
     * retornará un objeto Direccion.
     **/

    public Direccion ActualizarDireccion(Direccion ob) throws SQLException {
        Connection con=null;
        try{
            con=dataSource.getConnection();
            Statement stat =con.createStatement();
            PreparedStatement preesta;
            preesta = con.prepareStatement("UPDATE direccion SET zona=?,calle=?,Longitud=?,Latitud=?,numero=? WHERE direccion_id=?");
            preesta.setInt(6, ob.getDireccion_id());
            preesta.setString(1, ob.getZona());
            preesta.setString(2, ob.getCalle());
            preesta.setDouble(3, ob.getLongitud());
            preesta.setDouble(4, ob.getLatitud());
            preesta.setString(5, ob.getNumero());
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
