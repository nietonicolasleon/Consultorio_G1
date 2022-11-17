package controlador.bdd;

import java.util.Date;
import static controlador.bdd.Conexion.*;
import java.sql.*;
import java.util.ArrayList;
import controlador.bdd.modelo.TratamientoBDD;
import modelo.*;

public class TratamientoDAO {
    private static final String SQL_SELECT = "SELECT idTratamiento, nombre, duracion, datos FROM tratamiento";
    private static final String SQL_INSERT = "INSERT INTO tratamiento(idTratamiento, nombre, duracion, datos) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tratamiento SET idTratamiento = ? , nombre = ? , duracion = ?, datos = ? WHERE idTratamiento = ?";
    private static final String SQL_DELETE = "DELETE FROM tratamiento WHERE idTratamiento = ?";
    
    public ArrayList<TratamientoBDD> seleccionar() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<TratamientoBDD> tratamientos = new ArrayList();

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
        
        /*INGRESE CODIGO PARA TRANFORMAR DE ArraList<TRATAMIENTOBDD> A ArrayList<TRATAMIENTOMODELO> */
        return tratamientos;
    }
    
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
    /*
    public Tratamiento getTratamientoById(int id) {
        for (Tratamiento t: this.seleccionar()){
            if(id == p.getId()){
                return p;
            }
        }
        return null;
    }
    */
}
