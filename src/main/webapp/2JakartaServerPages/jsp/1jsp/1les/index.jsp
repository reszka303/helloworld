<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--↓  Statyczny kod HTML ↓ --%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSP Test</title>
    </head>
    <body>
        <h1>To jest nagłówek</h1>
        <!--  Deklaracja HTML  -->
        <%--  Deklaracja JSP  --%>
        <%--  ↓↓ skryptlet pomiędzy tymi znacznikami zapisujemy kod Javy  --%>
        <%! String name; %>
        <!--  Inicjalizacja  -->
        <% name = "Jan Kowalski"; %>
        <!--  Wyrażenie  -->
        <h1>Witaj <%= name %> </h1>

        <% for (int i = 0; i < 5; i++) { %>
            <p>Paragraf numer <%= i %></p>
        <% } %>
    </body>
</html>
<%-- ↑ Statyczny kod HTML ↑ --%>
