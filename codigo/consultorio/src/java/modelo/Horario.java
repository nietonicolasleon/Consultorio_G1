package modelo;

import java.time.LocalTime;

public class Horario{
    
    private int id;
    private Odontologo odontologo;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private int diaSemana;

    public Horario(int id, Odontologo o, LocalTime hI, LocalTime hF, int diaSemana) {
        this.id = id;
        this.odontologo = o;
        this.horaInicio = hI;
        this.horaFin = hF;
        this.diaSemana = diaSemana;
    }

    public Horario(Odontologo o, LocalTime hI, LocalTime hF, int diaSemana) {
        this.odontologo = o;
        this.horaInicio = hI;
        this.horaFin = hF;
        this.diaSemana = diaSemana;
    }

    
    
    
    
}
