
<%@include file="utils/headerMenu.jsp" %>
<%@page import="modelo.*" %>



<div class="container mt-4">
    
        <div class="container mt-4">
            <%@page import="java.util.ArrayList"%>
            <%@page import="datos.accesoDatos"%>

            <div class="container text-center">
                    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-2 g-lg-3">
                            <%
                            accesoDatos a1 = new accesoDatos();
        
                            for(Tratamiento  tratamiento : a1.getTratamientos() ){
                                
                                    %>
                                        <div class="col-6" >
                                            <div class="p-3 border bg-light rounded-4">
                                                
                                                    <h3><%= tratamiento.getNombreTratamiento() %></h3>
                                                    <p>  Duracion: <%= tratamiento.getDuracionTotal().toString() %></p>
                                                    <p><%= tratamiento.getDuracionTotal().toString() %></p>
                                                    <a href="reservarTurno?date=<%=tratamiento.getId()%>" class="btn btn-success"><i class="fa-solid fa-check"></i> Seleccionar</a>
        
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