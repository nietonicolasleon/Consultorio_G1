package modelo;

/*Hecha por Kiara Chunga*/
public abstract class Persona {
    //Atributos
   protected int id;
   protected String nombre;
   protected String apellido;
   protected String mail;

    /*Métodos Constructores*/
    public Persona(int id, String nombre, String apellido, String mail) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
    }
    
    public Persona( String nombre, String apellido, String mail) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
    }

    /*Getters y Setters*/
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

    /*Método toString*/
    @Override
    public String toString() {
        return "id de Persona: " + this.id +"\n Nombre y apellido: " + this.nombre+" "+this.apellido+"\n email: "+this.mail;
    }
}
    
    
    



