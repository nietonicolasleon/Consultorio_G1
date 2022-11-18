package modelo;

/*Hecha por Kiara Chunga*/
import java.time.LocalTime;

public class Periodoncia extends Tratamiento {
   private String nivelSangrado;

    public Periodoncia(int id,String nT, LocalTime dT ,String nS ) {
        super(id,nT, dT);
        this.nivelSangrado = nS;
    }

    public String getNivelSangrado() {
        return nivelSangrado;
    }

    public void setNivelSangrado(String nivelSangrado) {
        this.nivelSangrado = nivelSangrado;
    }

    public String getNombreTratamiento() {
        return nombreTratamiento;
    }

    public void setNombreTratamiento(String nombreTratamiento) {
        this.nombreTratamiento = nombreTratamiento;
    }

    public LocalTime getDuracionTotal() {
        return duracionTotal;
    }

    public void setDuracionTotal(LocalTime duracionTotal) {
        this.duracionTotal = duracionTotal;
    }
    
    

    @Override
    public String toString() {
        return "Nivel de Sangrado: " + this.nivelSangrado;
    }
    
    
   
   
   
}
