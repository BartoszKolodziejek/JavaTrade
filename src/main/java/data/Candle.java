package data;

import java.util.Date;

public class Candle {

    private final Price max;
    private final Price min;
    private final Price open;
    private final Price close;
    private final Date date;


    public Candle(Price max, Price min, Price open, Price close, Date date) {
        this.max = max;
        this.min = min;
        this.open = open;
        this.close = close;
        this.date = date;
    }

    public Price getMax() {
        return max;
    }

    public Price getMin() {
        return min;
    }

    public Price getOpen() {
        return open;
    }

    public Price getClose() {
        return close;
    }

    public Date getDate() {
        return date;
    }
}
