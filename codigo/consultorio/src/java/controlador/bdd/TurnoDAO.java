package controlador.bdd;

/*Clase hecha por Wilver Guzmán, Corregida por Nicolás Nieto*/
import java.util.Date;
import static controlador.bdd.Conexion.*;
import controlador.bdd.modelo.TurnoBdd;
import java.sql.*;
import java.util.ArrayList;

public class TurnoDAO {
    /*Se declaran los select, insert, update y delete*/
    private static final String SQL_SELECT = "SELECT idTurno, idPaciente, idOdontologo, idTratamiento, fecha, hora FROM turno";
    private static final String SQL_INSERT = "INSERT INTO turno(idPaciente,idOdontologo,idTratamiento,fecha,hora) VALUES (?,?,?,?,?);";
    private static final String SQL_UPDATE = "UPDATE turno SET idTratamiento = ? , fecha = ? , hora = ? WHERE idTurno = ?";
    private static final String SQL_DELETE = "DELETE FROM turno WHERE idTurno = ?";

    /*Este método nos permite seleccionar un ArrayList de todos los Turnos de la BDD*/
    public ArrayList<TurnoBdd> seleccionar() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TurnoBdd turno = null;
        ArrayList<TurnoBdd> turnos = new ArrayList();

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idTurno = rs.getInt("idTurno");
                int idPaciente = rs.getInt("idPaciente");
                int idOdontologo = rs.getInt("idOdontologo");
                int isTratamiento = rs.getInt("idTratamiento");
                Date fecha = rs.getDate("fecha");
                Time hora = rs.getTime("hora");
                turno = new TurnoBdd(idTurno, idPaciente, idOdontologo, isTratamiento, fecha, hora);
                turnos.add(turno);
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
        return turnos;
    }
    
    /*Este método nos permite insertar un nuevo turno a la BDD*/
    public int insertar(TurnoBdd turno) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setInt(1, turno.getIdTurno());
            stmt.setInt(2, turno.getIdPaciente());
            stmt.setInt(3, turno.getIdOdontologo());
            stmt.setInt(4, turno.getIdTratamiento());
            stmt.setDate(5, turno.getFecha());
            stmt.setTime(6, turno.getHora());
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
    
    /*Este método nos permite actualizar los datos de un turno de la BDD*/
    public int actualizar(TurnoBdd turno) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, turno.getIdTurno());
            stmt.setInt(2, turno.getIdPaciente());
            stmt.setInt(3, turno.getIdOdontologo());
            stmt.setInt(4, turno.getIdTratamiento());
            stmt.setDate(5, turno.getFecha());
            stmt.setTime(6, turno.getHora());
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
    
    /*Este método nos permite eliminar un turno de la BDD*/
    public int eliminar(TurnoBdd turno) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1, turno.getIdTurno());
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
    
    
}
