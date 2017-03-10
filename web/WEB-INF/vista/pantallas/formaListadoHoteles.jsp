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
  return confirm("¿Desea eliminar el estado '" + strHotelName + "'?")
}
</script>

<div class="fixed-action-btn">
  <a href="solicitarAgregarHotel.do" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
</div>
<div class="card">
  <table class="striped">
    <thead>
      <tr>
        <th data-field="nombre">
          <fmt:message key="formaListadoHoteles.etiqueta.nombre" />
        </th>
        <th data-field="descripcion">
          <fmt:message key="formaListadoHoteles.etiqueta.descripcion" />
        </th>
        <th data-field="precio">
          <fmt:message key="formaListadoHoteles.etiqueta.precio" />
        </th>
        <th data-field="horario">
          <fmt:message key="formaListadoHoteles.etiqueta.horario" />
        </th>
        <th data-field="estado">
          <fmt:message key="formaListadoHoteles.etiqueta.estado" />
        </th>
        <th data-field="pais">
          <fmt:message key="formaListadoHoteles.etiqueta.pais" />
        </th>
        <th data-field="direccion">
          <fmt:message key="formaListadoHoteles.etiqueta.direccion" />
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
