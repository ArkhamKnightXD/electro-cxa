
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
            <strong>Agregar nuevo usuario</strong>
        </h1>

        <br>
    </section>


    <form method="post" class="form-horizontal" action="/usuario/crear/">
        <div class="row">

            <div class="form-group">
                <label for="username" class="control-label col-md-3">Nombre de usuario:</label>

                <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                    <input type="text" name="username" class="form-control" placeholder="Nombre de usuario...">
                </div>

            </div>


            <div class="form-group">
                <label for="password" class="control-label col-md-3">Password:</label>

                <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                    <input type="password" name="password" class="form-control" placeholder="Password...">
                </div>

            </div>


            <div class="form-group">
                <label for="idRoles" class="control-label col-md-3">Rol del usuario</label>

                <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                    <select name="idRoles" class="form-control" id="idRoles" required>
                        <#list roles as rol >
                            <option value="${rol.id}">${rol.role}</option>
                        </#list>
                    </select>
                </div>

            </div>


            <div class="form-group">
                <button class="btn btn-primary col-md-offset-5" type="submit">Guardar</button>
                <a class="btn btn-danger" href="/usuario/" role="button">Cancelar</a>
            </div>


        </div>

    </form>

</div>

</body>
</html>

