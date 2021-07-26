<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Expression Language</title>
    </head>
    <body>
        <form action="" method="post">
            <fieldset>
                <div>
                    <label for="firstName">Imię</label>
                    <input id="firstName" name="firstNameServlet" >
                </div>
                <div>
                    <label for="lastName">Nazwisko</label>
                    <input id="lastName" name="lastNameServlet">
                </div>
                <div>
                    <label for="age">Wiek</label>
                    <input id="age" type="number" name="ageServlet">
                </div>
            </fieldset>
            <input type="submit" value="Wyślij">
        </form>
        <%
            if(request.getAttribute("person") != null) {
        %>
        <h2>Cześć ${person.firstName}</h2>
        <p style="color: ${person.age gt 18 ? 'green' : 'red'}">
        ${person.age gt 18 ? 'Jesteś pełnoletni' : 'Jesteś nieletni'}
        </p>
        <p>Informacje o Twojej przeglądarce: ${header['user-agent']}</p>
        <%
            }
        %>
    </body>
</html>
