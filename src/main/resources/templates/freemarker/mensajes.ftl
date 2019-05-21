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
<h1>${mensaje}</h1>

<!--Especifico esto como una ruta dinamica para que esta pagina pueda ser usadas por diferentes paginas -->
<a class="btn btn-danger" href="/${ruta}/" role="button">Volver atras</a>
</body>
</html>