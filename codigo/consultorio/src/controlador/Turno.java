
package modelo;

import java.sql.Date;

public class Turno {
   
    
    private int idTurno,idPaciente,idOdontologo;
    private boolean isTratamiento;
    private Date fecha, hora;

    public Turno(int idTurno, int idPaciente, int idOdontologo, boolean isTratamiento, Date fecha, Date hora) {
        this.idTurno = idTurno;
        this.idPaciente = idPaciente;
        this.idOdontologo = idOdontologo;
        this.isTratamiento = isTratamiento;
        this.fecha = fecha;
        this.hora = hora;
    }
    
        public Turno(int idTurno, int idPaciente, int idOdontologo, boolean isTratamiento, java.util.Date fecha, java.util.Date hora) {
        this.idTurno = idTurno;
        this.idPaciente = idPaciente;
        this.idOdontologo = idOdontologo;
        this.isTratamiento = isTratamiento;
        this.fecha = (Date) fecha;
        this.hora = (Date) hora;
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

    public boolean isIsTratamiento() {
        return isTratamiento;
    }

    public void setIsTratamiento(boolean isTratamiento) {
        this.isTratamiento = isTratamiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }
    
    
    
    
    
}
