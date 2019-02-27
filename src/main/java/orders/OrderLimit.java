package orders;

import exception.OrderTypeNotAllowed;
import orders.stoplosses.StopLoss;

import java.math.BigDecimal;

public class OrderLimit extends Order {

    public OrderLimit(Type type, BigDecimal price, StopLoss stopLoss, TakeProfit takeProfit, BigDecimal size) throws OrderTypeNotAllowed {
        super(type, price, stopLoss, takeProfit, size);
        if (!type.equals(Type.SELL_LIMIT) || !type.equals(Type.BUY_LIMIT)){
            throw new OrderTypeNotAllowed("Order type "+type.value()+" not allowed for market execution");
        }
    }

    public OrderLimit(Type type, BigDecimal price, TakeProfit takeProfit, BigDecimal size) throws OrderTypeNotAllowed {
        super(type, price, takeProfit, size);
        if (!type.equals(Type.SELL_LIMIT) || !type.equals(Type.BUY_LIMIT)){
            throw new OrderTypeNotAllowed("Order type "+type.value()+" not allowed for market execution");
        }
    }

    public OrderLimit(Type type, BigDecimal price, StopLoss stopLoss, BigDecimal size) throws OrderTypeNotAllowed {
        super(type, price, stopLoss, size);
        if (!type.equals(Type.SELL_LIMIT) || !type.equals(Type.BUY_LIMIT)){
            throw new OrderTypeNotAllowed("Order type "+type.value()+" not allowed for market execution");
        }
    }

    public OrderLimit(Type type, BigDecimal price, BigDecimal size) throws OrderTypeNotAllowed {
        super(type, price, size);
        if (!type.equals(Type.SELL_LIMIT) || !type.equals(Type.BUY_LIMIT)){
            throw new OrderTypeNotAllowed("Order type "+type.value()+" not allowed for market execution");
        }
    }
}
