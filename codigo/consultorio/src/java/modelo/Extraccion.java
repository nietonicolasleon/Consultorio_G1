package modelo;

/*Hecha por Kiara Chunga*/
import java.time.LocalTime;

public class Extraccion extends Tratamiento{
    //Atributos
    private boolean isCompleja;

    /*Método Constructor*/
    public Extraccion(int id,String nT, LocalTime dT, boolean isC) {
        super(id, nT, dT);
        this.isCompleja = isC;
    }

    /*Getters y Setters*/
    public boolean isIsCompleja() {
        return isCompleja;
    }

    public void setIsCompleja(boolean isCompleja) {
        this.isCompleja = isCompleja;
    }
    
    @Override
    public String getNombreTratamiento() {
        return nombreTratamiento;
    }

    @Override
    public void setNombreTratamiento(String nombreTratamiento) {
        this.nombreTratamiento = nombreTratamiento;
    }

    @Override
    public LocalTime getDuracionTotal() {
        return duracionTotal;
    }

    @Override
    public void setDuracionTotal(LocalTime duracionTotal) {
        this.duracionTotal = duracionTotal;
    }

    /*Método toString*/
    @Override
    public String toString() {
        return "¿Extracción Compleja?: " + this.isCompleja;
    }
    
 
    
}
