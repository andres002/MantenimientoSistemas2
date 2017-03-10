<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<style media="screen">
div.card{
  margin: 50px;
}
</style>

<script language="javascript" type="text/javascript">
function EliminarHotel(strHotelName){
  return confirm("¿Desea eliminar el Hotel '" + strHotelName + "'?")
}
</script>

<script type="text/javascript" src="js/jquery.tablesorter.js"></script>

<div class="fixed-action-btn">
  <a href="solicitarAgregarHotel.do" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
</div>
<div class="card">
  <table class="striped" id="hotel">
    <thead>
      <tr>
        <th data-field="nombre">
          <a class="waves-effect">
            <fmt:message key="formaListadoHoteles.etiqueta.nombre" />
          </a>
        </th>
        <th data-field="descripcion">
          <a class="waves-effect">
            <fmt:message key="formaListadoHoteles.etiqueta.descripcion" />
          </a>
        </th>
        <th data-field="precio">
          <a class="waves-effect">
            <fmt:message key="formaListadoHoteles.etiqueta.precio" />
          </a>
        </th>
        <th data-field="horario">
          <a class="waves-effect">
            <fmt:message key="formaListadoHoteles.etiqueta.horario" />
          </a>
        </th>
        <th data-field="estado">
          <a class="waves-effect">
            <fmt:message key="formaListadoHoteles.etiqueta.estado" />
          </a>
        </th>
        <th data-field="pais">
          <a class="waves-effect">
            <fmt:message key="formaListadoHoteles.etiqueta.pais" />
          </a>
        </th>
        <th data-field="direccion">
          <a class="waves-effect">
            <fmt:message key="formaListadoHoteles.etiqueta.direccion" />
          </a>
        </th>
        <th data-field="administracion">
          <fmt:message key="formaListadoHoteles.etiqueta.administracion" />
        </th>
      </tr>
    </thead>

    <tbody>
      <c:forEach var="hotel" items="${formaListadoHoteles.hoteles}">
        <tr>
          <td>${hotel.nombre}</td>
          <td>${hotel.descripcion}</td>
          <td>${hotel.precio}</td>
          <td>${hotel.horario}</td>
          <td>${hotel.estado}</td>
          <td>${hotel.pais}</td>
          <td>${hotel.direccion}</td>
          <td>
            <a href='solicitarModificarHotel.do?id=<c:out value="${hotel.id}"/>' class="waves-effect waves-light blue btn">
            <i class="material-icons left">mode_edit</i>
            <fmt:message key="formaListadoHoteles.etiqueta.modificar" />
          </a>
          <a href='procesarEliminarHotel.do?id=<c:out value="${hotel.id}"/>' class="waves-effect waves-light red btn" onClick="javascript: return EliminarHotel('<c:out value="${hotel.nombre}"/>')">
          <i class="material-icons left">delete</i>
          <fmt:message key="formaListadoHoteles.etiqueta.eliminar" />
        </a>
      </td>
    </tr>
  </c:forEach>
</tbody>
</table>
</div>

<script type="text/javascript">
$(document).ready(function()
  {
      $("#hotel").tablesorter();
  }
);
</script>
