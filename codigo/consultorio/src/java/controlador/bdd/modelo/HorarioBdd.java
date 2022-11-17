package controlador.bdd.modelo;

import java.sql.Time;

public class HorarioBdd{
    private int idOdontologo;
    private int diaSemana;
    private Time  horaInicio, horaFin;

    public HorarioBdd(int idOdontologo, int diaSemana, Time horaInicio, Time horaFin) {
        this.idOdontologo = idOdontologo;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }


    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public int getIdOdontologo() {
        return idOdontologo;
    }

    public void setIdOdontologo(int idOdontologo) {
        this.idOdontologo = idOdontologo;
    }

    public int  getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    @Override
    public String toString() {
        return "Horario{" + "idOdontologo=" + idOdontologo + ", diaSemana=" + diaSemana + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + '}';
    }
    
    
       
    

    
    
    
    
}
