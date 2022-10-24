
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
    
    
    
    
    
}
