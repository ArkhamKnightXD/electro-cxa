
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
<!--Aqui agregare la imagen de fondo cuando tenga una decente para los formularios -->
<body background="../../pictures/">


<!--Cuando presione submit se ejecutara el accion especificado ahi que a su vez me creara un usuario y no hay necesidad
 de agregar los parametros a la url ya que el controlador obtiene los parametros mediante el name especificados en los input-->
<form method="post" action="/alquiler/crear/">
    <div class="row">

        <div class="col-lg-5 col-sm-5 col-md-5 col-xs-12">

            <div class="form-group">
                <label for="idCliente">Cliente</label>
                <select name="idCliente" class="form-control" id="idCliente">
                    <#list clientes as cliente >
                    <option value="${cliente.id}">${cliente.nombre}</option>
                    </#list>
                </select>
            </div>
        </div>



        <div class="col-lg-5 col-sm-5 col-md-5 col-xs-12">

            <div class="form-group">
                <label for="idEquipo">Equipo a alquilar</label>
                <select name="idEquipo" class="form-control" id="idEquipo">
                    <#list equipos as equipo >
                        <option value="${equipo.id}">${equipo.nombre}</option>
                    </#list>
                </select>
            </div>
        </div>


        <div class="col-lg-6 col-sm-6 col-md-6 col-xs-12">

            <div class="form-group">
                <label for="fecha">Fecha del alquiler</label>
                <input type="date" name="fecha" class="form-control"  placeholder="fecha...">
            </div>

        </div>


        <div class="col-lg-6 col-sm-6 col-md-6 col-xs-12">

            <div class="form-group">
                <label for="fechaEntrega">Fecha de entrega</label>
                <input type="date" name="fechaEntrega" class="form-control" placeholder="fechaEntrega...">
            </div>

        </div>



        <div class="col-lg-6 col-sm-6 col-md-6 col-xs-12">

            <div class="form-group">
                <!--Cuando presion el submit esto indica que se activara el action ubicado en el inicio del  form -->
                <button class="btn btn-primary" type="submit">Guardar</button>
                <a class="btn btn-danger" href="/alquiler/" role="button">Cancelar</a>
            </div>

        </div>



    </div>

</form>



</body>
</html>

