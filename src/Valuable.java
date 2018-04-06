public abstract class Valuable {
    private String name;
    private final double TAX = 1.25;

    public Valuable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String valueInclTax() {
        return String.format("%.2f", (calculateValue() * TAX));
    }

    public abstract double calculateValue();
}