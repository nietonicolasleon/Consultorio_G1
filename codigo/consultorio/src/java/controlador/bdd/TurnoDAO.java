package controlador.bdd;

/*Clase hecha por Wilver Guzmán, Corregida por Nicolás Nieto*/
import java.util.Date;
import static controlador.bdd.Conexion.*;
import controlador.bdd.modelo.TurnoBdd;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import modelo.*;

public class TurnoDAO {
    /*Se declaran los select, insert, update y delete*/
    private static final String SQL_SELECT = "SELECT idTurno, idPaciente, idOdontologo, idTratamiento, fecha, hora FROM turno";
    private static final String SQL_INSERT = "INSERT INTO turno(idPaciente,idOdontologo,idTratamiento,fecha,hora) VALUES (?,?,?,?,?);";
    private static final String SQL_UPDATE = "UPDATE turno SET idTratamiento = ? , fecha = ? , hora = ? WHERE idTurno = ?";
    private static final String SQL_DELETE = "DELETE FROM turno WHERE idTurno = ?";

    /*Este método nos permite seleccionar un ArrayList de todos los Turnos de la BDD*/
    public ArrayList<Turno> seleccionar() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TurnoBdd turno = null;
        ArrayList<TurnoBdd> turnosBdd = new ArrayList();
        ArrayList<Turno> turnos = new ArrayList();
        TratamientoDAO tratamentoDao = new TratamientoDAO();
        PacienteDAO pacienteDao = new PacienteDAO();


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
                turnosBdd.add(turno);
            }
            for (TurnoBdd turnoBdd : turnosBdd){
                Tratamiento tratamiento = tratamentoDao.getTratamientoById(turnoBdd.getIdTratamiento()); //Creo el tratamiento desde la bdd
                Paciente paciente = pacienteDao.getPacienteById(turnoBdd.getIdPaciente()); //creo el paciente desde la bdd
                LocalDate fecha = turnoBdd.getFecha().toLocalDate(); //convierto la fecha de DATE SQL a LOCALDATE java
                LocalTime duracion = LocalTime.of(0, 30) ; //la duracion es fija por defecto 30 m
                LocalTime hInicio = turnoBdd.getHora().toLocalTime(); //convierto la hora de TIME SQL a LOCALTIME java
                Turno turnoM= new Turno(turnoBdd.getIdTurno(), tratamiento, paciente, fecha, duracion, hInicio);
                turnos.add(turnoM);
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
            stmt.setInt(1, turno.getIdTurno()); //HAY QUE RE ORGANIZAR EL CODIGO PARA QUE FUNCIONE CON EL WHERE EL ID
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
    
    
    /*Con este método podemos acceder a un Turno por su id*/
    public Turno getTurnoById(int id ) {
        for (Turno t: this.seleccionar()){
            if(id == t.getId()){
                return t;
            }
        }
        return null;
    }
    
    
}
