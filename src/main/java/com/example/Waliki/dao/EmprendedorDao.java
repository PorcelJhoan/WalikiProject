package com.example.Waliki.dao;
import com.example.Waliki.dto.Emprendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmprendedorDao {

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
     * La siguiente función se encargará  de almacenar un emprendedor en la tabla "emprendedor",
     * el cual tiene como parámetro el objeto "Emprendimiento", y una vez realizado el almacenamiento,
     * retornará el ya mencionado objeto.
     **/

    public Emprendedor CrearEmprendedor(Emprendedor ob)throws SQLException {
        ob.setEmprendedor_id(sequenceDao.getLLaveprincipal("emprendedor"));
        Connection con=null;
        try{
            con=dataSource.getConnection();
            PreparedStatement preesta;
            preesta = con.prepareStatement("INSERT INTO emprendedor(emprendedor_id,imagen_id,tipo_emprendimiento_id,contrato_id,usuario_id)" + " VALUES (?,?,?,?,?)");
            preesta.setInt(1, ob.getEmprendedor_id());
            preesta.setInt(2, ob.getImagen_id());
            preesta.setInt(3, ob.getTipo_emprendimiento_id());
            preesta.setInt(4, ob.getContrato_id());
            preesta.setInt(5, ob.getUsuario_id());
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
     * La siguiente función se encargará  de seleccionar todos los emprendedores de la tabla "emprendedor",
     * el cual no tiene parámetros  y una vez realizada la busqueda, retornará un array de objetos "Emprendedor".
     **/

    public List<Emprendedor> SeleccionarEmprendedores() throws SQLException {
        List<Emprendedor> array=new ArrayList<>();
        Connection con=null;
        try{
            con=dataSource.getConnection();
            Statement stat =con.createStatement();
            ResultSet res= stat.executeQuery("select emprendedor_id,imagen_id,tipo_emprendimiento_id,contrato_id,usuario_id from emprendedor ");
            while(res.next()){
                Emprendedor ob = new Emprendedor();
                ob.setEmprendedor_id(res.getInt("emprendedor_id"));
                ob.setImagen_id(res.getInt("imagen_id"));
                ob.setTipo_emprendimiento_id(res.getInt("tipo_emprendimiento_id"));
                ob.setContrato_id(res.getInt("contrato_id"));
                ob.setUsuario_id(res.getInt("usuario_id"));
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
     * La siguiente función se encargará  seleccionar un emprendedor de la tabla "emprendedor",
     * el cual tiene como parámetro un entero simulando ser el id del emprendedor, y una vez realizado la busqueda,
     * retornará un objeto Emprendedor.
     **/

    public Emprendedor SeleccionarEmprendedor(Integer usuarioId) throws SQLException {

        Emprendedor ob=new Emprendedor();
        try(Connection con=dataSource.getConnection();
            PreparedStatement pre= con.prepareStatement("select emprendedor_id,imagen_id,tipo_emprendimiento_id,contrato_id,usuario_id from emprendedor WHERE emprendedor_id=?");)
        {
            pre.setInt(1, usuarioId);
            ResultSet res=pre.executeQuery();
            if(res.next()){
                ob.setEmprendedor_id(res.getInt("emprendedor_id"));
                ob.setImagen_id(res.getInt("imagen_id"));
                ob.setTipo_emprendimiento_id(res.getInt("tipo_emprendimiento_id"));
                ob.setContrato_id(res.getInt("contrato_id"));
                ob.setUsuario_id(res.getInt("usuario_id"));
            }else{
                ob=null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ob;
    }

    /**
     * La siguiente función se encargará  eliminar un emprendedor de la tabla "emprendedor",
     * el cual tiene como parámetro un entero simulando ser el id del emprendedor, y una vez realizada la eliminación,
     * retornará un objeto Emprendedor.
     **/

    public Emprendedor EliminarEmprendedor(Integer emprendedorId) throws SQLException {

        Emprendedor ob=new Emprendedor();
        try(Connection con=dataSource.getConnection();
            PreparedStatement pre=con.prepareStatement("delete from emprendedor WHERE emprendedor_id=?");)
        {
            pre.setInt(1, emprendedorId);
            pre.executeQuery();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ob;
    }

    /**
     * La siguiente función se encargará  actualizar un emprendedor de la tabla "emprendedor",
     * el cual tiene como parámetro un objeto "Emprendedor", y una vez realizado la actualizacion,
     * retornará un objeto Emprendedor.
     **/

    public Emprendedor ActualizarEmprendedor(Emprendedor ob) throws SQLException {
        Connection con=null;
        try{
            con=dataSource.getConnection();
            Statement stat =con.createStatement();
            PreparedStatement preesta;
            preesta = con.prepareStatement("UPDATE emprendedor SET emprendedor_id=?,imagen_id=?,tipo_emprendimiento_id=?,contrato_id=?,usuario_id=? WHERE usuario_id=?");
            preesta.setInt(5, ob.getEmprendedor_id());
            preesta.setInt(1, ob.getImagen_id());
            preesta.setInt(2, ob.getTipo_emprendimiento_id());
            preesta.setInt(3, ob.getContrato_id());
            preesta.setInt(4, ob.getUsuario_id());
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
