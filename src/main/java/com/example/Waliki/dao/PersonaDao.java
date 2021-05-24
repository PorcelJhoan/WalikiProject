package com.example.Waliki.dao;
import com.example.Waliki.dto.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaDao {

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
     * La siguiente función se encargará  de almacenar un persona en la tabla "persona",
     * el cual tiene como parámetro el objeto "Persona", y una vez realizado el almacenamiento,
     * retornará el ya mencionado objeto.
     **/

    public Persona CrearPersona(Persona ob)throws SQLException{
        ob.setPersona_id(sequenceDao.getLLaveprincipal("persona"));
        Connection con=null;
        try{
            con=dataSource.getConnection();
            PreparedStatement preesta;
            preesta = con.prepareStatement("INSERT INTO persona(persona_id, nombre, apellido_paterno, apellido_materno, apellido_casado, telefono, fecha_nacimiento, direccion_id, correo_electronico,tipo_identificacion_id,numero_identificacion) VALUES (?,?,?,?,?,?,TO_DATE(?,'YYYYMMDD'),?,?,?,?)");
            preesta.setInt(1, ob.getPersona_id());
            preesta.setString(2, ob.getNombre());
            preesta.setString(3, ob.getApellido_paterno());
            preesta.setString(4, ob.getApellido_materno());
            preesta.setString(5, ob.getApellido_casado());
            preesta.setString(6, ob.getTelefono());
            preesta.setString(7, ob.getFecha_nacimiento());
            preesta.setInt(8, ob.getDireccion_id());
            preesta.setString(9, ob.getCorreo_electronico());
            preesta.setInt(10, ob.getTipo_identificacion_id());
            preesta.setString(11, ob.getNumero_identificacion());
            preesta.executeUpdate();
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
     * La siguiente función se encargará  de seleccionar todas las personas de la tabla "persona",
     * el cual no tiene parámetros  y una vez realizada la busqueda, retornará un array de objetos "Persona".
     **/

    public List<Persona> SeleccionarTodasPersonas() throws SQLException {
        List<Persona> array=new ArrayList<>();
        Connection con=null;
        try{
            con=dataSource.getConnection();
            Statement stat =con.createStatement();
            ResultSet res= stat.executeQuery("select persona_id, nombre, apellido_paterno, apellido_materno, apellido_casado, telefono, fecha_nacimiento, direccion_id, correo_electronico ,tipo_identificacion_id ,numero_identificacion , direccion_id from persona ");
            while(res.next()){
                Persona ob=new Persona();
                ob.setPersona_id(res.getInt("persona_id"));
                ob.setNombre(res.getString("nombre"));
                ob.setFecha_nacimiento(res.getString("fecha_nacimiento"));
                ob.setTipo_identificacion_id(res.getInt("tipo_identificacion_id"));
                ob.setApellido_paterno(res.getString("apellido_paterno"));
                ob.setApellido_materno(res.getString("apellido_materno"));
                ob.setApellido_casado(res.getString("apellido_casado"));
                ob.setDireccion_id(res.getInt("direccion_id"));
                ob.setTelefono(res.getString("telefono"));
                ob.setCorreo_electronico(res.getString("correo_electronico"));
                ob.setNumero_identificacion(res.getString("numero_identificacion"));
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
     * La siguiente función se encargará  seleccionar una persona de la tabla "persona",
     * el cual tiene como parámetro un entero simulando ser el id de persona, y una vez realizado la busqueda,
     * retornará un objeto Persona.
     **/

    public Persona SeleccionarPersona(Integer PersonId) throws SQLException {

        Persona ob=new Persona();
        try(Connection  con=dataSource.getConnection();
            PreparedStatement pre=con.prepareStatement("select persona_id, nombre, apellido_paterno, apellido_materno, apellido_casado, telefono, fecha_nacimiento, direccion_id, correo_electronico ,tipo_identificacion_id ,numero_identificacion , direccion_id from persona WHERE persona_id=?");)
        {
            pre.setInt(1, PersonId);
            ResultSet res=pre.executeQuery();
            if(res.next()){
                ob.setPersona_id(res.getInt("persona_id"));
                ob.setNombre(res.getString("nombre"));
                ob.setFecha_nacimiento(res.getString("fecha_nacimiento"));
                ob.setTipo_identificacion_id(res.getInt("tipo_identificacion_id"));
                ob.setApellido_paterno(res.getString("apellido_paterno"));
                ob.setApellido_materno(res.getString("apellido_materno"));
                ob.setApellido_casado(res.getString("apellido_casado"));
                ob.setDireccion_id(res.getInt("direccion_id"));
                ob.setTelefono(res.getString("telefono"));
                ob.setCorreo_electronico(res.getString("correo_electronico"));
                ob.setNumero_identificacion(res.getString("numero_identificacion"));
            }else{
                ob=null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ob;
    }

    /**
     * La siguiente función se encargará  eliminar una Persona de la tabla "persona",
     * el cual tiene como parámetro un entero simulando ser el id de la persona, y una vez realizada la eliminación,
     * retornará un objeto Persona.
     **/

    public Persona EliminarPersona(Integer PersonId) throws SQLException {
        Persona ob=new Persona();
        try(Connection  con=dataSource.getConnection();
            PreparedStatement pre=con.prepareStatement("delete from persona WHERE persona_id=?"); )
        {
            pre.setInt(1, PersonId);
            pre.executeQuery();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ob;
    }

    /**
     * La siguiente función se encargará  actualizar una persona de la tabla "persona",
     * el cual tiene como parámetro un objeto "Persona", y una vez realizado la actualizacion,
     * retornará un objeto Persona.
     **/

    public Persona ActualizarPersona(Persona ob) throws SQLException {
        Connection con=null;
        try{
            con=dataSource.getConnection();
            Statement stat =con.createStatement();
            PreparedStatement preesta;
            preesta = con.prepareStatement("UPDATE persona SET nombre =?, apellido_paterno=?, apellido_materno=?, apellido_casado=?, telefono=?, direccion_id=?, correo_electronico=? WHERE persona_id=?");
            preesta.setInt(8, ob.getPersona_id());
            preesta.setString(1, ob.getNombre());
            preesta.setString(2, ob.getApellido_paterno());
            preesta.setString(3, ob.getApellido_materno());
            preesta.setString(4, ob.getApellido_casado());
            preesta.setString(5, ob.getTelefono());
            preesta.setInt(6, ob.getDireccion_id());
            preesta.setString(7, ob.getCorreo_electronico());
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
