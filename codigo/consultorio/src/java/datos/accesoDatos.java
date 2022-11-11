package datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.time.LocalTime;
import modelo.*;

public class accesoDatos {
    private Connection conn;
    private Statement comandos;
    
    private String url = "jdbc:mysql://localhost/consultorio";
    private String user = "root";
    private String password = "";
    
    public Limpieza l1 = new Limpieza("Limpieza tranqui", LocalTime.of(1, 0), false);
    
    public Agenda a1 = new Agenda();
    public Agenda a2 = new Agenda();
    public Agenda a3 = new Agenda();
    public Agenda a4 = new Agenda();
    public Agenda a5 = new Agenda();
    
    public accesoDatos(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            comandos = conn.createStatement();
        } catch(ClassNotFoundException ex){
            System.out.println("No se encontro la BDD.");
        } catch (SQLException ex){
            System.out.println("Usuario o password incorrectos.");
        }
    }
    
    public ArrayList<Odontologo> getOdontologos(){
        ArrayList<Odontologo> ods = new ArrayList();
        String sql = "select * from odontologo";
        try{
            ResultSet tabla = comandos.executeQuery(sql);
            while(tabla.next()){
                int id = tabla.getInt("idOdontologo");
                String apellido = tabla.getString("apellido");
                String nombre = tabla.getString("nombre");
                String matricula = tabla.getString("matricula");
                String mail = tabla.getString("mail");
                Odontologo o = new Odontologo(id, nombre, apellido, mail, matricula);
                ods.add(o);
            }
        }catch(SQLException ex){
            System.out.println("ERROR:" + ex.toString());
        }
        return ods;
    }
    
    public ArrayList<Horario> getHorarios(){
        ArrayList<Horario> hors = new ArrayList();
        
    }
}
