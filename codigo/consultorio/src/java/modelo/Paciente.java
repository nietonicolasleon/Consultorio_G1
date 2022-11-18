
package modelo;


/*Hecha por Kiara Chunga*/
public class Paciente extends Persona {
    //Atributos
    private String dni;

    /*Métodos Constructores*/
    public Paciente(int id,String nombre, String apellido,  String dni,String mail){
      super(id,nombre,apellido,mail);
      this.dni=dni;
    
    }
    
    public Paciente(String nombre, String apellido,  String dni, String mail){
       super(-1,nombre,apellido,mail); //si no le pasa id, el id es -1 para detectarlo desde los servlet y Bdd
       this.dni=dni;
    
    } 

    /*Getters y Setters*/
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApellido() {
        return apellido;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String getMail() {
        return mail;
    }

    @Override
    public void setMail(String mail) {
        this.mail = mail;
    }
    
    /*Método toString*/
    @Override
    public String toString() {
        return "Dni del paciente" + this.dni;
    }
    
    
    
    
    
}
