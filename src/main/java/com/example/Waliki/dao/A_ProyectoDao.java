package com.example.Waliki.dao;
import com.example.Waliki.dto.A_Proyecto;
import com.example.Waliki.dto.Busqueda_fecha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class A_ProyectoDao {
    String fecha_actual="";

    /**
     * Inicializamos datasource para la conexión a la base de datos
     **/

    @Autowired
    private DataSource dataSource;

    /**
     * La siguiente función se encargará  de seleccionar todos los proyectos de la tabla "proyecto",
     * el cual tiene como parametros un intervalo de fechas y una vez realizada la busqueda, retornará un array de objetos "Emprendedor".
     **/


    public List<A_Proyecto> SeleccionarProyectos(Busqueda_fecha busqueda) throws SQLException {
        List<A_Proyecto> array=new ArrayList<>();

        Calendar fecha = new GregorianCalendar();

        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH)+1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        fecha_actual=año+"-"+mes+"-"+dia;

        try(Connection con=dataSource.getConnection();
            PreparedStatement pre=con.prepareStatement("select p.proyecto_id,p.nombre,p2.nombre as nombrep,p.fecha_inicio,p.fecha_fin,p.descripcion,p.monto_recaudar,(select sum(d.monto) from donacion d where d.proyecto_id = p.proyecto_id group by d.donacion_id),p2.persona_id from proyecto p JOIN donacion d on p.proyecto_id=d.proyecto_id JOIN donador d2 on d.donador_id = d2.donador_id JOIN emprendedor e on p.emprendedor_id = e.emprendedor_id JOIN usuario u on e.usuario_id = u.usuario_id JOIN persona p2 on u.persona_id = p2.persona_id where p.fecha_inicio between date(?) and date(?) OR p.fecha_fin between date(?) and date(?)")){

            pre.setString(1, busqueda.getFecha_inicio());
            pre.setString(2, busqueda.getFecha_fin());
            pre.setString(3, busqueda.getFecha_inicio());
            pre.setString(4, busqueda.getFecha_fin());
            ResultSet res= pre.executeQuery();
            while(res.next()){
                A_Proyecto ob = new A_Proyecto();
                String[] parts = res.getString("fecha_fin").split("-");

                ob.setProyecto_id(res.getInt("proyecto_id"));
                ob.setNombre(res.getString("nombre"));
                ob.setNombrep(res.getString("nombrep"));
                ob.setFecha_publicacion(res.getString("fecha_inicio"));
                ob.setFecha_fin(res.getString("fecha_fin"));
                ob.setDescripcion(res.getString("descripcion"));
                ob.setMonto_requerido(res.getDouble("monto_recaudar"));
                ob.setMonto_recaudado(res.getDouble("sum"));
                ob.setPersona_id(res.getInt("persona_id"));

                int a = Integer.parseInt(parts[0]); // 123
                int m = Integer.parseInt(parts[1]);
                int d = Integer.parseInt(parts[2]);

                if(fecha_actual.equals(res.getString("fecha_inicio"))){
                    ob.setEstado("NUEVO");
                }else{
                    if(a<año){
                        ob.setEstado("FINALIZADO");
                    }else{
                       if(a==año){
                           if(m<mes){
                               ob.setEstado("FINALIZADO");
                           }else{
                               if(d<dia){
                                   ob.setEstado("FINALIZADO");
                               }else{
                                   ob.setEstado("ACTIVO");
                               }
                           }
                       }else{
                           if(a>año){
                               ob.setEstado("ACTIVO");
                           }

                       }
                    }
                }
                array.add(ob);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return array;
    }



}
