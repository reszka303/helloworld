<%@ page import="pl.javastart.GApplicationContext_7.applicationContext1.Note" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Twoja notatka</title>
    </head>
    <body>
    <%
        String note = (String) request.getAttribute("note");
        if (note != null) {
    %>
        <h2>Twoja notatka</h2>
        <p><%=note%></p>
    <%
        } else {
    %>
        <h2>Brak notatki o takim ID.</h2>
    <%
        }
    %>
    </body>
</html>
