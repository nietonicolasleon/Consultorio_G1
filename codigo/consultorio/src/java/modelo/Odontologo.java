
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

    @Override
    public String toString() {
        return "Odontologo{" + "matricula=" + matricula + '}';
    }







}

