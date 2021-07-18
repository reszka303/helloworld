package pl.javastart.DMVCPattern_4.currencycalc;

import java.math.BigDecimal;

/*
klasy które służą do przesyłania informacji np z kontrolera do strony jsp, czyli do szablonu, nazywamy
Obiektami Transferu Danych - DATA OBJECT TRANSFER (DTO)
*/
public class ExchangeResult {
    private BigDecimal base;
    private BigDecimal result;
    private ExchangeType exchangeType;

    public ExchangeResult(BigDecimal base, BigDecimal result, ExchangeType exchangeType) {
        this.base = base;
        this.result = result;
        this.exchangeType = exchangeType;
    }

    public BigDecimal getBase() {
        return base;
    }

    public BigDecimal getResult() {
        return result;
    }

    public ExchangeType getExchangeType() {
        return exchangeType;
    }
}
