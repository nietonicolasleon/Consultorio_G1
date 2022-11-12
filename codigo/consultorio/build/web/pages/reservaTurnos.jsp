
<%@include file="utils/header.jsp" %>
<%@include file="utils/headerMenu.jsp" %>
<%@page import="modelo.*" %>



<div class="container mt-4">
    <%
        Paciente attPaciente = (Paciente)request.getAttribute("attPaciente");
       //cargo y vaido que este registrado
        if(attPaciente == null){
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
            <%@include file="utils/tablaTurnos.jsp"%>
        </div>
       
           
    
</div>
<div class="container">
   
</div>

<%@include file="utils/footer.jsp" %>