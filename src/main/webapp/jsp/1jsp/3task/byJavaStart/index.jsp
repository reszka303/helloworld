<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Youtuber</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<%
    String[] videos = request.getParameterValues("video");
    if (videos == null) {
        out.println("<h2>Brak parametru video w adresie URL</h2>");
    } else {
        for (String videoId : videos) {
 %>
    <iframe id="ytplayer" width="640" height="360"
        src="https://www.youtube.com/embed/<%=videoId%>"></iframe>

 <%
        }
    }
 %>

<%--    <iframe width="640" height="340" src="https://www.youtube.com/embed/tAGnKpE4NCI" ></iframe>--%>
<%--    <iframe width="640" height="340" src="https://www.youtube.com/embed/e80qhyovOnA" ></iframe>--%>
</body>
</html>
