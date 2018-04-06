public class Jewelry extends Valuable {
    private int gemstones;
    private boolean madeOfGold;
    private final int GOLD = 2000;
    private final int SILVER = 700;
    private final int GEMPRICE = 500;

    public Jewelry(String name, int gemstones, boolean madeOfGold) {
        super(name);
        this.madeOfGold = madeOfGold;
        this.gemstones = gemstones;
    }

    public int getGemstones() {
        return gemstones;
    }

    public double calculateValue() {
        double materialPrice = madeOfGold ? GOLD : SILVER;
        return materialPrice + GEMPRICE * gemstones;
    }

    public String toString() {
        String madeOfMaterial = madeOfGold ? "Guld" : "Silver";
        return "Smycke: " + getName() + ", Värde: " + valueInclTax() + ", Ädelstenar: " + gemstones + ", Material: " + madeOfMaterial;
    }

}