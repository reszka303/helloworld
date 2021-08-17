<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Kalkulator</title>
    </head>
    <body>
    <h2>Kalkulator</h2>
        <form action="${pageContext.request.contextPath}/calculator" method="post">
            <fieldset>
                <legend>Wprowadź liczby i wybierz operator</legend>
                <input type="number" name="first">
                <select name="operator">
                    <option value="+">+</option>
                    <option value="-">-</option>
                    <option value="*">*</option>
                    <option value="/">/</option>
                </select>
                <input type="number" name="second">
            </fieldset>
            <button type="submit">Oblicz</button>
            <p><a href="${pageContext.request.contextPath}/logout">Wyloguj się</a></p>
        </form>
    </body>
</html>
