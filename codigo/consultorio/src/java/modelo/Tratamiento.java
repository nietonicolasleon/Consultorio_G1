package modelo;

/*Hecha por Kiara Chunga*/
import java.time.LocalTime;

public abstract class Tratamiento {
    //Atributos
    protected int id;
    protected String nombreTratamiento;
    protected  LocalTime duracionTotal;

    /*Método Constructor*/
    public Tratamiento(int id ,String nT, LocalTime dT) {
        this.id = id;
        this.nombreTratamiento = nT;
        this.duracionTotal = dT;
    }

    /*Getters y Setters*/
    public String getNombreTratamiento() {
        return nombreTratamiento;
    }

    public void setNombreTratamiento(String nombreTratamiento) {
        this.nombreTratamiento = nombreTratamiento;
    }

    public LocalTime getDuracionTotal() {
        return duracionTotal;
    }

    public void setDuracionTotal(LocalTime duracionTotal) {
        this.duracionTotal = duracionTotal;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    /*Método toString*/
    @Override
    public String toString() {
        return "Tratamiento: "+ this.nombreTratamiento + "\n Duración: " + this.duracionTotal;
    }
}
