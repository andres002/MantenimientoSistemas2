<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<style media="screen">
  div.card{
    margin: 50px;
  }
</style>


<h1>
  <fmt:message key="formaListadoCriticaes.titulo" />
</h1>


      <div class="card horizontal">
        <div class="card-image">
          <img style="height: 100%; width: 100%;" src="images/${formaModificarCritica.nivel}.png">
          <span class="card-title">${formaModificarCritica.nombre}</span>


        </div>
        <div class="card-stacked">
        <div class="card-content">


          <form id="forma" action="procesarModificarCritica.do" method="post" enctype="multipart/form-data">

              <div class="input-field">
                <i class="material-icons prefix">perm_identity</i>
                <input type="text"
                       name="nombre"

                       maxlength="100"
                       value="${formaModificarCritica.nombre}">
                <label for="icon_prefix">
                  <fmt:message key="formaListadoCriticaes.etiqueta.nombre" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">description</i>
                <input type="text"
                       name="descripcion"

                       maxlength="100"
                       value="${formaModificarCritica.descripcion}">
                <label for="icon_telephone">
                  <fmt:message key="formaListadoCriticaes.etiqueta.descripcion" />
              </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">view_headline</i>
                <input type="text" step='any'
                       name="hotel"

                       maxlength="100"
                       value="${formaModificarCritica.hotel}">
                <label for="icon_prefix">
                  <fmt:message key="formaListadoCriticaes.etiqueta.hotel" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">grade</i>
                <input type="text"
                       name="nivel"

                       maxlength="100"
                       value="${formaModificarCritica.nivel}">
                <label for="icon_telephone">
                  <fmt:message key="formaListadoCriticaes.etiqueta.nivel" />
                </label>
              </div>





          <input value="${formaModificarCritica.id}" name="id" style="display: none"/>

          <input class="waves-effect waves-light btn" type="submit"
          name="submit"
          value="Actualizar"/>


          </form>
        </div>
      </div>
      </div>
