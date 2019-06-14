
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
    <link rel="stylesheet" href="../../style/style.css">

    <!--Agregando date picker que viene incluido en bootstrap -->



</head>
<!--Aqui agregare la imagen de fondo cuando tenga una decente para los formularios -->
<body background="../../pictures/fondo.png">

<div class="container-form center">

    <section class="content-header">
        <h1 class="text-center">
            <!--Aqui agregare el texto de la pagina -->
            <strong>Agregar nuevo alquiler</strong>
        </h1>

        <br>
    </section>

    <form method="post" class="form-horizontal" action="/alquiler/crear/">
        <div class="row">


            <div class="form-group">
                <label for="idCliente" class="control-label col-md-3">Cliente</label>

                <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                    <select name="idCliente" class="form-control" id="idCliente">
                        <#list clientes as cliente >
                            <option value="${cliente.id}">${cliente.nombre}</option>
                        </#list>
                    </select>
                </div>

            </div>



            <div class="form-group">
                <label for="idEquipo" class="control-label col-md-3">Equipo a alquilar</label>

                <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                    <select multiple class="form-control" name="equipos">
                        <#list equipos as equipo>
                            <#if equipo.cantidadExistencia gt 0>
                                <option value="${equipo.id}" class="equipo-option" >${equipo.nombre} (${equipo.cantidadExistencia}) - $${equipo.costoAlquilerPorDia}/${dia}</option>
                            </#if>
                        </#list>
                    </select>
                </div>


            </div>


            <!--Por ahora validare las fechas con min y max luego intentare implementar la funcion de javascript que encontre
             Que te calcula el dia que es hoy y eso lo puedo establecer como valor min-->
            <div class="form-group">
                <label for="fecha" class="control-label col-md-3">Fecha:</label>

                <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                    <input type="date" name="fecha" min="2019-06-12" max="2019-08-29" required class="form-control" placeholder="Fecha...">
                </div>

            </div>


            <div class="form-group">
                <label for="fechaEntrega" class="control-label col-md-3">Fecha de entrega:</label>

                <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                    <input type="date" name="fechaEntrega" min="2019-06-12" max="2019-08-29" required class="form-control" placeholder="Fecha de entrega...">
                </div>

            </div>


                <div class="form-group">
                    <!--Cuando presion el submit esto indica que se activara el action ubicado en el inicio del  form -->
                    <button class="btn btn-primary col-md-offset-5" type="submit">Guardar</button>
                    <a class="btn btn-danger" href="/alquiler/" role="button">Cancelar</a>
                </div>


        </div>

    </form>

</div>

<!--Cuando presione submit se ejecutara el accion especificado ahi que a su vez me creara un usuario y no hay necesidad
 de agregar los parametros a la url ya que el controlador obtiene los parametros mediante el name especificados en los input-->

</body>
<!--Este script se encarga de que se puedan seleccionar multiple equipos, ademas de que se pueda visualizar la imagen -->
<script>
    $(document).ready(function() {
        $('.equipo-option').on('click', function() {
            $("#img-equipo").prop("src", $(this).data("img"));
        });
    });
</script>
</html>

