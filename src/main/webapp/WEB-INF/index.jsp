<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
    <html lang="pl">
    <head>
        <meta charset="UTF-8">
        <title>Sekretna strona</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/secret" method="post">
            <label for="pass">Hasło</label>
            <input type="password" name="pass" id="pass">
            <button type="submit">Wyślij</button>
        </form>
    </body>
</html>
