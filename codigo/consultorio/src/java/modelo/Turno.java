package modelo;

/*Hecha por Kiara Chunga*/
import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {
    //Atributos
    private int id;
    private Tratamiento tratamiento;
    private Paciente paciente;
    private LocalDate fecha;
    private LocalTime duracion;
    private LocalTime horaIni;

    /*Métodos Constructores*/
    public Turno(int id, Tratamiento t, Paciente p, LocalDate f, LocalTime d, LocalTime hI) {
        this.id = id;
        this.tratamiento = t;
        this.paciente = p;
        this.fecha=f;
        this.duracion=d;
        this.horaIni=hI;
    }

    public Turno(Tratamiento t, Paciente p, LocalDate f, LocalTime d, LocalTime hI) {
        this.tratamiento = t;
        this.paciente = p;
        this.fecha=f;
        this.duracion=d;
        this.horaIni=hI;
    }
    
    public Turno(Tratamiento t, LocalDate f, LocalTime d, LocalTime hI){
        this.tratamiento=t;
        this.fecha=f;
        this.duracion=d;
        this.horaIni=hI;
    }

    /*Getters y Setters*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
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

    public LocalTime getDuracion() {
        return duracion;
    }

    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }

    public LocalTime getHoraIni() {
        return horaIni;
    }

    public void setHoraIni(LocalTime horaIni) {
        this.horaIni = horaIni;
    }

    /*Método toString*/
    @Override
    public String toString() {
        return  "tratamiento: \n" + this.tratamiento.getNombreTratamiento() + "\n Paciente:" + this.paciente.nombre + "\n Fecha:" + this.fecha + "horaIni=" + this.horaIni+ "\n Duracion: " + this.duracion  ;
    }

    

    
    
    
    
}
