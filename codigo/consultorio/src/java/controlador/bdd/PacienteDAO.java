package controlador.bdd;

import static controlador.bdd.Conexion.close;
import static controlador.bdd.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Odontologo;
import modelo.Paciente;

public class PacienteDAO {

    private static final String SQL_SELECT = "SELECT idPaciente, nombre, apellido, dni, mail FROM paciente";
    private static final String SQL_INSERT = "INSERT INTO paciente(idPaciente,nombre,apellido,dni,mail) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE paciente SET idPaciente = ? , nombre = ? , apellido =  ? , dni = ?, mail = ? WHERE idPaciente = ?";
    private static final String SQL_DELETE = "DELETE FROM paciente WHERE idPaciente = ?";

    public List<Paciente> seleccionar() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Paciente paciente = null;
        List<Paciente> pacientes = new ArrayList<>();

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPaciente = rs.getInt("idPaciente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                String mail = rs.getString("mail");
                paciente = new Paciente(idPaciente, dni, nombre, apellido, mail);
                pacientes.add(paciente);
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
        return pacientes;
    }

    public int insertar(Paciente paciente) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setInt(1, paciente.getId());
            stmt.setString(2, paciente.getNombre());
            stmt.setString(3, paciente.getApellido());
            stmt.setString(4, paciente.getDni());
            stmt.setString(5, paciente.getMail());
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

    public int actualizar(Paciente paciente) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, paciente.getId());
            stmt.setString(2, paciente.getNombre());
            stmt.setString(3, paciente.getApellido());
            stmt.setString(4, paciente.getDni());
            stmt.setString(5, paciente.getMail());
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

    public int eliminar(Paciente paciente) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1, paciente.getId());
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
