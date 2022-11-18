package modelo;

/*Hecha por Dylan Seltzer*/
import java.time.LocalTime;

public class Implante extends Tratamiento implements ImplanteGenerico {
    //Atributos
    protected String paisOrigen ;

    /*Método Constructor*/
    public Implante(int id,String nombreTratamiento,LocalTime duracionTotal,String paisOrigen) {
        super(id,nombreTratamiento,duracionTotal);
        this.paisOrigen = paisOrigen;
    }

    /*Getters y Setters*/
    @Override
    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
    
    @Override
    public String toString(){
        return "Pais de origen: " + this.paisOrigen;
    }
    
    
}
