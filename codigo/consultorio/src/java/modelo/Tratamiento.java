
package modelo;

import java.time.LocalTime;

public abstract class Tratamiento {
    protected String nombreTratamiento;
    protected  LocalTime duracionTotal;

    public Tratamiento(String nT, LocalTime dT) {
        this.nombreTratamiento = nT;
        this.duracionTotal = dT;
    }

    @Override
    public String toString() {
        return "Tratamiento: "+ nombreTratamiento + "\n duracionTotal: " + duracionTotal;
    }
    
    
    
    
    
}
