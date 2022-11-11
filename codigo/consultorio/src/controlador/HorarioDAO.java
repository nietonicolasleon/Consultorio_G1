package controlador.bdd;

import static controlador.bdd.Conexion.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.*;

public class HorarioDAO {

    private static final String SQL_SELECT = "SELECT idOdontologo, diaSemana, horaInicio, horaFin hora FROM horario";
    private static final String SQL_INSERT = "INSERT INTO horario(idOdontologo, diaSemana, horaInicio, horaFin) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE turno SET idOdontologo = ? , diaSemana = ? , horaInicio = ?, horaFin = ? WHERE idOdontolog = ?";
    private static final String SQL_DELETE = "DELETE FROM turno WHERE idOdontologo = ?";

    public List<Horario> seleccionar() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Turno turno = null;
        List<Horario> horarios = new ArrayList<>();

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idOdontologo = rs.getInt("idOdontologo");
                Date diaSemana = rs.getDate("diaSemana");
                Date horaInicio = rs.getDate("horaInicio");
                Date horaFin = rs.getDate("horaFin");
                Horario horario = new Horario(idOdontologo, diaSemana, horaInicio, horaFin);
                horarios.add(horario);
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
        return horarios;
    }

    public int insertar(Horario horario) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setInt(1, horario.getIdOdontologo());
            stmt.setDate(2, horario.getDiaSemana());
            stmt.setDate(3, horario.getHoraInicio());
            stmt.setDate(4, horario.getHoraFin());
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

    public int actualizar(Horario horario) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, horario.getIdOdontologo());
            stmt.setDate(2, horario.getDiaSemana());
            stmt.setDate(3, horario.getHoraInicio());
            stmt.setDate(4, horario.getHoraFin());
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

    public int eliminar(Horario horario) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1, horario.getIdOdontologo());
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
