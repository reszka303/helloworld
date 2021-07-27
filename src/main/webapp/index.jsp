<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>®eszkaCzat</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
    <form action="chat" method="post">
        <fieldset id="header">
            <h1>Witaj na czacie ®eszki!</h1>
            <p>Poniżej widzisz historię konwersacji, możesz do niej dołączyć</p>
        </fieldset>
        <fieldset>
            <ul>
                <c:if test="${empty listChat}">
                        <p>Nie przesłano jeszcze żadnej wiadomości. Rozpocznij konwersację</p>
                </c:if>
                    <c:if test="${not empty listChat}">
                        <c:forEach items="${listChat}" var="chat">
                            <li><c:out value="${chat}"/></li>
                        </c:forEach>
                    </c:if>
            </ul>
            <textarea id="message" name="messageServlet" placeholder="Twoja wiadomość" rows="5" required></textarea>
            <input id="nickname" type="text" name="nicknameServlet" placeholder="Twoja nazwa" required>
            <input id="send" type="submit" value="Wyślij">
        </fieldset>
    </form>
    </body>
</html>

