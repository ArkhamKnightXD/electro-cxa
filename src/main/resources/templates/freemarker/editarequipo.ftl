
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <title> ${titulo}</title>

    <link rel="stylesheet" href="../../bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="../../bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../../dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
          page. However, you can choose any other skin. Make sure you
          apply the skin class to the body tag so the changes take effect. -->
    <link rel="stylesheet" href="../../dist/css/skins/skin-blue.min.css">

</head>
<body>


<!--Cuando presione submit se ejecutara el accion especificado ahi que a su vez me creara un usuario y no hay necesidad
 de agregar los parametros a la url ya que el controlador obtiene los parametros mediante el name especificados en los input-->
<form method="post" action="/equipo/editar/?id=${equipo.id}">
    <div class="row">

        <div class="col-lg-6 col-sm-6 col-md-6 col-xs-12">

            <div class="form-group">
                <label for="nombre">Nombre</label>
                <input type="text" name="nombre" value="${equipo.nombre}" class="form-control" placeholder="Nombre...">
            </div>
        </div>



        <div class="col-lg-6 col-sm-6 col-md-6 col-xs-12">

            <div class="form-group">
                <label for="marca">Marca</label>
                <input type="text" name="marca" value="${equipo.marca}"  class="form-control" placeholder="marca...">
            </div>
        </div>



        <div class="col-lg-6 col-sm-6 col-md-6 col-xs-12">

            <div class="form-group">
                <label for="cantidadExistencia">Cantidad en existencia</label>
                <input type="number" name="cantidadExistencia" value="${equipo.cantidadExistencia}" class="form-control"  placeholder="Cantidad en existencia...">
            </div>

        </div>



        <div class="col-lg-6 col-sm-6 col-md-6 col-xs-12">

            <div class="form-group">
                <label for="costoAlquilerPorDia">Costo del alquiler</label>
                <input type="number" name="costoAlquilerPorDia" value="${equipo.costoAlquilerPorDia}" class="form-control" placeholder="Costo del alquiler por dia...">
            </div>

        </div>


        <div class="col-lg-6 col-sm-6 col-md-6 col-xs-12">

            <div class="form-group">
                <label for="imagenEquipo">Foto</label>
                <input type="text" name="imagenEquipo" value="${equipo.imagenEquipo}" class="form-control" placeholder="Foto...">
            </div>

        </div>


        <div class="col-lg-6 col-sm-6 col-md-6 col-xs-12">

            <div class="form-group">
                <!--Cuando presion el submit esto indica que se activara el action ubicado en el inicio del  form -->
                <button class="btn btn-primary" type="submit">Guardar</button>
                <button class="btn btn-danger"><a href="/cliente/">Cancelar</a></button>
            </div>

        </div>



    </div>

</form>



</body>
</html>

