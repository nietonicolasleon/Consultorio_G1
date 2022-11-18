<%//Se incluyen el header, el tratamientoDAO y las clases Modelo %>
<%@page import="controlador.bdd.TratamientoDAO"%>
<%@include file="utils/headerMenu.jsp" %>
<%@page import="modelo.*" %>



<div class="container mt-4">
    
    <%
        //Se llama al atributo Paciente creado en el servlet. Se crea un paciente
        Paciente attPaciente = (Paciente)request.getAttribute("attPaciente");
       //cargo y valido que este registrado
        if(attPaciente.getDni() == null){
            response.sendRedirect("/consultorio/pages/registro.jsp");
        }
    %>
    <%//CÓDIGO html %>

    <div class="contenedortextoExplicativo ">
        <p class="contenedortextoExplicativo">Seleccione el turno deseado para <span class="font-weight-bold">reservarlo</span></p>
    </div>
    
    <%//Contenedor de Paciente %>
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
            <%//Importamos ArrayList y accesoDatos %>
            <%@page import="java.util.ArrayList"%>
            <%@page import="datos.accesoDatos"%>

            <div class="container text-center">
                    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-2 g-lg-3">
                            <%
                            TratamientoDAO tDAO = new TratamientoDAO();
                            
                            //Se recorren todos los tratamientos y se crea código HTML por cada tratamiento
                            //Se rellena cada tratamiento con la info.
                            for(Tratamiento  tratamiento : tDAO.seleccionar()){
                                
                                    %>
                                        <div class="col-6" >
                                            <div class="p-3 border bg-light rounded-4">
                                                
                                                    <h3><%= tratamiento.getNombreTratamiento() %></h3>
                                                    <p>  Duracion: <%= tratamiento.getDuracionTotal().toString() %></p>
                                                    <p><%= tratamiento.toString() %></p>
                                                    <%//El <a> actua como botón mandandonos al servlet reservarTratamiento pasando las id de Paciente y Tratamiento por GET %>
                                                    <a href="reservarTratamiento?date=<%=attPaciente.getId()%>,<%=tratamiento.getId()%>" class="btn btn-success"><i class="fa-solid fa-check"></i> Seleccionar</a>
        
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