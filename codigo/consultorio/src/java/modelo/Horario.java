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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }
    
    

    
    
    
    
}
