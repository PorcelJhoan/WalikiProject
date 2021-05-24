package com.example.Waliki.dao;

import com.example.Waliki.dto.A_Emprendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class A_EmprendedorDao {

    /**
     * Inicializamos datasource para la conexión a la base de datos
     **/

    @Autowired
    public DataSource dataSource;

    /**
     * La siguiente función se encargará  de seleccionar todos los emprendedores de la tabla "emprendedor",
     * el cual tiene como parametro buscar  y una vez realizada la busqueda, retornará un array de objetos "Emprendedor".
     **/

    public List<A_Emprendedor> SeleccionarEmprendedores(String busqueda) throws SQLException {
        List<A_Emprendedor> array=new ArrayList<>();

        try(Connection con=dataSource.getConnection();
        PreparedStatement pre=con.prepareStatement("select (select count(*)from proyecto where emprendedor_id=e.emprendedor_id) , p.emprendedor_id,pe.persona_id, pe.nombre,ti.tipo_identificacion,pe.numero_identificacion,pe.telefono,pe.correo_electronico,di.ciudad, i.nombre,cu.numero_cuenta ,pe.persona_id,di.direccion_id from proyecto p JOIN emprendedor e on e.emprendedor_id=p.emprendedor_id JOIN usuario u on u.usuario_id=e.usuario_id JOIN persona pe on pe.persona_id= u.persona_id JOIN imagen i on i.imagen_id = e.imagen_id JOIN tipo_identificacion ti on ti.tipo_identificacion_id=pe.tipo_identificacion_id JOIN direccion di on di.direccion_id=pe.direccion_id JOIN cuenta cu on cu.emprendedor_id=e.emprendedor_id where pe.nombre Ilike ? OR pe.numero_identificacion Ilike ?  OR ti.tipo_identificacion Ilike ? OR pe.telefono Ilike ? OR di.ciudad Ilike ? OR cu.numero_cuenta Ilike ? OR pe.correo_electronico Ilike ?");){
            pre.setString(1, "%"+busqueda+"%");
            pre.setString(2, "%"+busqueda+"%");
            pre.setString(3, "%"+busqueda+"%");
            pre.setString(4, "%"+busqueda+"%");
            pre.setString(5, "%"+busqueda+"%");
            pre.setString(6, "%"+busqueda+"%");
            pre.setString(7, "%"+busqueda+"%");
            ResultSet res= pre.executeQuery();
            while(res.next()){
                A_Emprendedor ob = new A_Emprendedor();
                ob.setNumero_proyectos(res.getInt("count"));
                ob.setEmprendedor_id(res.getInt("emprendedor_id"));
                ob.setNombre(res.getString("nombre"));
                ob.setTipo_identificacion(res.getString("tipo_identificacion"));
                ob.setNumero_identificacion(res.getString("numero_identificacion"));
                ob.setTelefono(res.getString("telefono"));
                ob.setCorreo(res.getString("correo_electronico"));
                ob.setCiudad(res.getString("ciudad"));
                ob.setNumero_cuenta(res.getString("numero_cuenta"));
                ob.setPersona_id(res.getInt("persona_id"));
                ob.setDireccion_id(res.getInt("direccion_id"));
                array.add(ob);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return array;
    }

    /**
     * La siguiente función se encargará  seleccionar un emprendedor de la tabla "emprendedor",
     * el cual tiene como parámetro un entero simulando ser el id del emprendedor, y una vez realizado la busqueda,
     * retornará un objeto Emprendedor.
     **/

    public List<A_Emprendedor> SeleccionarEmprendedor(int persona_id,int cuenta_id, int direccion_id ) throws SQLException {
        List<A_Emprendedor> array=new ArrayList<>();

        try(Connection con=dataSource.getConnection();
            PreparedStatement pre=con.prepareStatement("select (select count(*)from proyecto where emprendedor_id=e.emprendedor_id) , p.emprendedor_id,pe.persona_id, pe.nombre,ti.tipo_identificacion,pe.numero_identificacion,pe.telefono,pe.correo_electronico,di.ciudad, i.nombre,cu.numero_cuenta ,pe.persona_id,di.direccion_id from proyecto p JOIN emprendedor e on e.emprendedor_id=p.emprendedor_id JOIN usuario u on u.usuario_id=e.usuario_id JOIN persona pe on pe.persona_id= u.persona_id JOIN imagen i on i.imagen_id = e.imagen_id JOIN tipo_identificacion ti on ti.tipo_identificacion_id=pe.tipo_identificacion_id JOIN direccion di on di.direccion_id=pe.direccion_id JOIN cuenta cu on cu.emprendedor_id=e.emprendedor_id where e.emprendedor_id=? and pe.persona_id=? and di.direccion_id=?");){
            pre.setInt(2, persona_id);
            pre.setInt(1, cuenta_id);
            pre.setInt(3, direccion_id);
            A_Emprendedor ob = new A_Emprendedor();
            ResultSet res= pre.executeQuery();
            if(res.next()){
                ob.setNumero_proyectos(res.getInt("count"));
                ob.setEmprendedor_id(res.getInt("emprendedor_id"));
                ob.setNombre(res.getString("nombre"));
                ob.setTipo_identificacion(res.getString("tipo_identificacion"));
                ob.setNumero_identificacion(res.getString("numero_identificacion"));
                ob.setTelefono(res.getString("telefono"));
                ob.setCorreo(res.getString("correo_electronico"));
                ob.setCiudad(res.getString("ciudad"));
                ob.setNumero_cuenta(res.getString("numero_cuenta"));
                ob.setPersona_id(res.getInt("persona_id"));
                ob.setDireccion_id(res.getInt("direccion_id"));
                array.add(ob);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return array;
    }

    /**
     * La siguiente función se encargará  de seleccionar todos los emprendedores de la tabla "emprendedor",
     * el cual no tiene parámetros  y una vez realizada la busqueda, retornará un array de objetos "Emprendedor".
     **/

    public List<A_Emprendedor> SeleccionarEmprendedores() throws SQLException {
        List<A_Emprendedor> array=new ArrayList<>();

        try(Connection con=dataSource.getConnection();
            PreparedStatement pre=con.prepareStatement("select (select count(*)from proyecto where emprendedor_id=e.emprendedor_id) , p.emprendedor_id,pe.persona_id, pe.nombre,ti.tipo_identificacion,pe.numero_identificacion,pe.telefono,pe.correo_electronico,di.ciudad, i.nombre,cu.numero_cuenta ,pe.persona_id,di.direccion_id from proyecto p JOIN emprendedor e on e.emprendedor_id=p.emprendedor_id JOIN usuario u on u.usuario_id=e.usuario_id JOIN persona pe on pe.persona_id= u.persona_id JOIN imagen i on i.imagen_id = e.imagen_id JOIN tipo_identificacion ti on ti.tipo_identificacion_id=pe.tipo_identificacion_id JOIN direccion di on di.direccion_id=pe.direccion_id JOIN cuenta cu on cu.emprendedor_id=e.emprendedor_id ");){
            A_Emprendedor ob = new A_Emprendedor();
            ResultSet res= pre.executeQuery();
            while(res.next()){
                ob.setNumero_proyectos(res.getInt("count"));
                ob.setEmprendedor_id(res.getInt("emprendedor_id"));
                ob.setNombre(res.getString("nombre"));
                ob.setTipo_identificacion(res.getString("tipo_identificacion"));
                ob.setNumero_identificacion(res.getString("numero_identificacion"));
                ob.setTelefono(res.getString("telefono"));
                ob.setCorreo(res.getString("correo_electronico"));
                ob.setCiudad(res.getString("ciudad"));
                ob.setNumero_cuenta(res.getString("numero_cuenta"));
                ob.setPersona_id(res.getInt("persona_id"));
                ob.setDireccion_id(res.getInt("direccion_id"));
                array.add(ob);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return array;
    }

    /**
     * La siguiente función se encargará  actualizar un emprendedor de la tabla "emprendedor",
     * el cual tiene como parámetro un objeto "Emprendedor", y una vez realizado la actualizacion,
     * retornará un objeto Emprendedor.
     **/


    public A_Emprendedor ActualizarEmprendedor(A_Emprendedor ob) throws SQLException {
        Connection con=null;
        try{

            con=dataSource.getConnection();
            Statement stat =con.createStatement();
            PreparedStatement preesta;
            preesta = con.prepareStatement("UPDATE persona SET nombre=?,telefono=?,correo_electronico=?,numero_identificacion=? WHERE persona_id=?");
            preesta.setInt(5, ob.getPersona_id());
            preesta.setString(1, ob.getNombre());
            preesta.setString(2, ob.getTelefono());
            preesta.setString(3, ob.getCorreo());
            preesta.setString(4, ob.getNumero_identificacion());
            preesta.executeUpdate();


            PreparedStatement preesta1 = con.prepareStatement("UPDATE cuenta SET numero_cuenta=? WHERE emprendedor_id=?");
            preesta1.setInt(2, ob.getEmprendedor_id());
            preesta1.setString(1, ob.getNumero_cuenta());
            preesta1.executeUpdate();
            preesta1.close();

            PreparedStatement preesta2 = con.prepareStatement("UPDATE direccion SET ciudad=? WHERE direccion_id=?");
            preesta2.setInt(2, ob.getDireccion_id());
            preesta2.setString(1, ob.getCiudad());
            preesta2.executeUpdate();
            preesta2.close();

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
