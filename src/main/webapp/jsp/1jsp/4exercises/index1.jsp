<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Tablica osób</title>
        <link rel="stylesheet" href="style1.css">
    </head>
    <body>
        <% int capacity = 3; %>
        <% String[] persons = new String[capacity]; %>
        <% persons[0] = "Leonardo DiCaprio"; %>
        <% persons[1] = "Gregory Peck"; %>
        <% persons[2] = "Henry Fonda"; %>
        <% out.println("Zawartość tablicy 'persons' wyświetlona w pętli for :"); %>

        <% for (int i = 0; i < capacity; i++) { %>
            <p> <%= persons[i] %> </p>
        <% } %>

        <% out.println(); %>
        <% out.println("Zawartość tablicy 'persons' wyświetlona w klasie Arrays: "); %>
        <% out.println(Arrays.toString(persons)); %>
    </body>
</html>
