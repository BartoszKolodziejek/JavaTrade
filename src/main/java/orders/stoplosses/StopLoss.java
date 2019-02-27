package orders.stoplosses;

import java.math.BigDecimal;

public class StopLoss {

    private final BigDecimal distance;

    public StopLoss(BigDecimal distance) {
        this.distance = distance;
    }

    public BigDecimal getDistance() {
        return distance;
    }
}
