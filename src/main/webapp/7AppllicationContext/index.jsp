<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Notatnik</title>
    </head>
    <body>
        <h1>Notatnik</h1>
        <form action="save" method="post">
            <fieldset>
                <label for="noteId">Identyfikator notatki</label>
                <input id="noteId" name="noteId">
            </fieldset>
            <fieldset>
                <label for="noteContent">Treść notatki</label>
                <textarea id="noteContent" name="noteContent">Treść notatki</textarea>
            </fieldset>
            <fieldset>
                <label for="privateNote">Notatka prywatna</label>
                <input id="privateNote" type="radio" name="noteType" value="priv" checked>
                <label for="publicNote">Notatka publiczna</label>
                <input id="publicNote" type="radio" name="noteType" value="pub">
            </fieldset>
            <input type="submit" value="Zapisz">
        </form>
    </body>
</html>
