
package modelo;


public class Odontologo extends Persona{
     private String matricula;

     
    public Odontologo(int id, String nombre, String apellido, String mail, String matricula) {
    super(id,nombre,apellido,mail);
    this.matricula=matricula;    
    }
    
    
    public Odontologo(String nombre, String apellido, String mail,String matricula) {
      super(nombre,apellido,mail);
      this.matricula=matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
        return "Odontologo:" + this.nombre  +" "+ this.apellido + "Nro matricula=" + this.matricula;
    }







}

