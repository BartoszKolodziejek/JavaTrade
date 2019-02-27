package orders;

import orders.stoplosses.StopLoss;
import strategy.StrategyProperties;

import java.math.BigDecimal;
import java.util.Optional;

public abstract class Order {

    private int id;
    private final String instrument = (String) StrategyProperties.getInstance().get("instrument");
    protected final Type type;
    protected BigDecimal price;
    private StopLoss stopLoss;
    private TakeProfit takeProfit;
    private final BigDecimal size;

    public Order(Type type, BigDecimal price, StopLoss stopLoss, TakeProfit takeProfit, BigDecimal size) {
        this.type = type;
        this.price = price;
        this.stopLoss = stopLoss;
        this.takeProfit = takeProfit;
        this.size = size;
    }

    public Order(Type type, StopLoss stopLoss, TakeProfit takeProfit, BigDecimal size) {
        this.type = type;
        this.stopLoss = stopLoss;
        this.takeProfit = takeProfit;
        this.size = size;
    }

    public Order(Type type, BigDecimal price, TakeProfit takeProfit, BigDecimal size) {
        this.type = type;
        this.price = price;
        this.takeProfit = takeProfit;
        this.size = size;
    }

    public Order(Type type, TakeProfit takeProfit, BigDecimal size) {
        this.type = type;
        this.takeProfit = takeProfit;
        this.size = size;
    }

    public Order(Type type, BigDecimal price, StopLoss stopLoss, BigDecimal size) {
        this.type = type;
        this.price = price;
        this.stopLoss = stopLoss;
        this.size = size;
    }

    public Order(Type type, StopLoss stopLoss, BigDecimal size) {
        this.type = type;
        this.stopLoss = stopLoss;
        this.size = size;
    }

    public Order(Type type, BigDecimal price, BigDecimal size) {
        this.type = type;
        this.price = price;
        this.size = size;
    }

    public Order(Type type, BigDecimal size) {
        this.type = type;
        this.size = size;
    }


    public int getId() {
        return id;
    }

    public String getInstrument() {
        return instrument;
    }

    public final String getCloseMessage(){
        return "close: " + this.id;
    }

    public Type getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return Optional.ofNullable(price).orElse(BigDecimal.ZERO);
    }

    public StopLoss getStopLoss() {
        return Optional.ofNullable(stopLoss).orElse(new StopLoss());
    }

    public TakeProfit getTakeProfit() {
        return Optional.ofNullable(takeProfit).orElse(new TakeProfit(price));
    }
}
