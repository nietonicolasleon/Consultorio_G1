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

    @Override
    public String toString() {
        return super.toString() + "\n nivel de Sangrado: " + nivelSangrado;
    }
    
    
   
   
   
}
