import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Program {

    private ArrayList<Valuable> registerOfValuables = new ArrayList<>();

    public static void main(String[] args) {
        Program program = new Program();
        program.runProgram();
    }

    private void runProgram() {

        new GUI();

    }

    public class GUI extends JFrame {

        private JTextArea display;
        private JComboBox<String> addItemsDropMenu;

        GUI() {
            super("Sakregister");

            Font cambria = new Font("Cambria", Font.PLAIN, 14);
            Font cambriaXL = new Font("Cambria", Font.PLAIN, 24);

            JPanel north = new JPanel();
            JPanel south = new JPanel();
            JPanel center = new JPanel();
            JPanel east = new JPanel();

            add(north, BorderLayout.NORTH);
            add(south, BorderLayout.SOUTH);
            add(east, BorderLayout.EAST);
            add(center, BorderLayout.CENTER);

            east.setLayout(new BoxLayout(east, 1));

            display = new JTextArea();
            display.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(display);

            JLabel valuableLabel = new JLabel("Värdesaker");
            JLabel sortItemsLabel = new JLabel("Sortering");
            JLabel addItemLabel = new JLabel("Nytt:");

            String[] comboBoxSelectionAlternatives = {"Smycke", "Aktie", "Apparat"};
            addItemsDropMenu = new JComboBox<>(comboBoxSelectionAlternatives);

            JButton showButton = new JButton("Visa");
            JButton marketCrashButton = new JButton("Börskrasch");
            JRadioButton sortByNameButton = new JRadioButton("Namn");
            JRadioButton sortByValueButton = new JRadioButton("Värde");

            showButton.setFont(cambria);
            marketCrashButton.setFont(cambria);
            addItemsDropMenu.setFont(cambria);
            addItemLabel.setFont(cambria);
            valuableLabel.setFont(cambriaXL);

            ButtonGroup sortMenuGroup = new ButtonGroup();
            sortMenuGroup.add(sortByNameButton);
            sortMenuGroup.add(sortByValueButton);

            north.add(valuableLabel);
            south.add(addItemLabel);
            south.add(addItemsDropMenu);
            south.add(showButton);
            south.add(marketCrashButton);
            east.add(sortItemsLabel);
            east.add(sortByNameButton);
            east.add(sortByValueButton);
            center.setLayout(new BorderLayout());
            center.add(scrollPane);

            showButton.addActionListener(new ShowItems());
            addItemsDropMenu.addActionListener(new AddItemMenu());
            marketCrashButton.addActionListener(new MarketCrash());

            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(600, 350);
            setVisible(true);

        }

        class ShowItems implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("");
                for (Valuable v : registerOfValuables) {
                    display.append(v + "\n");
                }
            }
        }

        class AddItemMenu implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedItem = (String) addItemsDropMenu.getSelectedItem();
                    if (selectedItem == "Smycke") {
                        addJewelry();
                    }
                    else if (selectedItem == "Aktie") {
                        addStock();
                    }
                    else if (selectedItem == "Apparat") {
                        addDevice();
                    }
                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(GUI.this, "Felaktig inmatning!");
                }
            }

            private void addJewelry() {
                JewelryForm newItem = new JewelryForm();
                int selection = JOptionPane.showConfirmDialog(GUI.this, newItem, "Nytt smycke", JOptionPane.OK_CANCEL_OPTION);
                if (selection != JOptionPane.OK_OPTION) {
                    return;
                }
                String jewelryName = newItem.getName();
                int gemstones = newItem.getGems();
                boolean isGold = newItem.isGold();
                Jewelry item = new Jewelry(jewelryName, gemstones, isGold);
                registerOfValuables.add(item);
            }

            private void addStock() {
                StockForm newStock = new StockForm();
                int selection = JOptionPane.showConfirmDialog(GUI.this, newStock, "Ny aktie", JOptionPane.OK_CANCEL_OPTION);
                if (selection != JOptionPane.OK_OPTION) {
                    return;
                }
                String name = newStock.getName();
                int quantity = newStock.getQuantity();
                double price = newStock.getPrice();
                Stock stock = new Stock(name, price, quantity);
                registerOfValuables.add(stock);
            }

            private void addDevice() {
                DeviceForm newDevice = new DeviceForm();
                int selection = JOptionPane.showConfirmDialog(GUI.this, newDevice, "Ny apparat", JOptionPane.OK_CANCEL_OPTION);
                if (selection != JOptionPane.OK_OPTION) {
                    return;
                }
                String name = newDevice.getName();
                int price = newDevice.getPrice();
                int wear = newDevice.getWear();
                Device device = new Device(name, price, wear);
                registerOfValuables.add(device);
            }
        }

        class MarketCrash implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Valuable v : registerOfValuables) {
                    if (v instanceof Stock) {
                        ((Stock) v).setMarketPrice(0);
                    }
                }
            }
        }

    }
}