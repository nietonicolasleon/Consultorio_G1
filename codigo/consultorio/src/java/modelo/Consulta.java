package modelo;

/*Hecha por Kiara Chunga*/
import java.time.LocalTime;

public class Consulta extends Tratamiento{
    //Atributos
    private boolean isPrimeraVez;

    /*Método Constructor*/
    public Consulta( int id,String nT, LocalTime dT, boolean isP) {
        super(id,nT, dT);
        this.isPrimeraVez = isP;
    }

    /*Getters y Setters*/
    public boolean isIsPrimeraVez() {
        return isPrimeraVez;
    }

    public void setIsPrimeraVez(boolean isPrimeraVez) {
        this.isPrimeraVez = isPrimeraVez;
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
        return "¿Primera Vez?: " + this.isPrimeraVez;
    }
}