/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.bdd;

import datos.accesoDatos;
import modelo.Agenda;
import modelo.Odontologo;
import modelo.Turno;

/**
 *
 * @author dylan
 */
public class BddOdontologo {
    accesoDatos acc = new accesoDatos();
    public Odontologo getOdontologoById(int id) {
        for(Agenda agenda:acc.getAgendas()){
            Odontologo o = agenda.getHorarios().get(0).getOdontologo();
            if(o.getId() == id){
                return o;
            }
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
