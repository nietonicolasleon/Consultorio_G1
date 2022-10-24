
package modelo;


public class Turno {
    private int id;
    private boolean tratamiento;
    private Paciente paciente;

    public Turno(int id, boolean tratamiento, Paciente paciente) {
        this.id = id;
        this.tratamiento = tratamiento;
        this.paciente = paciente;
    }

    public Turno(boolean tratamiento, Paciente paciente) {
        this.tratamiento = tratamiento;
        this.paciente = paciente;
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

    
    
    @Override
    public String toString() {
        return "Turno{" + "id=" + id + ", tratamiento=" + tratamiento + ", paciente=" + paciente + '}';
    }
    
    
    
    
    
}
