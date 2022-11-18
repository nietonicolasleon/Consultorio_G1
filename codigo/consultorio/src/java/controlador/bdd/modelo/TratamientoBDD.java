package controlador.bdd.modelo;

/*Clase hecha por Nicolás Nieto*/
/*
    Las clases BDD son distintas a las clases Modelo
    Son la forma más simple de interacción con la BDD
    Clases como TratamientoBDD son luego cambiadas a su versión Modelo (por sus hijas)
*/
import java.sql.Time;

public class TratamientoBDD {
    //Atributos
    private int idTratamiento;
    private Time duracion;
    private String nombre, datos;
    
    /*Método Constructor*/
    public TratamientoBDD(int id, String n, Time dur, String da){
        this.idTratamiento = id;
        this.nombre = n;
        this.duracion = dur;
        this.datos = da;
    }

    /*Getters y Setters*/
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
