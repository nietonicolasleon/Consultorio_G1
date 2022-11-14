
package modelo;

import java.time.LocalTime;

public abstract class Tratamiento {
    protected int id;
    protected String nombreTratamiento;
    protected  LocalTime duracionTotal;

    public Tratamiento(int id ,String nT, LocalTime dT) {
        this.id = id;
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
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
    
}
