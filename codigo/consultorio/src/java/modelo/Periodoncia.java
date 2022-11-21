package modelo;

/*Hecha por Kiara Chunga*/
import java.time.LocalTime;

public class Periodoncia extends Tratamiento {
    //Atributos
   private String nivelSangrado;

   /*Método Constructor*/
    public Periodoncia(int id,String nT, LocalTime dT ,String nS ) {
        super(id,nT, dT);
        this.nivelSangrado = nS;
    }

    /*Getters y Setters*/
    public String getNivelSangrado() {
        return nivelSangrado;
    }

    public void setNivelSangrado(String nivelSangrado) {
        this.nivelSangrado = nivelSangrado;
    }

    @Override
    public String getNombreTratamiento() {
        return nombreTratamiento;
    }

    @Override
    public void setNombreTratamiento(String nombreTratamiento) {
        this.nombreTratamiento = nombreTratamiento;
    }

    @Override
    public LocalTime getDuracionTotal() {
        return duracionTotal;
    }

    @Override
    public void setDuracionTotal(LocalTime duracionTotal) {
        this.duracionTotal = duracionTotal;
    }
    
    /*Getters y Setters*/
    @Override
    public String toString() {
        return "Nivel de Sangrado: " + this.nivelSangrado;
    }
    
    
   
   
   
}
