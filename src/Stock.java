public class Stock extends Valuable {
    private double marketPrice;
    private int quantity;

    public Stock(String name, double marketPrice, int quantity) {
        super(name);
        this.marketPrice = marketPrice;
        this.quantity = quantity;
    }

    public double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public double calculateValue() {
        return marketPrice * quantity;
    }

    public String toString() {
        return "Aktie: " + getName() + ", Värde: " + valueInclTax() + ", Kurs: " + marketPrice + ", Antal: " + quantity;
    }
}