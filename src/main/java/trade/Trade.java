package trade;

import orders.Type;

import java.math.BigDecimal;
import java.util.Optional;

public class Trade {


    private BigDecimal status;
    private final Type type;
    private final BigDecimal stopLoss;
    private BigDecimal margin;
    private BigDecimal units;
    private final String id;


     Trade(BigDecimal status, Type type, BigDecimal stopLoss, BigDecimal margin, BigDecimal units, String id) {
        this.status = Optional.ofNullable(status).orElseThrow();
        this.type = Optional.ofNullable(type).orElseThrow();
        this.stopLoss = Optional.ofNullable(stopLoss).orElseThrow();
        this.margin = Optional.ofNullable(margin).orElseThrow();
        this.units = Optional.ofNullable(units).orElseThrow();
        this.id = id;
     }

    public BigDecimal getStatus() {
        return status;
    }

    public Type getType() {
        return type;
    }

    public BigDecimal getStopLoss() {
        return stopLoss;
    }

    public BigDecimal getMargin() {
        return margin;
    }

    public BigDecimal getUnits() {
        return units;
    }
}
