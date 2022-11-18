package modelo;

/*Hecha por Kiara Chunga*/
import java.time.LocalTime;

public class Consulta extends Tratamiento{
    private boolean isPrimeraVez;

    public Consulta( int id,String nT, LocalTime dT, boolean isP) {
        super(id,nT, dT);
        this.isPrimeraVez = isP;
    }

    public boolean isIsPrimeraVez() {
        return isPrimeraVez;
    }

    public void setIsPrimeraVez(boolean isPrimeraVez) {
        this.isPrimeraVez = isPrimeraVez;
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
        return "¿Primera Vez?: " + this.isPrimeraVez;
    }


    
    
    
    
    
}
