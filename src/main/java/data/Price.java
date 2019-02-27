package data;

import java.math.BigDecimal;

public class Price {

    private BigDecimal ask;
    private BigDecimal bid;

    public BigDecimal getAsk() {
        return ask;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public Price(BigDecimal ask, BigDecimal bid) {
        this.ask = ask;
        this.bid = bid;
    }
}
