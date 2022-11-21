package controlador.bdd;

/*Clase hecha por Nicolás Nieto*/
import static controlador.bdd.Conexion.*;
import java.sql.*;
import java.util.ArrayList;
import controlador.bdd.modelo.TratamientoBDD;
import modelo.*;

public class TratamientoDAO {
    /*Se declaran los select, insert, update y delete*/
    private static final String SQL_SELECT = "SELECT idTratamiento, nombre, duracion, datos FROM tratamiento";
    private static final String SQL_INSERT = "INSERT INTO tratamiento(idTratamiento, nombre, duracion, datos) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tratamiento SET idTratamiento = ? , nombre = ? , duracion = ?, datos = ? WHERE idTratamiento = ?";
    private static final String SQL_DELETE = "DELETE FROM tratamiento WHERE idTratamiento = ?";
    
    /*El método seleccionar devuelve todos los Tratamientos en una ArrayList*/
    public ArrayList<Tratamiento> seleccionar() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<TratamientoBDD> tratamientos = new ArrayList();
        ArrayList<Tratamiento> modelTrats = new ArrayList();

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idTratamiento = rs.getInt("idTratamiento");
                String nombre = rs.getString("nombre");
                Time duracion = rs.getTime("duracion");
                String datos = rs.getString("datos");
                TratamientoBDD tratamiento = new TratamientoBDD(idTratamiento, nombre, duracion, datos);
                tratamientos.add(tratamiento);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(rs);
                close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        /*Empleamos un for y por cada tratamiento, creamos un objeto distinto (Revisar hijos de Tratamiento)*/
        for (int i = 0; i < tratamientos.size(); i++) {
            /*Se filtra la clase de objeto creado en base a su nombre*/
            switch(tratamientos.get(i).getNombre()){
                case "Consulta Primera vez":
                    Consulta cpv = new Consulta(tratamientos.get(i).getIdTratamiento(), tratamientos.get(i).getNombre(), tratamientos.get(i).getDuracion().toLocalTime(), true);
                    modelTrats.add(cpv);
                    break;
                case "Consulta":
                    Consulta c = new Consulta(tratamientos.get(i).getIdTratamiento(), tratamientos.get(i).getNombre(),  tratamientos.get(i).getDuracion().toLocalTime(), false);
                    modelTrats.add(c);
                    break;
                case "Conducto 1 auxiliar":
                    Conducto c1 = new Conducto(tratamientos.get(i).getIdTratamiento(), tratamientos.get(i).getNombre(),  tratamientos.get(i).getDuracion().toLocalTime(), 1);
                    modelTrats.add(c1);
                    break;
                case "Conducto 2 auxiliares":
                    Conducto c2 = new Conducto(tratamientos.get(i).getIdTratamiento(), tratamientos.get(i).getNombre(),  tratamientos.get(i).getDuracion().toLocalTime(), 2);
                    modelTrats.add(c2);
                    break;
                case "Limpieza Simple":
                    Limpieza ls = new Limpieza(tratamientos.get(i).getIdTratamiento(), tratamientos.get(i).getNombre(),  tratamientos.get(i).getDuracion().toLocalTime(), false);
                    modelTrats.add(ls);
                    break;
                case "Limpieza Profunda":
                    Limpieza lp = new Limpieza(tratamientos.get(i).getIdTratamiento(), tratamientos.get(i).getNombre(),  tratamientos.get(i).getDuracion().toLocalTime(), true);
                    modelTrats.add(lp);
                    break;
                case "Implante Chino":
                    Implante ip = new Implante(tratamientos.get(i).getIdTratamiento(), tratamientos.get(i).getNombre(),  tratamientos.get(i).getDuracion().toLocalTime(), "China");
                    modelTrats.add(ip);
                    break;
                case "Implante Ruso":
                    Implante ir = new Implante(tratamientos.get(i).getIdTratamiento(), tratamientos.get(i).getNombre(),  tratamientos.get(i).getDuracion().toLocalTime(), "Rusia");
                    modelTrats.add(ir);
                    break;
                case "Extraccion Simple":
                    Extraccion es = new Extraccion(tratamientos.get(i).getIdTratamiento(), tratamientos.get(i).getNombre(),  tratamientos.get(i).getDuracion().toLocalTime(), false);
                    modelTrats.add(es);
                    break;
                case "Extraccion Compleja":
                    Extraccion ec = new Extraccion(tratamientos.get(i).getIdTratamiento(), tratamientos.get(i).getNombre(),  tratamientos.get(i).getDuracion().toLocalTime(), true);
                    modelTrats.add(ec);
                    break;
                case "Periodoncia Simple":
                    Periodoncia ps = new Periodoncia(tratamientos.get(i).getIdTratamiento(), tratamientos.get(i).getNombre(),  tratamientos.get(i).getDuracion().toLocalTime(), "Bajo");
                    modelTrats.add(ps);
                    break;
                case "Periodoncia Compleja":
                    Periodoncia pc = new Periodoncia(tratamientos.get(i).getIdTratamiento(), tratamientos.get(i).getNombre(),  tratamientos.get(i).getDuracion().toLocalTime(), "Alto");
                    modelTrats.add(pc);
                    break;
                default:
                    System.out.println("Error.");
                    break;
            }
        }
        
        return modelTrats;
    }
    
    /*El método insertar permite insertar un nuevo Tratamiento a la BDD*/
    public int insertar(TratamientoBDD tratamiento) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setInt(1, tratamiento.getIdTratamiento());
            stmt.setString(2, tratamiento.getNombre());
            stmt.setTime(3, tratamiento.getDuracion());
            stmt.setString(4, tratamiento.getDatos());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }
    
    /*El método actualizar permite cambiar los datos de un Tratamiento de la BDD*/
    public int actualizar(TratamientoBDD tratamiento) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, tratamiento.getIdTratamiento());
            stmt.setString(2, tratamiento.getNombre());
            stmt.setTime(3, tratamiento.getDuracion());
            stmt.setString(4, tratamiento.getDatos());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    /*El método eliminar permite eliminar un Tratamiento de la BDD*/
    public int eliminar(TratamientoBDD tratamiento) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1, tratamiento.getIdTratamiento());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }
    
    /*Este método nos permite conseguir un Tratamiento en base a su ID*/
    public Tratamiento getTratamientoById(int id) {
        for (Tratamiento t: this.seleccionar()){
            if(id == t.getId()){
                return t;
            }
        }
        return null;
    }
}
