package controlador.bdd;

import controlador.bdd.modelo.TurnoBdd;
import controlador.bdd.modelo.HorarioBdd;
import static controlador.bdd.Conexion.*;
import java.sql.*;
import java.util.ArrayList;

public class HorarioDAO {

    private static final String SQL_SELECT = "SELECT idOdontologo, diaSemana, horaInicio, horaFin FROM horario";
    private static final String SQL_INSERT = "INSERT INTO horario(idOdontologo, diaSemana, horaInicio, horaFin) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE horario SET idOdontologo = ? , diaSemana = ? , horaInicio = ?, horaFin = ? WHERE idOdontologo = ?";
    private static final String SQL_DELETE = "DELETE FROM horario WHERE idOdontologo = ?";

    public ArrayList<HorarioBdd> seleccionar() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<HorarioBdd> horarios = new ArrayList();

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idOdontologo = rs.getInt("idOdontologo");
                int diaSemana = rs.getInt("diaSemana");
                Time horaInicio = rs.getTime("horaInicio");
                Time horaFin = rs.getTime("horaFin");
                HorarioBdd horario = new HorarioBdd(idOdontologo, diaSemana, horaInicio, horaFin);
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

    public int insertar(HorarioBdd horario) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setInt(1, horario.getIdOdontologo());
            stmt.setInt(2, horario.getDiaSemana());
            stmt.setTime(3, horario.getHoraInicio());
            stmt.setTime(4, horario.getHoraFin());
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

    public int actualizar(HorarioBdd horario) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, horario.getIdOdontologo());
            stmt.setInt(2, horario.getDiaSemana());
            stmt.setTime(3, horario.getHoraInicio());
            stmt.setTime(4, horario.getHoraFin());
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

    public int eliminar(HorarioBdd horario) {
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
