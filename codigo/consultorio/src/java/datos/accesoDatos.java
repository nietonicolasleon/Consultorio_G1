package datos;
import java.time.LocalDate;
import java.time.LocalTime;
import modelo.*;

public class accesoDatos {
    
    public Odontologo o1 = new Odontologo("Pedro","parques","pedroparques@gmail.com","12345");
    
    public Horario h1 = new Horario(o1, LocalTime.of(9, 0),LocalTime.of(12, 0),1);
    public Horario h2 = new Horario(o1, LocalTime.of(9, 0),LocalTime.of(12, 0),2);
    
    public Limpieza l1 = new Limpieza("limpieza",LocalTime.of(1, 0),false);
    
    public Turno t1 = new Turno(l1, LocalDate.now(), LocalTime.of(0, 30), LocalTime.of(9, 0));
    public Turno t2 = new Turno(l1, LocalDate.now(), LocalTime.of(0, 30), LocalTime.of(9, 30));
    
    public Agenda a1 = new Agenda();
    public Agenda a2 = new Agenda();
    public Agenda a3 = new Agenda();
    public Agenda a4 = new Agenda();
    public Agenda a5 = new Agenda();
    
    public accesoDatos(){
        a1.addHorario(h1);
        a1.addHorario(h2);
        a1.addTurno(t1);
        a1.addTurno(t2);
    }
}
