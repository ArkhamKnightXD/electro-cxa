<!DOCTYPE html>
<html>
<head>
    <title>Files</title>
</head>
<body>
<h1>Formulario para probar la subida de fotos</h1>

<form action="/file/upload" method="post" enctype="multipart/form-data">

<input type="file" name="files" multiple>

    <input type="submit" value="Upload Files"></input>

</form>

</body>
</html>