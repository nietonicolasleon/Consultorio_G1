/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.bdd;

import datos.accesoDatos;
import modelo.Agenda;
import modelo.Odontologo;
import modelo.Paciente;

/**
 *
 * @author localuser
 */
public class BddPaciente {
//hacer bien la funcion 
    accesoDatos acc = new accesoDatos();
    public void addPaciente(Paciente paciente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public Paciente getPacienteById(int id) {
        for(Paciente paciente:acc.getPacientes()){
            if(paciente.getId() == id){
                return paciente;
            }
        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Paciente getPacienteByDni(String dni) {
         for(Paciente paciente:acc.getPacientes()){
            if(paciente.getDni().equals(dni)){
                return paciente;
            }
        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
