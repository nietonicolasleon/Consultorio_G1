<%//Se incluye el header y las clases de modelo %>

<%@include file="utils/headerMenu.jsp" %>
<%@page import="modelo.*" %>

<%-- 
    Document   : registro
    Created on : 12 nov. 2022, 01:44:02
    Author     : dylan
--%>


<div class="container mt-4">
    <%
        Paciente attPaciente = (Paciente)request.getAttribute("attPaciente");
        Tratamiento attTratamiento = (Tratamiento)request.getAttribute("attTratamiento");
       //cargo y valido que este registrado
        if(attPaciente.getDni() == null){
            response.sendRedirect("/consultorio/pages/registro.jsp");
        }
        
    %>
    <div class="contenedortextoExplicativo ">
        <p class="contenedortextoExplicativo">Seleccione el turno deseado para <span class="font-weight-bold">reservarlo</span></p>
    </div>
    <div class="containes mt-1 cont-cli">
            <i class="fa-solid fa-user"></i>
            <div class="cont">
                <%= attPaciente.getNombre() %>
            </div>
            <div class="cont">
                <%=attPaciente.getApellido()%>
            </div>
            <div class="cont">
                <%=attPaciente.getDni()%>
            </div>
            <div class="cont">
                <%=attPaciente.getMail()%>
            </div>
    </div>
    <div class="containes mt-1 cont-cli contenedortextoExplicativo ">
        <p class="contenedortextoExplicativo"><%=attTratamiento.getNombreTratamiento()%> - <%=attTratamiento.getDuracionTotal()%></p>
    </div>
        <div class="container mt-4">
            <%@page import="java.util.ArrayList"%>
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
                    //Por cada agenda, se obtienen sus turnos y por cada uno de ellos, los datos de la fecha, hora y el odontologo
                    //Se crean entradas en una tabla HTML con dichos datos
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
                                        <a href="reservarTurno?date=<%= attPaciente.getId()%>,<%= attTratamiento.getId()%>,<%=turno.getId()%>,<%=odontologo.getId()%>" class="btn btn-success"><i class="fa-solid fa-check"></i></a>
                                    </td>
                                <tr>
                            <%
                        }

                    }
                %>

              </tbody>
            </table>
        </div>
       
           
    
</div>
<div class="container">
   
</div>

<%@include file="utils/footer.jsp" %>