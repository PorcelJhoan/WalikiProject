package com.example.Waliki.dao;

import com.example.Waliki.dto.Artesano;
import com.example.Waliki.dto.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Service
public class ArtesanoDao {
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

    public Artesano CrearArtesano(Artesano ob)throws SQLException {
        ob.setPersona_id(sequenceDao.getLLaveprincipal("persona"));
        ob.setUsuario_id(sequenceDao.getLLaveprincipal("usuario"));
        ob.setEmprendedor_id(sequenceDao.getLLaveprincipal("emprendedor"));
        Connection con=null;
        Calendar fecha = new GregorianCalendar();

        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH)+1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        String fecha_actual=año+"-0"+mes+"-"+dia;

        try{
            con=dataSource.getConnection();
            PreparedStatement preesta;
            preesta = con.prepareStatement("INSERT INTO persona(persona_id, nombre, apellido_paterno, apellido_materno, apellido_casado, telefono, fecha_nacimiento, correo_electronico,direccion_id,tipo_identificacion_id,numero_identificacion) VALUES (?,?,?,?,?,?,TO_DATE(?,'YYYYMMDD'),?,?,?,?)");
            preesta.setInt(1, ob.getPersona_id());
            preesta.setString(2, ob.getNombre());
            preesta.setString(3, ob.getApellido_paterno());
            preesta.setString(4, ob.getApellido_materno());
            preesta.setString(5, ob.getApellido_casado());
            preesta.setString(6, ob.getTelefono());
            preesta.setString(7, ob.getFecha_nacimiento());
            preesta.setString(8, ob.getCorreo_electronico());
            preesta.setInt(9,1);
            preesta.setInt(10,ob.getTipo_identificacion_id());
            preesta.setString(11,ob.getIdentificacion());
            preesta.executeUpdate();
            PreparedStatement preesta1;
            preesta1 = con.prepareStatement("INSERT INTO usuario(usuario_id,tipo_usuario_id,usuario,contrasena,fecha_registro,persona_id,codigo_verificacion) VALUES (?,?,?,?,TO_DATE(?,'YYYYMMDD'),?,?)");
            preesta1.setInt(1, ob.getUsuario_id());
            preesta1.setInt(2,2);
            preesta1.setString(3, ob.getUsuario());
            preesta1.setString(4, ob.getContrasena());
            preesta1.setString(5, fecha_actual);
            preesta1.setInt(6, ob.getPersona_id());
            preesta1.setString(7, ob.getCodigo());
            preesta1.executeUpdate();

            PreparedStatement preesta2;
            preesta2 = con.prepareStatement("INSERT INTO emprendedor(emprendedor_id,tipo_emprendimiento_id,contrato_id,usuario_id,imagen_id)" + " VALUES (?,?,?,?,?)");
            preesta2.setInt(1, ob.getEmprendedor_id());
            preesta2.setInt(2, ob.getTipo_emprendimiento_id());
            preesta2.setInt(3, ob.getContrato_id());
            preesta2.setInt(4, ob.getUsuario_id());
            preesta2.setInt(5, 5);
            preesta2.executeUpdate();

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
