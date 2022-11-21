/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servlets;


import controlador.bdd.PacienteDAO;
import controlador.bdd.TratamientoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;

/**
 *
 * @author localuser
 */
public class reservarTratamiento extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //recupero los datos del get que vienen separados por , y los desestructuro utilizando el split
            String[] date = request.getParameter("date").split(",");
            int idPaciente = Integer.parseInt(date[0]);
            int idTratamiento = Integer.parseInt(date[1]);
            
            //creo al paciente solicitandolo desde la bdd
            PacienteDAO pDAO = new PacienteDAO();
            Paciente attPaciente = pDAO.getPacienteById(idPaciente);
            
            //creo al Tratamiento solicitandolo desde la bdd
            TratamientoDAO tDAO = new TratamientoDAO();
            Tratamiento attTratamiento = tDAO.getTratamientoById(idTratamiento);
            
            //setea los atributos para recuperarlos en la patalla reservaTurnos
            request.setAttribute("attPaciente", attPaciente);
            request.setAttribute("attTratamiento", attTratamiento);
            request.getRequestDispatcher("/pages/reservaTurnos.jsp").forward(request, response);
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
