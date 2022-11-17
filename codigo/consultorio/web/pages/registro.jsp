<%-- 
    Document   : registro
    Created on : 12 nov. 2022, 01:44:02
    Author     : dylan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="utils/headerMenu.jsp" %>
<div class="container mt-5">
    <div class="card card-body">
    <form action="registrar"  method="post">
    <h4>REGISTRO</h4>
  <div class="mb-3">
    <label class="form-label">Nombre</label>
    <input type="text" name="nombre" class="form-control" required>
  </div>
  <div class="mb-3">
    <label class="form-label">Apellido</label>
    <input type="text" name="apellido" class="form-control" required>
  </div>
  <div class="mb-3">
    <label class="form-label">DNI</label>
    <input type="text" name="dni" class="form-control" required>
  </div>
  <div class="mb-3">
    <label class="form-label">Email</label>
    <input type="email" name="email" class="form-control" required>
  </div>
  <button type="submit" class="btn btn-primary">Enviar</button>
</form>
</div>
    
</div>

<%@include file="utils/footer.jsp" %>