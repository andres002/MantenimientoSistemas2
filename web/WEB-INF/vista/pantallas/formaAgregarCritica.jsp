<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<style media="screen">
  div.card{
    margin: 50px;
  }
</style>


<h1>
  <fmt:message key="formaNuevoCritica.titulo" />
</h1>

<div class="card horizontal">
  <div class="card-image">

<div id="mapa" style="height: 100%; width:40vw;"></div>

  </div>
  <div class="card-stacked">
  <div class="card-content">

    <form id="forma" action="procesarRegistroCritica.do" method="post" enctype="multipart/form-data">


        <div class="input-field">
          <i class="material-icons prefix">view_headline</i>
          <input type="text"
                 name="nombre"

                 maxlength="100"
                 value="${formaNuevoCritica.nombre}">
          <label for="icon_prefix">
            <fmt:message key="formaNuevoCritica.etiqueta.nombre" />
          </label>
        </div>

        <div class="input-field">
          <i class="material-icons prefix">description</i>
          <input type="text"
                 name="descripcion"

                 maxlength="100"
                 value="${formaNuevoCritica.descripcion}">
          <label for="icon_telephone">
            <fmt:message key="formaNuevoCritica.etiqueta.descripcion" />
        </label>
        </div>

        <div class="input-field">
          <i class="material-icons prefix">credit_card</i>
          <input type="number" step='any'
                 name="hotel"

                 maxlength="100"
                 value="${formaNuevoCritica.hotel}">
          <label for="icon_prefix">
            <fmt:message key="formaNuevoCritica.etiqueta.hotel" />
          </label>
        </div>

        <div class="input-field">
          <i class="material-icons prefix">today</i>
          <input type="text"
                 name="nivel"

                 maxlength="100"
                 value="${formaNuevoCritica.nivel}">
          <label for="icon_telephone">
            <fmt:message key="formaNuevoCritica.etiqueta.nivel" />
          </label>
        </div>

    <input class="waves-effect waves-light btn" type="submit"
    name="submit"
    value="Agregar"/>


    </form>

  </div>
</div>
</div>
