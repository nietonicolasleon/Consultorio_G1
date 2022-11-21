package controlador.bdd.modelo;

/*Clase hecha por Wilver Guzmán, corregida por Nicolás Nieto*/
/*
    Las clases BDD son distintas a las clases Modelo
    Son la forma más simple de interacción con la BDD
    Clases como TratamientoBDD son luego cambiadas a su versión Modelo (por sus hijas)
*/
import java.sql.Time;

public class HorarioBdd{
    //Atributos
    private int idOdontologo;
    private int diaSemana;
    private Time  horaInicio, horaFin;

    /*Método Constructor*/
    public HorarioBdd(int idOdontologo, int diaSemana, Time horaInicio, Time horaFin) {
        this.idOdontologo = idOdontologo;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    /*Getters y Setters*/
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
    
    /*Método toString()*/
    @Override
    public String toString() {
        return "Horario{" + "idOdontologo=" + idOdontologo + ", diaSemana=" + diaSemana + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + '}';
    }
}
