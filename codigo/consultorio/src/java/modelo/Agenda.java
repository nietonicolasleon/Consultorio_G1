
package modelo;

import java.util.ArrayList;

public class Agenda {
    private int id;
    private static int cantAgendas;
    private ArrayList<Turno> turnos = new ArrayList();
    private ArrayList<Horario> horarios = new ArrayList();
    
    public Agenda(){
        Agenda.cantAgendas++;
        this.id = Agenda.cantAgendas;
    }
    
    public void addTurno(Turno t){
        this.turnos.add(t);
    }
    
    public void deleteTurno(int i){
        this.turnos.remove(i);
    }
    
    public void addHorario(Horario h){
        this.horarios.add(h);
    }
    
    public void deleteHorario(int i){
        this.horarios.remove(i);
    }
    
    public ArrayList<Turno> getTurnosDisponibles(){
        ArrayList<Turno> aux = new ArrayList();
        for (int i = 0; i < this.turnos.size(); i++) {
            if (this.turnos.get(i).getPaciente() == null) {
                aux.add(this.turnos.get(i));
            }
        }
        return aux;
    }
    
    @Override
    public String toString(){
        String a = "AGENDA: " + this.id + "\n Esta es la agenda del Odontólogo: " + this.horarios.get(0).getOdontologo().apellido + " " + this.horarios.get(0).getOdontologo().nombre + 
                ". \n Sus horarios son de: " + this.horarios.get(0).getHoraInicio() + " a " + this.horarios.get(0).getHoraFin() + ".";
        return a;
    }
}

