<style media="screen">
  div.card{
    max-width: 40%;
    float: left;
    margin: 10px;
  }
</style>
  <div class="card">
    <div class="card-image">
      <img src="images/hotel003.jpg">
      <span class="card-title">Nombre Hotel</span>
      <a class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">add</i></a>
    </div>
    <div class="card-content">

      <div class="row">
        <form class="col s12">
          <div class="row">
            <div class="input-field col s6">
              <input id="last_name" type="text" class="validate">
              <label for="last_name">Nombre</label>
            </div>
            <div class="input-field col s6">
              <input id="last_name" type="text" class="validate">
              <label for="last_name">Precio</label>
            </div>
          </div>
          <div class="row">
              <div class="input-field col s6">
                <i class="material-icons prefix">account_circle</i>
                <input id="icon_prefix" type="text" class="validate">
                <label for="icon_prefix">Horario</label>
              </div>
              <div class="input-field col s6">
                <i class="material-icons prefix">phone</i>
                <input id="icon_telephone" type="tel" class="validate">
                <label for="icon_telephone">Telefono</label>
              </div>
            </div>
            <div class="row">
             <div class="input-field col s12">
               <textarea id="textarea1" class="materialize-textarea"></textarea>
               <label for="textarea1">Direccion</label>
             </div>
           </div>
           <div class="row">
              <div class="input-field col s6">
                <i class="material-icons prefix">mode_edit</i>
                <textarea id="icon_prefix2" class="materialize-textarea"></textarea>
                <label for="icon_prefix2">Descripcion</label>
              </div>
        </div>
        </form>
      </div>

    </div>
</div>
