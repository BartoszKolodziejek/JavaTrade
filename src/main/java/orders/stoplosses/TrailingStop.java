package orders.stoplosses;

import java.math.BigDecimal;

public class TrailingStop extends StopLoss{


    public TrailingStop(BigDecimal price) {
        super(price);
    }


}
