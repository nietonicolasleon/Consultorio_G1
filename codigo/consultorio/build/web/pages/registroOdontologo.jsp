<%-- 
    Document   : registro
    Created on : 12 nov. 2022, 01:44:02
    Author     : dylan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="utils/headerMenu.jsp" %>
<div class="container mt-5">
    <div class="card card-body">
    <form action="registrarOdontologo"  method="post">
    <h4>LOGIN ODONTOLOGO</h4>
  <div class="mb-3">
    <label class="form-label">Matricula</label>
    <input type="text" name="matricula" class="form-control" required>
  </div>
  <button type="submit" class="btn btn-primary">Enviar</button>
</form>
</div>
    
</div>

<%@include file="utils/footer.jsp" %>