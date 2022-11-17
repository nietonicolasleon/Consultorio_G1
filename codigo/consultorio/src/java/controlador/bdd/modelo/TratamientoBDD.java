package controlador.bdd.modelo;

import java.sql.Time;

public class TratamientoBDD {
    private int idTratamiento;
    private Time duracion;
    private String nombre, datos;
    
    public TratamientoBDD(int id, String n, Time dur, String da){
        this.idTratamiento = id;
        this.nombre = n;
        this.duracion = dur;
        this.datos = da;
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Time getDuracion() {
        return duracion;
    }

    public void setDuracion(Time duracion) {
        this.duracion = duracion;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }
}
