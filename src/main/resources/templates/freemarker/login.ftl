<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form role="form" action="/login" method="post">
    <#-- Linea para controlar el ataque csrf-->
    <#if _csrf??> <#--validando que no sea nula, si lo es, está deshabilitado el csrf -->
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </#if>
    <div>
        <label for="username">Username</label>
        <input type="text" name="username" id="username" required autofocus>
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="password" id="password" required>
    </div>
    <div>
        <label for="remember-me">Remember me...</label>
        <input type="checkbox" name="remember-me" id="remember-me">
    </div>
    <button type="submit">Sign in</button>
</form>

<#if error.isPresent()>
    <p>usuario no existe....</p>
</#if>

</body>
</html>