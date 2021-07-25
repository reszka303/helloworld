<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
    <head>
        <meta charset="UTF-8">
        <title>Centrum sterowania - Logowanie</title>
    </head>
    <body>
        <h2>Zaloguj się</h2>
        <form action="login" method="post">
            <div>
                <label for="usernameHTML">Nazwa użytkownika</label>
                <input id="usernameHTML" name="usernameServlet">
            </div>
            <div>
                <label for="passwordHTML">Hasło</label>
                <input id="passwordHTML" name="passwordServlet" type="password">
            </div>
            <input type="submit" value="Zaloguj">
        </form>
    </body>
</html>
