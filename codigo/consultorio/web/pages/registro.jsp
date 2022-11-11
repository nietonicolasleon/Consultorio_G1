
<%@include file="header.jsp" %>
<%@include file="headerMenu.jsp"%>


<%@page import="controlador.servlets.registrar" %>

<div class="card card-body">
    <form action="registrar"  method="POST">
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
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>

<%@include file="footer.jsp" %>



