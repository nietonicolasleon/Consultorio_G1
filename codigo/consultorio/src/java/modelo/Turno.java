
package modelo;

import java.time.LocalDate;

public class Turno {
    private int id;
    private boolean tratamiento;
    private Paciente paciente;
    private LocalDate fecha;
    private Horario horario;

    public Turno(int id, boolean tratamiento, Paciente paciente, LocalDate fecha, Horario horario) {
        this.id = id;
        this.tratamiento = tratamiento;
        this.paciente = paciente;
        this.fecha=fecha;
        this.horario=horario;
    }

    public Turno(boolean tratamiento, Paciente paciente, LocalDate fecha, Horario horario) {
        this.tratamiento = tratamiento;
        this.paciente = paciente;
        this.fecha=fecha;
        this.horario=horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(boolean tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }


    

    
    
    @Override
    public String toString() {
        return  "fecha:"+this.fecha +"    horario:"+this.horario+"    id del turno:" + this.id + "\n Paciente:" + this.paciente  + "\n es tratamiento:" + this.tratamiento;
    }
    
    
    
    
    
}
