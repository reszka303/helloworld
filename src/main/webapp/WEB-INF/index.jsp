<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pl">
    <head>
        <title>Księga gości</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
    </head>
    <body>
    <main>
        <section class="form">
            <h1>Księga gości</h1>
            <form method="post">
                <fieldset>
                    <legend>Zostaw po sobie ślad</legend>
                    <label>
                        Twoja nazwa
                        <input name="author" placeholder="Jan Kowalski">
                    </label>
                    <label for="content">Treść wiadomości</label>
                    <textarea name="message" placeholder="Zacznij pisać..." id="content" rows="5"></textarea>
                    <button>Wyślij</button>
                </fieldset>
            </form>
        </section>
        <c:if test="${not empty requestScope.entries}">
            <section class="entries">
                <h2>Wasze wpisy (${requestScope.entries.size()})</h2>
                <c:forEach var="entry" items="${requestScope.entries}">
                    <div class="entry">
                        <h3><c:out value="Autor: ${entry.author}"/></h3>
                        <p><c:out value="${entry.message}"/></p>
                    </div>
                </c:forEach>
            </section>
        </c:if>
    </main>
    </body>
</html>
