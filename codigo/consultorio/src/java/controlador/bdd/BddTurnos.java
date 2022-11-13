/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.bdd;

import controlador.bdd.modelo.TurnoBdd;
import modelo.*;
import datos.accesoDatos;
/**
 *
 * @author dylan
 */
public class BddTurnos {
    accesoDatos acc = new accesoDatos();
    public TurnoBdd getTurnoById(int id) {
        for(Agenda agenda:acc.getAgendas()){
            for(TurnoBdd turno: agenda.getTurnos()){
                if(turno.getId()==id){
                    return turno;
                }
            }
        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
