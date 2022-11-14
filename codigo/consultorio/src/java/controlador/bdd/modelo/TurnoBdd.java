
package controlador.bdd.modelo;

import java.sql.Date;
import java.sql.Time;

public class TurnoBdd {
   
    
    private int idTurno,idPaciente,idOdontologo, idTratamiento;
    private Date fecha;
    private Time hora;

    public TurnoBdd(int idTurno, int idPaciente, int idOdontologo, int idT, Date fecha, Time hora) {
        this.idTurno = idTurno;
        this.idPaciente = idPaciente;
        this.idOdontologo = idOdontologo;
        this.idTratamiento = idT;
        this.fecha = fecha;
        this.hora = hora;
    }
    
    public TurnoBdd(int idTurno, int idPaciente, int idOdontologo, int idT, java.util.Date fecha, Time hora) {
        this.idTurno = idTurno;
        this.idPaciente = idPaciente;
        this.idOdontologo = idOdontologo;
        this.idTratamiento = idT;
        this.fecha = (Date) fecha;
        this.hora = hora;
    }

    

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdOdontologo() {
        return idOdontologo;
    }

    public void setIdOdontologo(int idOdontologo) {
        this.idOdontologo = idOdontologo;
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
    
    
    
    
    
}
