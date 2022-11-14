package controlador.bdd.modelo;

import java.sql.Date;

public class HorarioBdd{
    private int idOdontologo;
    private int diaSemana;
    private Date  horaInicio, horaFin;

    public HorarioBdd(int idOdontologo, int diaSemana, Date horaInicio, Date horaFin) {
        this.idOdontologo = idOdontologo;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }


    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
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

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    @Override
    public String toString() {
        return "Horario{" + "idOdontologo=" + idOdontologo + ", diaSemana=" + diaSemana + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + '}';
    }
    
    
       
    

    
    
    
    
}
