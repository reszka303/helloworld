package pl.javastart.DMVCPattern_4.currencycalc;

/*
Zdefiniowane w HTML "EURPLN" i "PLNEURO" mogą byc uznane za dwie stałe i dlatego odzwierciedlimy je
jako typy wyliczeniowe Enum
*/

import java.math.BigDecimal;

public enum ExchangeType {
    EURPLN("euro", "zł", new BigDecimal("4.3")),
    PLNEURO("zł", "euro", new BigDecimal("0.23"));

    private String baseCurrency;
    private String targetCurrency;
    private BigDecimal exchangeRate;

    ExchangeType(String baseCurrency, String targetCurrency, BigDecimal exchangeRate) {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.exchangeRate = exchangeRate;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }
}
