package com.example.Waliki.dao;
import com.example.Waliki.dto.Imagen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImagenDao {

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
     * La siguiente función se encargará  de almacenar una imagen en la tabla "imagen",
     * el cual tiene como parámetro el objeto "Imagen", y una vez realizado el almacenamiento,
     * retornará el ya mencionado objeto.
     **/

    public Imagen CrearImagen(Imagen ob)throws SQLException {
        ob.setImagen_id(sequenceDao.getLLaveprincipal("imagen"));
        Connection con=null;
        try{
            con=dataSource.getConnection();
            PreparedStatement preesta;
            preesta = con.prepareStatement("INSERT INTO imagen(imagen_id,src_imagen,nombre) VALUES (?,?,?)");
            preesta.setInt(1, ob.getImagen_id());
            preesta.setString(2, ob.getSrc_imagen());
            preesta.setString(3, ob.getNombre());
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
     * La siguiente función se encargará  de seleccionar todas las imagenes de la tabla "imagen",
     * el cual no tiene parámetros  y una vez realizada la busqueda, retornará un array de objetos "Imagen".
     **/

    public List<Imagen> SeleccionarTodasImagenes() throws SQLException {
        List<Imagen> array=new ArrayList<>();

        try(Connection con=dataSource.getConnection();
           PreparedStatement pre=con.prepareStatement("select imagen_id,src_imagen,nombre from imagen");)
        {
            ResultSet res=pre.executeQuery();
            while(res.next()){
                Imagen ob = new Imagen();
                ob.setImagen_id(res.getInt("imagen_id"));
                ob.setSrc_imagen(res.getString("src_imagen"));
                ob.setNombre(res.getString("nombre"));
                array.add(ob);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return array;
    }

    /**
     * La siguiente función se encargará  seleccionar una imagen de la tabla "imagen",
     * el cual tiene como parámetro un entero simulando ser el id de la imagen, y una vez realizado la busqueda,
     * retornará un objeto Imagen.
     **/

    public Imagen SeleccionarImagen(Integer imagenId) throws SQLException {

        Imagen ob = new Imagen();
        try (Connection con = dataSource.getConnection();
            PreparedStatement pre=con.prepareStatement("select imagen_id,src_imagen,nombre from imagen WHERE imagen_id=?");)
        {
            pre.setInt(1, imagenId);
            ResultSet res=pre.executeQuery();
            if(res.next()){
                ob.setImagen_id(res.getInt("imagen_id"));
                ob.setSrc_imagen(res.getString("src_imagen"));
                ob.setNombre(res.getString("nombre"));
            }else{
                ob=null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ob;
    }

    /**
     * La siguiente función se encargará  eliminar una imagen de la tabla "imagen",
     * el cual tiene como parámetro un entero simulando ser el id de la imagen, y una vez realizada la eliminación,
     * retornará un objeto Imagen.
     **/

    public Imagen EliminarImagen(Integer ImagenId) throws SQLException {
        Imagen ob=new Imagen();
        try(Connection con=dataSource.getConnection();
            PreparedStatement pre = con.prepareStatement("delete from imagen WHERE imagen_id=?"))
        {
            pre.setInt(1, ImagenId);
            ResultSet res=pre.executeQuery();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ob;
    }

    /**
     * La siguiente función se encargará  actualizar un imagen de la tabla "imagen",
     * el cual tiene como parámetro un objeto "Imagen", y una vez realizado la actualizacion,
     * retornará un objeto Imagen.
     **/

    public Imagen ActualizarImagen(Imagen ob) throws SQLException {
        Connection con=null;
        try{
            con=dataSource.getConnection();
            Statement stat =con.createStatement();
            PreparedStatement preesta;
            preesta = con.prepareStatement("UPDATE imagen SET src_imagen=?,nombre=? WHERE imagen_id=?");
            preesta.setInt(3, ob.getImagen_id());
            preesta.setString(1, ob.getSrc_imagen());
            preesta.setString(2, ob.getNombre());
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
