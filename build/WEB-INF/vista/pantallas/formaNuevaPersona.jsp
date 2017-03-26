<%-- Importamos lo necesario a usar en nuestra vista --%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<%-- Esta vista nos permite agregar a una nueva persona o Usuario --%>

    <br>
    <h1><fmt:message key="formaNuevaPersona.titulo" /></h1>

    <form id="forma" action="procesarRegistro.do" method="post">
      <div class="card horizontal">
      <div class="card-stacked">
      <div class="card-content">

            <tr>
                <td colspan="2">
                   <html:errors />
                </td>
            </tr>
            <div class="input-field">
              <i class="material-icons prefix">view_headline</i>
              <input type="text"
                     name="prefijo"
                     size="12"
                     maxlength="12"
                     value="${formaNuevaPersona.prefijo}" />
              <label for="icon_prefix">
                <fmt:message key="formaNuevaPersona.etiqueta.prefijo" />
              </label>
            </div>

            <div class="input-field">
              <i class="material-icons prefix">view_headline</i>
              <input type="text"
                     name="nombre"
                     size="50"
                     maxlength="100"
                      value="${formaNuevaPersona.nombre}" />
              <label for="icon_prefix">
              <fmt:message key="formaNuevaPersona.etiqueta.nombre" />
              </label>
            </div>

            <div class="input-field">
              <i class="material-icons prefix">view_headline</i>
              <input type="text"
                    name="apellidoPaterno"
                    size="50"
                    maxlength="100"
                     value="${formaNuevaPersona.apellidoPaterno}" />
              <label for="icon_prefix">
                <fmt:message key="formaNuevaPersona.etiqueta.apellidoPaterno" />
              </label>
            </div>

            <div class="input-field">
              <i class="material-icons prefix">view_headline</i>
              <input type="text"
                      name="apellidoMaterno"
                      size="50"
                      maxlength="100"
                     value="${formaNuevaPersona.apellidoMaterno}">
              <label for="icon_prefix">
                <fmt:message key="formaNuevaPersona.etiqueta.apellidoMaterno" />
              </label>
            </div>


            <div class="input-field">
              <i class="material-icons prefix">view_headline</i>
              <input type="text"
                      name="nombreUsuario"
                      size="50"
                      maxlength="100"
                      value="${formaNuevaPersona.nombreUsuario}" />
              <label for="icon_prefix">
                <fmt:message key="formaNuevaPersona.etiqueta.nombreUsuario" />
              </label>
            </div>


            <div class="input-field">
              <i class="material-icons prefix">view_headline</i>
              <input type="password"
                      name="claveAcceso"
                      size="50"
                      maxlength="100"
                      value="${formaNuevaPersona.claveAcceso}" />
              <label for="icon_prefix">
                <fmt:message key="formaNuevaPersona.etiqueta.claveAcceso" />
              </label>
            </div>

            <div class="input-field">
              <i class="material-icons prefix">view_headline</i>
              <input type="password"
                      name="claveAccesoConfirmacion"
                      size="50"
                      maxlength="100"
                      value="${formaNuevaPersona.claveAccesoConfirmacion}" />
              <label for="icon_prefix">
                <fmt:message key="formaNuevaPersona.etiqueta.claveAccesoConfirmacion" />
              </label>
            </div>

            <input class="waves-effect waves-light btn" type="submit"
            name="submit"
            value="Agregar"/>

          </div>
          </div>
          </div>

    </form>
