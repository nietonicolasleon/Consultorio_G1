
<%@include file="utils/header.jsp" %>
<%@include file="utils/headerMenu.jsp" %>
<%@page import="modelo.*" %>



<div class="container mt-5">
    <%
        Paciente bddPaciente = (Paciente)request.getAttribute("bddPaciente");
       //cargo y vaido que este registrado
        if(bddPaciente == null){
            response.sendRedirect("/pages/registro.jsp");
        }
       

    %>
        <div class="containes mt-2 cont-cli">
            <i class="fa-solid fa-user"></i>
            <div class="cont">
                <%= bddPaciente.getNombre() %>
            </div>
            <div class="cont">
                <%=bddPaciente.getApellido()%>
            </div>
            <div class="cont">
                <%=bddPaciente.getDni()%>
            </div>
            <div class="cont">
                <%=bddPaciente.getMail()%>
            </div>
        </div>
        <div class="container mt-4">
            <%@include file="utils/tablaTurnos.jsp"%>
        </div>
           
    
</div>
<div class="container">
   
</div>

<%@include file="utils/footer.jsp" %>