package modelo;

/*Hecha por Kiara Chunga*/
public class Odontologo extends Persona{
    //Atributos
     private String matricula;

    /*Métodos Constructores*/
    public Odontologo(int id, String nombre, String apellido, String mail, String matricula) {
        super(id,nombre,apellido,mail);
        this.matricula=matricula;    
    }
    
    public Odontologo(String nombre, String apellido, String mail,String matricula) {
      super(nombre,apellido,mail);
      this.matricula=matricula;
    }

    /*Getters y Setters*/
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
        return "Odontologo:" + this.nombre  +" "+ this.apellido + "Nro matricula=" + this.matricula;
    }







}

