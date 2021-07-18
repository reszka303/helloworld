<%@ page import="pl.javastart.DMVCPattern_4.currencycalc.ExchangeResult" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="pl.javastart.DMVCPattern_4.currencycalc.ExchangeType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kalkulator walut - wynik</title>
</head>
<body>
<%--w setAttribute(String) nazwa Stringa musi być taka sama jaka została podana
w kontrolerze w metodzie setAttribute--%>
<%--Wadą setAttribute jest to, że zwraca zawsze Object, więc trzeba rzutować na obiekt
który jest nam potrzebny, w tym przypadku to jest ExchangeResult--%>
    <%
        ExchangeResult exchangeResult = (ExchangeResult) request.getAttribute("result");
        BigDecimal base = exchangeResult.getBase();
        BigDecimal result = exchangeResult.getResult();
        ExchangeType exchangeType = exchangeResult.getExchangeType();
        String baseCurrency = exchangeType.getBaseCurrency();
        String targetCurrency = exchangeType.getTargetCurrency();
    %>
    <h2>
        <%= String.format("%s%s to %s%s", base.toString(), baseCurrency, result.toString(), targetCurrency) %>
    </h2>
</body>
</html>
