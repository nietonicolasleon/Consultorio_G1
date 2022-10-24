package modelo;

import java.util.Date;

public class Agenda {
    
    private int id;
    private Odontologo odontologo;
    private Turno turno;
    private Date fecha;

    public Agenda(int id, Turno turno) {
        this.id = id;
        this.turno = turno;
    }
    
    
    
}
