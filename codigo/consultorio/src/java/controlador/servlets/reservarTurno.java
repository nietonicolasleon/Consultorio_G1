/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dylan
 */
import controlador.bdd.*;
import controlador.bdd.modelo.TurnoBdd;
import java.sql.*;

import modelo.*;
public class reservarTurno extends HttpServlet {


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             //recupero TODOS los datos del get que vienen separados por , y los desestructuro utilizando el split
            String[] date = request.getParameter("date").split(",");
            int idPaciente = Integer.parseInt(date[0]);
            int idTratamiento = Integer.parseInt(date[1]);
            int idTurno = Integer.parseInt(date[2]);
            int idOdontologo = Integer.parseInt(date[3]);
            
            //creo el Turno solicitandolo desde la bdd
            BddTurnos bddTurnos = new BddTurnos();
            Turno attTurno = bddTurnos.getTurnoById(idTurno);
            
            //creo el Odontolog solicitandolo desde la bdd
            BddOdontologo bddOdontologo = new BddOdontologo();
            Odontologo attOdontologo = bddOdontologo.getOdontologoById(idOdontologo);
            
            //creo el Paciente solicitandolo desde la bdd
            PacienteDAO pDAO = new PacienteDAO();
            Paciente attPaciente = pDAO.getPacienteById(idPaciente);
            
            //creo el Tratamiento solicitandolo desde la bdd
            TratamientoDAO tDAO = new TratamientoDAO();
            Tratamiento attTratamiento = tDAO.getTratamientoById(idTratamiento);
            
            //ingresar aca codigo para guardar el turno y todos los datos 
            
            
             TurnoDAO turnoDAO = new TurnoDAO();
             Date fechaT = Date.valueOf(attTurno.getFecha()); //transformo la fecha desde LocalDate del turno al Date que usa SQL
             Time horaT = Time.valueOf(attTurno.getHoraIni()); //transformo la hora desde LocalTime del turno al Time que usa SQL
            
             TurnoBdd turnoBdd = new TurnoBdd(attTurno.getId(),attPaciente.getId(), attOdontologo.getId(), attTratamiento.getId(), fechaT, horaT);
             turnoDAO.actualizar(turnoBdd);
            
            
            //Creo el Turno solicitandolo desde la bdd para confirmar que se haya guardado correctamente
            
            
            Turno attTurnoConfirmado = turnoDAO.getTurnoById(attTurno.getId());
            
            
            //Creo el Odontologo asignado a ese turno solicitandolo desde la bdd utilizando el id del turno 
            /*
            Odontologo attOdontologoConfirmado = oDAO.getOdontologoByIdTurno(attTurno.getId());
            */
            
            
            // validacion
            String attmensaje = "ERROR AL REGISTRAR EL TURNO";
            if(attTurnoConfirmado.getPaciente().getId() == attPaciente.getId()){
                //se creo correctamente 
                attmensaje = "Se reservo exitosamente el turno";
            }
            
            //setea los atributos para recuperarlos en la patalla confirmacionReserva
            
            
             request.setAttribute("mensajeResultado", attmensaje);
             request.setAttribute("attTurno", attTurnoConfirmado);
             //request.setAttribute("attOdontologo", attOdontologoConfirmado);
             request.getRequestDispatcher("/pages/confirmacionReserva.jsp").forward(request, response);
            
           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
