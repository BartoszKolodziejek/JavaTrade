package orders;

public enum Type {
    SELL_STOP("SellStop"),
    BUY_STOP("BuyStop"),
    SELL_LIMIT("SellLimit"),
    BUY_LIMIT("BuyLimit"),
    SELL("Sell"),
    BUY("Buy");

    String type;


    Type(String type) {
        this.type = type;
    }

    public String value(){
        return type;
    }
}
