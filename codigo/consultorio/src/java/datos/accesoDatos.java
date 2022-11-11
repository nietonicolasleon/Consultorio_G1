/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import modelo.*;

/**
 *
 * @author localuser
 */
public class accesoDatos {
    
    Odontologo o1 = new Odontologo("Pedro","parques","pedroparques@gmail.com","12345");
    
    Horario h1 = new Horario(o1, LocalTime.of(9, 0),LocalTime.of(12, 0),1);
    Horario h2 = new Horario(o1, LocalTime.of(9, 0),LocalTime.of(12, 0),2);
    
    Limpieza l1 = new Limpieza("limpieza",LocalTime.of(1, 0),false);
    
    Turno t1 = new Turno(l1, LocalDate.now(), LocalTime.of(0, 30), LocalTime.of(9, 0));
    Turno t2 = new Turno(l1, LocalDate.now(), LocalTime.of(0, 30), LocalTime.of(9, 30));
    
    Agenda a1 = new Agenda();
    
    public accesoDatos(){
        a1.addHorario(h1);
        a1.addHorario(h2);
        a1.addTurno(t1);
        a1.addTurno(t2);
    }
    
    public ArrayList<Agenda> getAgendas(){
        ArrayList<Agenda> a = new ArrayList();
        a.add(a1);
        return a;
    }
}
