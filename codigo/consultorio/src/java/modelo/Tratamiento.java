
package modelo;

import java.time.LocalTime;

public abstract class Tratamiento {
    protected String nombreTratamiento;
    protected  LocalTime duracionTotal;

    public Tratamiento(String nT, LocalTime dT) {
        this.nombreTratamiento = nT;
        this.duracionTotal = dT;
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
        return "Tratamiento: "+ this.nombreTratamiento + "\n duracionTotal: " + this.duracionTotal;
    }
    
    
    
    
    
}
