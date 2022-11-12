/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import modelo.*;

/**
 *
 * @author localuser
 */
public class accesoDatos {
    
    Odontologo o1 = new Odontologo("Pedro","parques","pedroparques@gmail.com","M12345");
    Odontologo o2 = new Odontologo("Sofia","Ramirez","sofiaramirez@gmail.com","M54321");
    
    Horario h1 = new Horario(o1, LocalTime.of(9, 0),LocalTime.of(12, 0),1);
    Horario h2 = new Horario(o1, LocalTime.of(9, 0),LocalTime.of(12, 0),2);

    Horario h3 = new Horario(o2, LocalTime.of(9, 0),LocalTime.of(12, 0),2);
    Horario h4 = new Horario(o2, LocalTime.of(9, 0),LocalTime.of(12, 0),2);
    
    Limpieza l1 = new Limpieza("limpieza",LocalTime.of(1, 0),false);
    Implante i1 = new Implante("limpieza",LocalTime.of(1, 0),"china");
    
    Turno t1 = new Turno(1, l1, null, LocalDate.of(2022, 10, 20), LocalTime.of(0, 30), LocalTime.of(9, 0));
    
    Turno t2 = new Turno(2, l1, null, LocalDate.of(2022, 10, 22), LocalTime.of(0, 30), LocalTime.of(9, 30));
    Turno t3 = new Turno(3, i1, null, LocalDate.of(2022, 10, 24), LocalTime.of(0, 30), LocalTime.of(16, 30));
    Turno t4 = new Turno(4, i1, null, LocalDate.of(2022, 10, 26), LocalTime.of(0, 30), LocalTime.of(17, 0));
    
    Agenda a1 = new Agenda();
    Agenda a2 = new Agenda();
    
    public accesoDatos(){
        a1.addHorario(h1);
        a1.addHorario(h2);
        a1.addTurno(t1);
        a1.addTurno(t2);
        a2.addHorario(h3);
        a2.addHorario(h4);
        a2.addTurno(t3);
        a2.addTurno(t4);
    }
    
    public ArrayList<Agenda> getAgendas(){
        ArrayList<Agenda> a = new ArrayList();
        a.add(a1);
        a.add(a2);
        return a;
    }
}
