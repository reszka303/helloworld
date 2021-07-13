<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>JSP with Scriptlets</title>
    </head>
    <body>
        <h1>JSP with Java Code</h1>
        <%! int iterations = 10; %>
        <ul>
            <%
                for (int i = 0; i < iterations; i++) {
                    out.println("<li>Element no " + i + "</li>");
                }
            %>
        </ul>
    </body>
</html>
