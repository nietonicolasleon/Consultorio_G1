

<%@include file="header.jsp" %>
<%@include file="headerMenu.jsp" %>
<div class="container mt-5">
    <%
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String email = request.getParameter("email");
        boolean register = false;
        if(dni == null){
            %>
            <div class="d-block">
            <%@include file="utils/registro.jsp"%>
            </div>
            <%
        }else{
            %>
            <div class="d-none">
            <%@include file="utils/registro.jsp"%>
            </div>
            <%
        }
    %>
    
    <div class="containes mt-2 cont-cli">
        <div class="cont">

        </div>
    </div>
    
    <%//valido que este registrado y recien ahi muestro los turnos disponibles
        if(dni != null ){
            register = true;
            %>
                <div class="container mt-4">
                    <%@include file="utils/tablaTurnos.jsp"%>
                </div>
            <% 
        }
        %>
    
    
</div>
<div class="container">
   
</div>

<%@include file="footer.jsp" %>