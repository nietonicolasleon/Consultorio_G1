package modelo;

/*Hecha por Kiara Chunga*/
import java.time.LocalTime;

public class Extraccion extends Tratamiento{
    private boolean isCompleja;

    public Extraccion(int id,String nT, LocalTime dT, boolean isC) {
        super(id, nT, dT);
        this.isCompleja = isC;
    }

    public boolean isIsCompleja() {
        return isCompleja;
    }

    public void setIsCompleja(boolean isCompleja) {
        this.isCompleja = isCompleja;
    }

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

    
    @Override
    public String toString() {
        return "¿Extracción Compleja?: " + this.isCompleja;
    }
    
 
    
}
