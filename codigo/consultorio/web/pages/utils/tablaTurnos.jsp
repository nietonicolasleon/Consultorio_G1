<%-- 
    Document   : tablaTurnos
    Created on : 4 nov. 2022, 11:51:19
    Author     : localuser
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.*"%>
<%@page import="datos.accesoDatos"%>

<table class="table table-striped table-hover">
  <thead class="table-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Fecha</th>
      <th scope="col">Hora</th>
      <th scope="col">Odontologo</th>
      <th scope="col">Reservar</th>
      
    </tr>
  </thead>
  <tbody class="table-group-divider">
      
    <%
        accesoDatos a1 = new accesoDatos();
        ArrayList<Agenda> agendas = a1.getAgendas();
        int cont = 1;
        
        for(Agenda a : agendas){
            Odontologo odontologo = a.getHorarios().get(0).getOdontologo();
            for(Turno turno : a.getTurnos()){
                %>
                    <tr>
                        <th scope="row"><%= cont++ %></th>
                        <td><%= turno.getFecha() %></td> <!--fecha -->
                        <td><%= turno.getHoraIni() %></td> <!--hora inicio -->
                        <td><%= odontologo.getNombre() + " " + odontologo.getApellido() %></td> <!--nombre odontologo -->
                        <td>
                            <button type="button" class="btn btn-success"><i class="fa-solid fa-check"></i></button>
                        </td>
                    <tr>
                <%
            }
                 
        }
    %>
    
  </tbody>
</table>

