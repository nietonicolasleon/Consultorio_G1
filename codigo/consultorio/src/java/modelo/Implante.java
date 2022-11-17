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
public class Implante extends Tratamiento implements ImplanteGenerico {
    protected String paisOrigen ;

    public Implante(int id,String nombreTratamiento,LocalTime duracionTotal,String paisOrigen) {
        super(id,nombreTratamiento,duracionTotal);
        this.paisOrigen = paisOrigen;
    }

    @Override
    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
    
    
    public String toString(){
        return super.toString() + "\n Pais de origen:"+this.paisOrigen;
    }
    
    
}
