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
  <fmt:message key="formaListadoCriticaes.titulo" />
</h1>




 <div class="fixed-action-btn">
    <a href="solicitarRegistroCritica.do" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
  </div>

 <c:forEach var="critica" items="${formaListadoCriticaes.criticaes}">


      <div class="card horizontal">
        <div class="card-image">
          <img style="height: 100%; width: 100%;" src="${critica.nivel + ".png"}">
          <span class="card-title">${critica.nombre}</span>

          <a href="procesarEliminarCritica.do?id=<c:out value="${critica.id}"/>" class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">delete</i></a>
          <a style="left: 50px;" class="btn-floating halfway-fab waves-effect waves-light blue"><i class="material-icons">mode_edit</i></a>


        </div>
        <div class="card-stacked">
        <div class="card-content">


          <form>

            <input class="waves-effect waves-light btn" type="button"
            value="Reset"
            onclickan="location.href='solicitarRegistroCritica.do'" />
            <input class="waves-effect waves-light btn" type="submit"
            name="org.apache.struts.taglib.html.CANCEL"
            value="cancelar"
            onclick="bCancel=true;">

              <div class="input-field">
                <i class="material-icons prefix">view_headline</i>
                <input type="text"
                       name="nombre"

                       maxlength="100"
                       value="${critica.nombre}">
                <label for="icon_prefix">
                  <fmt:message key="formaListadoCriticaes.etiqueta.nombre" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">description</i>
                <input type="text"
                       name="descripcion"

                       maxlength="100"
                       value="${critica.descripcion}">
                <label for="icon_telephone">
                  <fmt:message key="formaListadoCriticaes.etiqueta.descripcion" />
              </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">credit_card</i>
                <input type="number" step='any'
                       name="hotel"

                       maxlength="100"
                       value="${critica.hotel}">
                <label for="icon_prefix">
                  <fmt:message key="formaListadoCriticaes.etiqueta.hotel" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">today</i>
                <input type="text"
                       name="nivel"

                       maxlength="100"
                       value="${critica.nivel}">
                <label for="icon_telephone">
                  <fmt:message key="formaListadoCriticaes.etiqueta.nivel" />
                </label>
              </div>

          <input class="waves-effect waves-light btn" type="submit"
          name="submit"
          value="Agregar y terminar"/>
          <input class="waves-effect waves-light btn" type="submit"
          name="submit"
          value="Agregar y volver"
          onclick="forma.action='procesarRegistroCritica.do?volver=si'"/>


          </form>
        </div>
      </div>
      </div>

      </c:forEach>
