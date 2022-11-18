package controlador.bdd;

/*Clase hecha por Wilver Guzmán*/
import static controlador.bdd.Conexion.close;
import static controlador.bdd.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Paciente;

public class PacienteDAO {
    /*Se declaran los select, insert, update y delete*/
    private static final String SQL_SELECT = "SELECT idPaciente, nombre, apellido, dni, mail FROM paciente";
    private static final String SQL_INSERT = "INSERT INTO paciente(nombre,apellido,dni,mail) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE paciente SET idPaciente = ? , nombre = ? , apellido =  ? , dni = ?, mail = ? WHERE idPaciente = ?";
    private static final String SQL_DELETE = "DELETE FROM paciente WHERE idPaciente = ?";

    /*El método seleccionar devuelve todos los Paciente en una List*/
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
                paciente = new Paciente(idPaciente, nombre, apellido, dni, mail);
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

    /*Este método nos permite insertar un nuevo paciente a la BDD*/
    public int insertar(Paciente paciente) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setString(1, paciente.getNombre());
            stmt.setString(2, paciente.getApellido());
            stmt.setString(3, paciente.getDni());
            stmt.setString(4, paciente.getMail());
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

    /*Este método nos permite actualizar los datos de un paciente de la BDD*/
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

    /*Este método nos permite eliminar un paciente de la BDD*/
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
    
    /*Este método nos permite seleccionar un paciente por su DNI*/
    public Paciente getPacienteByDni(String dni) {
        for (Paciente p: this.seleccionar()){
            if(dni.equals(p.getDni())){
                return p;
            }
        }
        return null;
    }
    
    /*Este método nos permite seleccionar un paciente por su ID*/
    public Paciente getPacienteById(int id) {
        for (Paciente p: this.seleccionar()){
            if(id == p.getId()){
                return p;
            }
        }
        return null;
    }
    
}
