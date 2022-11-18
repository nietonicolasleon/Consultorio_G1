package modelo;

/*Hecha por Kiara Chunga*/
import java.time.LocalTime;

public class Limpieza extends Tratamiento{
    //Atributos
    private boolean isProfunda;

    /*Método Constructor*/
    public Limpieza(int id,String nT, LocalTime dT, boolean isP ) {
        super(id,nT, dT);
        this.isProfunda = isP;
    }

    /*Getters y Setters*/
    public boolean isIsProfunda() {
        return isProfunda;
    }

    public void setIsProfunda(boolean isProfunda) {
        this.isProfunda = isProfunda;
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
        return "¿Limpieza Profunda?: " + this.isProfunda ;
    }
    

    
    
    
}
