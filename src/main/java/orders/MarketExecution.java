package orders;

import exception.OrderTypeNotAllowed;
import orders.stoplosses.StopLoss;

import java.math.BigDecimal;

public class MarketExecution extends Order {


    public MarketExecution(Type type, StopLoss stopLoss, TakeProfit takeProfit, BigDecimal size) throws OrderTypeNotAllowed {
        super(type, stopLoss, takeProfit, size);
        if (!type.equals(Type.SELL) || !type.equals(Type.BUY)){
            throw new OrderTypeNotAllowed("Order type "+type.value()+" not allowed for market execution");
        }
    }

    public MarketExecution(Type type, TakeProfit takeProfit, BigDecimal size) throws OrderTypeNotAllowed {
        super(type, takeProfit, size);
        if (!type.equals(Type.SELL) || !type.equals(Type.BUY)){
            throw new OrderTypeNotAllowed("Order type "+type.value()+" not allowed for market execution");
        }
    }

    public MarketExecution(Type type, StopLoss stopLoss, BigDecimal size) throws OrderTypeNotAllowed {
        super(type, stopLoss, size);
        if (!type.equals(Type.SELL) || !type.equals(Type.BUY)){
            throw new OrderTypeNotAllowed("Order type "+type.value()+" not allowed for market execution");
        }
    }

    public MarketExecution(Type type, BigDecimal size) throws OrderTypeNotAllowed {
        super(type, size);
        if (!type.equals(Type.SELL) || !type.equals(Type.BUY)){
            throw new OrderTypeNotAllowed("Order type "+type.value()+" not allowed for market execution");
        }
    }
}
