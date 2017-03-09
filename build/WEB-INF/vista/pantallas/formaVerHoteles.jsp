<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<style media="screen">
  div.card{
    margin: 50px;
  }
</style>

<form>
        <div class="input-field">
          <input id="search" type="search" required>
          <label class="label-icon" for="search"><i class="material-icons">search</i></label>
          <i class="material-icons">close</i>
        </div>
      </form>


<h1>
  <fmt:message key="formaListadoHoteles.titulo" />
</h1>




 <div class="fixed-action-btn">
    <a href="solicitarRegistroHotel.do" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
  </div>

 <c:forEach var="hotel" items="${formaListadoHoteles.hoteles}">


      <div class="card horizontal">
        <div class="card-image">
          <img src="${hotel.imagen}">
          <span class="card-title">${hotel.nombre}</span>

          <a href="procesarEliminarHotel.do?id=<c:out value="${hotel.id}"/>" class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">delete</i></a>
          <a style="left: 50px;" class="btn-floating halfway-fab waves-effect waves-light blue"><i class="material-icons">mode_edit</i></a>


        </div>
        <div class="card-stacked">
        <div class="card-content">
          <h5>
            <fmt:message key="formaListadoHoteles.etiqueta.precio" />
          </h5>
          <p>
            ${hotel.precio}
          </p>
          <h5>
            <fmt:message key="formaListadoHoteles.etiqueta.horario" />
          </h5>
          <p>
            ${hotel.horario}
          </p>
          <h5>
            <fmt:message key="formaListadoHoteles.etiqueta.estado" />
          </h5>
          <p>
            ${hotel.estado}
          </p>
          <h5>
            <fmt:message key="formaListadoHoteles.etiqueta.pais" />
          </h5>
          <p>
            ${hotel.pais}
          </p>
          <h5>
            <fmt:message key="formaListadoHoteles.etiqueta.direccion" />
          </h5>
          <p>
            ${hotel.direccion}
          </p>
        </div>
      </div>
      </div>

      </c:forEach>
