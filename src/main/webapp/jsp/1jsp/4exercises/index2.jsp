<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Tablica osób z metodą</title>
        <link rel="stylesheet" href="style2.css">
    </head>
    <body>
    <%
        int capacity = 3;
    %>
    <%
        String[] persons = new String[capacity];
    %>
    <%!
        private String[] createArray(String[] persons) {
            persons[0] = "Leonardo DiCaprio";
            persons[1] = "Gregory Peck";
            persons[2] = "Henry Fonda";
            return persons;
        }
    %>
    <%
        persons = createArray(persons);
    %>
    <%
        for (int i = 0; i < capacity; i++) {
    %>
        <p id="person"> <%= persons[i] %> </p>
    <%
        }
    %>
    </body>
</html>




