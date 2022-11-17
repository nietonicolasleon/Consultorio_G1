
<%@page import="controlador.bdd.TratamientoDAO"%>
<%@include file="utils/headerMenu.jsp" %>
<%@page import="modelo.*" %>



<div class="container mt-4">
    <%
        Paciente attPaciente = (Paciente)request.getAttribute("attPaciente");
       //cargo y vaido que este registrado
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
        <div class="container mt-4">
            <%@page import="java.util.ArrayList"%>
            <%@page import="datos.accesoDatos"%>

            <div class="container text-center">
                    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-2 g-lg-3">
                            <%
                            TratamientoDAO tDAO = new TratamientoDAO();
                            
        
                            for(Tratamiento  tratamiento : tDAO.seleccionar()){
                                
                                    %>
                                        <div class="col-6" >
                                            <div class="p-3 border bg-light rounded-4">
                                                
                                                    <h3><%= tratamiento.getNombreTratamiento() %></h3>
                                                    <p>  Duracion: <%= tratamiento.getDuracionTotal().toString() %></p>
                                                    <p><%= tratamiento.toString() %></p>
                                                    <a href="reservarTurno?date=<%=attPaciente.getId()%>,<%=tratamiento.getId()%>" class="btn btn-success"><i class="fa-solid fa-check"></i> Seleccionar</a>
        
                                            </div>
                                        </div>
                                        
                                    <%
        
                            }
                        %>
                       
                     
                </div>
        </div>
       
           
    
</div>
<div class="container">
   
</div>

<%@include file="utils/footer.jsp" %>