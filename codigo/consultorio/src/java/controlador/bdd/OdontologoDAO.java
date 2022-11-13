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




public class OdontologoDAO {
    private static final String SQL_SELECT = "SELECT idOdontologo, nombre, apellido, matricula, mail FROM odontologo";
    private static final String SQL_INSERT = "INSERT INTO odontologo(idOdontologo,nombre,apellido,matricula,mail) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE odontologo SET idOdontologo = ? , nombre = ? , apellido =  ? , matricula = ?, mail = ? WHERE idOdontologo = ?";
    private static final String SQL_DELETE = "DELETE FROM odontologo WHERE idOdontologo = ?";

    public List<Odontologo> seleccionar() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Odontologo odontologo = null;
        List<Odontologo> odontologos = new ArrayList<>();

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idOdontologo = rs.getInt("idOdontologo");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String mail = rs.getString("mail");
                String matricula = rs.getString("matricula");
                odontologo = new Odontologo(idOdontologo,nombre,apellido,mail,matricula);
                odontologos.add(odontologo);
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
        return odontologos;
    }
    
    public int insertar(Odontologo odontologo) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setInt(1, odontologo.getId());
            stmt.setString(2, odontologo.getNombre());
            stmt.setString(3, odontologo.getApellido());
            stmt.setString(4 , odontologo.getMail());
            stmt.setString(5, odontologo.getMatricula());
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
    
    public int actualizar(Odontologo odontologo) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, odontologo.getId());
            stmt.setString(2, odontologo.getNombre());
            stmt.setString(3, odontologo.getApellido());
            stmt.setString(4, odontologo.getMail());
            stmt.setString(5, odontologo.getMatricula());
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
        public int eliminar(Odontologo odontologo) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1, odontologo.getId());
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
