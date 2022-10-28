
package modelo;



public class Paciente extends Persona {
    private String dni;

    public Paciente(int id,String nombre, String apellido, String mail, String dni){
      super(id,nombre,apellido,mail);
      this.dni=dni;
    
    }
    
    public Paciente(String nombre, String apellido, String mail, String dni){
       super(nombre,apellido,mail);
       this.dni=dni;
    
    } 

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    

    @Override
    public String toString() {
        return "Dni del paciente" + this.dni;
    }
    
    
    
    
    
}
