<%@ page import="java.util.Collection" %>
<%@ page import="pl.javastart.DMVCPattern_4.lottery.byMe.LotteryResult" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Loteria</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <fieldset>
            <%
                LotteryResult lotteryResult = (LotteryResult) request.getAttribute("result");
                List<Integer> lotteryNumbers = lotteryResult.getLotteryNumbers();
                List<Integer> playerNumbers = lotteryResult.getPlayerNumbers();
                List<Integer> hitNumbers = lotteryResult.getHitNumbers();
            %>
            <h2><%= "Wyniki losowania: " + lotteryNumbers %></h2>
            <h2><%= "Twoje liczby: " + playerNumbers %></h2>
            <h2><%= "Liczba trafień: " + hitNumbers.size() %></h2>
            <h2><%= "Trafione liczby: " + hitNumbers %></h2>
        </fieldset>
    </body>
</html>
