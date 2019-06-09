
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
            <!--Aqui agregare el texto de la pagina -->
            <strong>Agregar nueva familia</strong>
        </h1>

        <br>
    </section>


    <form method="post" class="form-horizontal" action="/familia/crear/">
        <div class="row">

            <div class="form-group">
                <label for="nombre" class="control-label col-md-3">Nombre:</label>

                <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                    <input type="text" name="nombre" class="form-control" placeholder="Nombre...">
                </div>

            </div>




            <div class="form-group">

                <label class="form-check-label col-md-2" for="subFamilia">Es subfamilia:</label>
                <div class="col-sm-4 col-md-4 col-lg-4 col-xs-4">
                    <input class="form-check-input" type="checkbox" name="subFamilia" id="subFamilia" onclick="cambiar()" />
                </div>
            </div>


            <!--Practicamente lo que debo de hacer aqui es que cuando el boton de subfamilia este en true
             se desplegara este boton y entonces me dejara seleccionar las distintas familias creadas para poder
             asociarlas con la subfamilia que estamos creando-->


            <div class="form-group">
                <label for="idFamilia" class="control-label col-md-3">Seleccione la familia a la que pertenece:</label>

                <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                    <select class="form-control" name="idFamilia" id="idFamilia">
                        <#list familias as familia>
                            <#if !familia.subFamilia>
                                <option value="${familia.id}">${familia.nombre}</option>
                            </#if>
                        </#list>
                    </select>
                </div>

            </div>


            <div class="form-group">
                <button class="btn btn-primary col-md-offset-3" type="submit">Guardar</button>
                <a class="btn btn-danger" href="/familia/" role="button">Cancelar</a>
            </div>


        </div>

    </form>

</div>




</body>
<!--script para mostrar la seleccion de familia cuando se haga click en el boton de si es una subfamilia -->
<script>
    var idFamilia = document.querySelector("#idFamilia");
    idFamilia.style.visibility = "collapse";

    function cambiar() {
        if (idFamilia.style.visibility === "collapse") {
            document.querySelector("#idFamilia").style.visibility = "visible";
        } else {
            document.querySelector("#idFamilia").style.visibility = "collapse";
        }
    }
</script>
</html>

