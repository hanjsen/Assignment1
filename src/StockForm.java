import javax.swing.*;

public class StockForm extends JPanel {
    JTextField nameField = new JTextField(10);
    JTextField quantityField = new JTextField(5);
    JTextField priceField = new JTextField(5);

    public StockForm() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel menuRow1 = new JPanel();
        JPanel menuRow2 = new JPanel();
        JPanel menuRow3 = new JPanel();
        JLabel nameLabel = new JLabel("Namn: ");
        JLabel quantityLabel = new JLabel("Antal: ");
        JLabel priceLabel = new JLabel("Kurs: ");

        menuRow1.add(nameLabel);
        menuRow1.add(nameField);
        add(menuRow1);
        menuRow2.add(quantityLabel);
        menuRow2.add(quantityField);
        add(menuRow2);
        menuRow3.add(priceLabel);
        menuRow3.add(priceField);
        add(menuRow3);
    }

    public String getName() {
        return nameField.getText();
    }

    public int getQuantity() {
        return Integer.parseInt(quantityField.getText());
    }

    public double getPrice() {
        return Double.parseDouble(priceField.getText());
    }

}
