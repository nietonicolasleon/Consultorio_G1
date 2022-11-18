package controlador.bdd;
 
import java.sql.*;

/*Hecha por Dylan Seltzer*/
public class Conexion {
    /*Se declaran las variables para la conexión con la BDD*/
    public static final String URL = "jdbc:mysql://localhost:3306/consultorio";
    public static final String USER = "root";
    public static final String CLAVE = "";
     
    /*Se establece la conexión con el uso de un try catch*/
    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
    
    /*Se establecen los métodos de cerrar conexión con la BDD*/
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(Connection con) throws SQLException {
        con.close();
    }
}