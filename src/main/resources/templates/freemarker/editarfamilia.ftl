
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
<form method="post" action="/cliente/editar/?id=${cliente.id}">
    <div class="row">

        <div class="col-lg-6 col-sm-6 col-md-6 col-xs-12">

            <div class="form-group">
                <label for="nombre">Nombre</label>
                <input type="text" name="nombre" value="${familia.nombre}" class="form-control" placeholder="Nombre...">
            </div>
        </div>



        <div class="col-lg-6 col-sm-6 col-md-6 col-xs-12">

            <div class="form-group">
                <!--Cuando presion el submit esto indica que se activara el action ubicado en el inicio del  form -->
                <button class="btn btn-primary" type="submit">Guardar</button>
                <a class="btn btn-danger" href="/cliente/" role="button">Cancelar</a>
            </div>

        </div>



    </div>

</form>



</body>
</html>

