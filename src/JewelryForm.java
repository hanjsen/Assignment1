import javax.swing.*;

public class JewelryForm extends JPanel {
    JTextField nameField = new JTextField(10);
    JTextField gemField = new JTextField(5);
    JCheckBox materialField = new JCheckBox("Av guld");

    JewelryForm() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel menuRow1 = new JPanel();
        JPanel menuRow2 = new JPanel();
        JPanel menuRow3 = new JPanel();
        JLabel nameLabel = new JLabel("Namn: ");
        JLabel gemsLabel = new JLabel("Ädelstenar: ");
        menuRow1.add(nameLabel);
        menuRow1.add(nameField);
        add(menuRow1);
        menuRow2.add(gemsLabel);
        menuRow2.add(gemField);
        add(menuRow2);
        menuRow3.add(materialField);
        add(menuRow3);
    }

    public String getName() {
        return nameField.getText();
    }

    public int getGems() {
        return Integer.parseInt(gemField.getText());
    }

    public boolean isGold() {
        return materialField.isSelected();
    }
}
