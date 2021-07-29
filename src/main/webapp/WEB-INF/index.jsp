<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Strona główna</title>
    </head>
    <body>
        <%@ include file="segments/header.jspf"%>
        <main>
            <h1>Strona główna</h1>
            <p>Witamy na stronie głównej naszego sklepu</p>
            <p>Kupisz u nas m.in.:</p>
            <ul>
                <c:forEach var="product" items="${requestScope.products}">
                    <li><c:out value="${product}"/></li>
                </c:forEach>
            </ul>
        </main>
        <%@ include file="segments/footer.jspf"%>
    </body>
</html>