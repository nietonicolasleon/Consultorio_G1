package modelo;

/*Hecha por Kiara Chunga*/
import java.time.LocalTime;

public class Conducto extends Tratamiento{
    //Atributos
    private int canAuxiliares;

    /*Método Constructor*/
    public Conducto(int id, String nT, LocalTime dT, int cA) {
        super(id,nT, dT);
        this.canAuxiliares = cA;
    }

    /*Getters y Setters*/
    public int getCanAuxiliares() {
        return canAuxiliares;
    }

    public void setCanAuxiliares(int canAuxiliares) {
        this.canAuxiliares = canAuxiliares;
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
        
        return "La cantidad de auxiliares es: " + this.canAuxiliares;
    }
    
    
    
    
}
