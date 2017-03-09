<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<style media="screen">
  div.card{
    margin: 50px;
  }
</style>

<h1>
  <fmt:message key="formaNuevoHotel.titulo" />
</h1>

        <div class="card-panel">

              <form >

                  <div class="input-field">
                    <i class="material-icons prefix">view_headline</i>
                    <input type="text"
                           name="nombre"

                           maxlength="100"
                           value="${formaNuevoHotel.nombre}">
                    <label for="icon_prefix">
                      <fmt:message key="formaNuevoHotel.etiqueta.nombre" />
                    </label>
                  </div>

                  <div class="input-field">
                    <i class="material-icons prefix">description</i>
                    <input type="text"
                           name="descripcion"

                           maxlength="100"
                           value="${formaNuevoHotel.descripcion}">
                    <label for="icon_telephone">
                      <fmt:message key="formaNuevoHotel.etiqueta.descripcion" />
                  </label>
                  </div>

                  <div class="input-field">
                    <i class="material-icons prefix">credit_card</i>
                    <input type="number" step='any'
                           name="precio"

                           maxlength="100"
                           value="${formaNuevoHotel.precio}">
                    <label for="icon_prefix">
                      <fmt:message key="formaNuevoHotel.etiqueta.precio" />
                    </label>
                  </div>

                  <div class="input-field">
                    <i class="material-icons prefix">phone</i>
                    <input type="text"
                           name="horario"

                           maxlength="100"
                           value="${formaNuevoHotel.horario}">
                    <label for="icon_telephone">
                      <fmt:message key="formaNuevoHotel.etiqueta.horario" />
                    </label>
                  </div>

                  <div class="input-field">
                    <i class="material-icons prefix">account_circle</i>
                    <input type="text"
                          id="estado"
                          name="estado"

                           maxlength="100"
                           value="${formaNuevoHotel.estado}">
                    <label for="icon_prefix">
                      <fmt:message key="formaNuevoHotel.etiqueta.estado" />
                    </label>
                  </div>

                  <div class="input-field">
                    <i class="material-icons prefix">phone</i>
                    <input type="text"
                          id="pais"
                          name="pais"

                           maxlength="100"
                           value="${formaNuevoHotel.pais}">
                    <label for="icon_telephone">
                      <fmt:message key="formaNuevoHotel.etiqueta.pais" />
                    </label>
                  </div>

                  <div class="input-field">
                    <i class="material-icons prefix">account_circle</i>
                    <input type="text"
                          id="direccion"
                          name="direccion"

                           maxlength="100"
                           value="${formaNuevoHotel.direccion}">
                    <label for="icon_prefix">
                      <fmt:message key="formaNuevoHotel.etiqueta.direccion" />
                    </label>
                  </div>

                  <div class="file-field input-field">
      <div class="btn">
        <span>
          <fmt:message key="formaNuevoHotel.etiqueta.foto" />
        </span>
        <input type="file"
               name="imagen"
               value="${formaNuevoHotel.imagen}">
      </div>
      <div class="file-path-wrapper">
        <input class="file-path validate" type="text">
      </div>
    </div>

              </form>

        </div>
