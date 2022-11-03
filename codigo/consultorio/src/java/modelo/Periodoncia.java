/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalTime;


public class Periodoncia extends Tratamiento {
   private String nivelSangrado;

    public Periodoncia(String nT, LocalTime dT ,String nS ) {
        super(nT, dT);
        this.nivelSangrado = nS;
    }

    public String getNivelSangrado() {
        return nivelSangrado;
    }

    public void setNivelSangrado(String nivelSangrado) {
        this.nivelSangrado = nivelSangrado;
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
        return super.toString() + "\n nivel de Sangrado: " + nivelSangrado;
    }
    
    
   
   
   
}
