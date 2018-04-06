import javax.swing.*;

public class DeviceForm extends JPanel {
    JTextField nameField = new JTextField(10);
    JTextField purchasePriceField = new JTextField(5);
    JTextField wearField = new JTextField(5);

    DeviceForm() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel menuRow1 = new JPanel();
        JPanel menuRow2 = new JPanel();
        JPanel menuRow3 = new JPanel();
        JLabel nameLabel = new JLabel("Namn: ");
        JLabel priceLabel = new JLabel("Pris: ");
        JLabel wearLabel = new JLabel("Slitage: ");

        menuRow1.add(nameLabel);
        menuRow1.add(nameField);
        add(menuRow1);
        menuRow2.add(priceLabel);
        menuRow2.add(purchasePriceField);
        add(menuRow2);
        menuRow3.add(wearLabel);
        menuRow3.add(wearField);
        add(menuRow3);
    }

    public String getName() {
        return nameField.getText();
    }

    public int getPrice() {
        return Integer.parseInt(purchasePriceField.getText());
    }

    public int getWear() {
        return Integer.parseInt(wearField.getText());
    }
}
