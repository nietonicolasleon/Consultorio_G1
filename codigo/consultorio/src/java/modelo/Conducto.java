/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalTime;

/**
 *
 * @author localuser
 */
public class Conducto extends Tratamiento{
    private int canAuxiliares;

    public Conducto(int id, String nT, LocalTime dT, int cA) {
        super(id,nT, dT);
        this.canAuxiliares = cA;
    }

    public int getCanAuxiliares() {
        return canAuxiliares;
    }

    public void setCanAuxiliares(int canAuxiliares) {
        this.canAuxiliares = canAuxiliares;
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
        
        return "La cantidad de auxiliares es: " + this.canAuxiliares;
    }
    
    
    
    
}
