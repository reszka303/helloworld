<%--<% String text = (String) request.getAttribute("nameFromHTML"); %>--%>

<%--<%!--%>
<%--    private String printIfNoNull(String text) {--%>
<%--        return text != null ? text : "";--%>
<%--    }--%>
<%--%>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pl">
    <head>
        <meta charset="utf-8">
        <title>Wspólny edytor</title>
        <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
        <script>
            tinymce.init({
                selector: '#mytextarea',
                height: '280'
            });
        </script>
    </head>
    <body>
        <div>
            <h1>Wspólny edytor</h1>
            <p>Twórz dokument ze wszystkimi innymi. Dodaj coś od siebie!</p>
        </div>
        <div>
            <h1>TinyMCE Quick Start Guide</h1>
            <form action="" method="post">
                <textarea id="mytextarea" name="nameFromHTML"><%= request.getAttribute("nameFromHTML") %></textarea>
                <button style="width: 100%; margin-top: 20px" type="submit">Zapisz zmiany</button>
            </form>
        </div>
    </body>
</html>



