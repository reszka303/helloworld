<%--
  Created by IntelliJ IDEA.
  User: Mateusz
  Date: 11.07.2021
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%--↓ dyrektywa ↓--%>
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

        <script src="../../../html/1welcome/script.js"></script>
    </body>
</html>
<%-- ↑ Statyczny kod HTML ↑ --%>
