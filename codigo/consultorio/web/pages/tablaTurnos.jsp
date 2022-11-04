<%-- 
    Document   : tablaTurnos
    Created on : 4 nov. 2022, 11:51:19
    Author     : localuser
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Agenda"%>
<table class="table table-striped table-hover">
  <thead class="table-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Fecha</th>
      <th scope="col">Hora</th>
      <th scope="col">Odontologo</th>
      <th scope="col">Acciones</th>
      
    </tr>
  </thead>
  <tbody class="table-group-divider">
      
    <%
        ArrayList<Agenda> agendas = new ArrayList();
        int cont = 1;
        
        for(Agenda a : agendas){
            int contTurno = 0;
            int contHorario = 0;
             for(cont){ ..... //falta completar otro for 
                
            %>
            <th scope="row"><%= cont++ %></th>
            <td><%= a.getTurnos().get(contTurno).getFecha() %></td>
            <td><%= a.getTurnos().get(contTurno++).getHoraIni() %></td>
            <td><%= a.getHorarios().get(contHorario).getOdontologo().getNombre() + " " 
                    + a.getHorarios().get(contHorario++).getOdontologo().getApellido() %></td>
            <td>
                <button type="button" class="btn btn-success"><i class="fa-solid fa-check"></i></button>
            </td>
                
            <%
                
        }
    %>
    <tr>
      <th scope="row">1</th>
      <td>04/11/2022</td>
      <td>12:00</td>
      <td>Roberto Mandela</td>
      <td>
          <button type="button" class="btn btn-success"><i class="fa-solid fa-check"></i></button>
      </td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>05/11/2022</td>
      <td>10:00</td>
      <td>Mirta Billarita</td>
      <td>
          <button type="button" class="btn btn-success"><i class="fa-solid fa-check"></i></button>
      </td>
    </tr>
    
  </tbody>
</table>

