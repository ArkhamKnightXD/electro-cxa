
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

<div class="container">

    <section class="content-header">
        <h1 class="text-center">
            <strong>Editar cliente</strong>
        </h1>

        <br>
    </section>

    <!--En action mando el id de cliente al controlador que maneja la ruta /cliente/editar -->
    <form method="post" class="form-horizontal" action="/cliente/editar/?id=${cliente.id}" enctype="multipart/form-data">
        <div class="row">

            <!--En value indico el valor que tiene este cliente antes de ser editados -->
            <div class="form-group">
                <label for="nombre" class="control-label col-md-3">Nombre:</label>

                <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                    <input type="text" name="nombre" value="${cliente.nombre}" class="form-control" placeholder="Nombre...">
                </div>

            </div>


            <div class="form-group">
                <label for="apellido" class="control-label col-md-3">Apellido:</label>

                <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                    <input type="text" name="apellido" value="${cliente.apellido}" class="form-control" placeholder="Apellido...">
                </div>

            </div>



            <div class="form-group">
                <label for="cedula" class="control-label col-md-3">Cedula:</label>

                <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                    <input type="text" name="cedula" value="${cliente.cedula}" class="form-control" placeholder="Cedula...">
                </div>

            </div>




            <div class="form-group">
                <label for="telefono" class="control-label col-md-3">Telefono:</label>

                <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                    <input type="text" name="telefono" value="${cliente.telefono}" class="form-control" placeholder="Telefono...">
                </div>

            </div>


            <div class="form-group">
                <label for="direccion" class="control-label col-md-3">Direccion:</label>

                <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                    <input type="text" name="direccion" value="${cliente.direccion}" class="form-control" placeholder="Direccion...">
                </div>

            </div>


            <div class="form-group">
                <label for="file" class="control-label col-md-3">Foto del cliente:</label>

                <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                    <input type="file" name="files" value="${cliente.foto}" class="form-control" placeholder="Foto del cliente...">
                </div>

            </div>



            <div class="form-group">
                <button class="btn btn-primary col-md-offset-5" type="submit">Guardar</button>
                <a class="btn btn-danger" href="/cliente/" role="button">Cancelar</a>
            </div>


        </div>

    </form>


</div>

</body>
</html>

