package orders;

import exception.OrderTypeNotAllowed;
import orders.stoplosses.StopLoss;

import java.math.BigDecimal;

public class OrderStop extends Order {

    public OrderStop(Type type, BigDecimal price, StopLoss stopLoss, TakeProfit takeProfit, BigDecimal size) throws OrderTypeNotAllowed {
        super(type, price, stopLoss, takeProfit, size);
        if (!type.equals(Type.SELL_STOP) || !type.equals(Type.BUY_STOP)){
            throw new OrderTypeNotAllowed("Order type "+type.value()+" not allowed for market execution");
        }
    }

    public OrderStop(Type type, BigDecimal price, TakeProfit takeProfit, BigDecimal size) throws OrderTypeNotAllowed {
        super(type, price, takeProfit, size);
        if (!type.equals(Type.SELL_STOP) || !type.equals(Type.BUY_STOP)){
            throw new OrderTypeNotAllowed("Order type "+type.value()+" not allowed for market execution");
        }
    }

    public OrderStop(Type type, BigDecimal price, StopLoss stopLoss, BigDecimal size) throws OrderTypeNotAllowed {
        super(type, price, stopLoss, size);
        if (!type.equals(Type.SELL_STOP) || !type.equals(Type.BUY_STOP)){
            throw new OrderTypeNotAllowed("Order type "+type.value()+" not allowed for market execution");
        }
    }
}
