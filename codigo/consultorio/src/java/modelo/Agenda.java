package modelo;

/*Hecha por Nicolás Nieto*/
import java.util.ArrayList;

public class Agenda {
    //Atributos
    private int id;
    private static int cantAgendas;
    private ArrayList<Turno> turnos = new ArrayList();
    private ArrayList<Horario> horarios = new ArrayList();
    
    /*Método constructor*/
    public Agenda(){
        Agenda.cantAgendas++;
        this.id = Agenda.cantAgendas;
    }
    
    /*Getters y Setters*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCantAgendas() {
        return cantAgendas;
    }

    public static void setCantAgendas(int cantAgendas) {
        Agenda.cantAgendas = cantAgendas;
    }

    public ArrayList<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(ArrayList<Turno> turnos) {
        this.turnos = turnos;
    }

    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<Horario> horarios) {
        this.horarios = horarios;
    }
    
    /*Agregar y Borrar Turnos*/
    public void addTurno(Turno t){
        this.turnos.add(t);
    }
    
    public void deleteTurno(int i){
        this.turnos.remove(i);
    }
    
    /*Agregar y Borrar Horario*/
    public void addHorario(Horario h){
        this.horarios.add(h);
    }
    
    public void deleteHorario(int i){
        this.horarios.remove(i);
    }
    
    /*Esta función nos devuelve los turnos disponibles (sin Paciente)*/
    public ArrayList<Turno> getTurnosDisponibles(){
        ArrayList<Turno> aux = new ArrayList();
        for (int i = 0; i < this.turnos.size(); i++) {
            if (this.turnos.get(i).getPaciente() == null) {
                aux.add(this.turnos.get(i));
            }
        }
        return aux;
    }
    
    /*Método toString*/
    @Override
    public String toString(){
        String a = "AGENDA: " + this.id + "\n Esta es la agenda del Odontólogo: " + this.horarios.get(0).getOdontologo().apellido + " " + this.horarios.get(0).getOdontologo().nombre + 
                ". \n Sus horarios son de: " + this.horarios.get(0).getHoraInicio() + " a " + this.horarios.get(0).getHoraFin() + ".";
        return a;
    }
}

