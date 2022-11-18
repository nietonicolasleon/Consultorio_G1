package modelo;

/*Hecha por Kiara Chunga*/
import java.time.LocalTime;


public class Limpieza extends Tratamiento{
    private boolean isProfunda;

    public Limpieza(int id,String nT, LocalTime dT, boolean isP ) {
        super(id,nT, dT);
        this.isProfunda = isP;
    }

    public boolean isIsProfunda() {
        return isProfunda;
    }

    public void setIsProfunda(boolean isProfunda) {
        this.isProfunda = isProfunda;
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
        return "¿Limpieza Profunda?: " + this.isProfunda ;
    }
    

    
    
    
}
