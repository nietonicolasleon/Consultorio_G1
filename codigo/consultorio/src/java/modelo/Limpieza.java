/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalTime;


public class Limpieza extends Tratamiento{
    private boolean isProfunda;

    public Limpieza(String nT, LocalTime dT, boolean isP ) {
        super(nT, dT);
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
        return super.toString() + "\n es Profunda: " + this.isProfunda ;
    }
    

    
    
    
}
