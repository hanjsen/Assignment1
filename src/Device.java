public class Device extends Valuable {
    private int purchasePrice;
    private int wearIndex;

    public Device(String name, int purchasePrice, int wearIndex) {
        super(name);
        this.purchasePrice = purchasePrice;
        this.wearIndex = wearIndex;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getWearIndex() {
        return wearIndex;
    }

    public double calculateValue() {
        return purchasePrice * ((double) wearIndex / 10.0);
    }

    public String toString() {
        return "Apparat: " + getName() + ", Värde: " + valueInclTax() + ", Inköpspris: " + purchasePrice + ", Förslitning: " + wearIndex;
    }
}