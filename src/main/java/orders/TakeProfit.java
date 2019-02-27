package orders;

import java.math.BigDecimal;

public class TakeProfit {

    private final BigDecimal price;

    public TakeProfit(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
