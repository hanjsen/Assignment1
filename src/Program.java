import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    private String[] jewelryTypes = {"Amulett", "Earring", "Hatpin", "Bolo tie", "Necklace", "Membership pin", "Armlet", "Bracelet", "Cuff links", "Championship ring", "Wedding ring", "Belly chain", "Brooch", "Anklet", "Amulet", "Celibacy vow ring", "Thumb ring", "Medallion", "Emblem"};
    private String[] stockTypes = {"Apple Inc.", "Boeing", "American Express Co", "Caterpillar Inc.", "Cisco Systems Inc.", "Chevron Corp", "General Electric Co", "Walt Disney", "Home Depot", "Intel Corp", "Goldman Sachs Group Inc", "Johnson & Johnson", "3M Co", "McDonalds Corp", "Visa Inc", "Pfizer Inc", "Ericsson", "H&M", "Boliden", "Sandviken", "Axfood", "Castellum", "Clas Ohlson", "Electrolux", "Kinnevik", "Skanska"};
    private String[] deviceTypes = {"Printer", "Nintendo DS", "Nintendo Wii", "Nintendo 8bit", "Super Nintendo", "Playstation 2", "LED TV", "Gameboy", "Gameboy Color", "Hub", "Apple TV", "iMac", "Macbook Pro", "Router", "CD-Rom", "DVD", "Keyboard", "42'' screen", "Samsung Galaxy", "iPhone 5s", "iPhone 3GS"};
    private ArrayList<Valuable> registerOfValuables = new ArrayList<>();

    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Program program = new Program();
        program.runProgram();
    }

    private void runProgram() {
        /**       System.out.println("Ange antal smycken: ");
         int antalSmycken = sc.nextInt();
         spamJewelry(antalSmycken);

         sc.nextLine();

         System.out.println("Ange antal prylar: ");
         int antalPrylar = sc.nextInt();
         spamDevices(antalPrylar);

         sc.nextLine();

         System.out.println("Ange antal aktier: ");
         int antalAktier = sc.nextInt();
         spamStocks(antalAktier);

         sc.nextLine();
         System.out.println();

         System.out.println("Skriv ut? ");
         String kommando = sc.next().toUpperCase();

         switch (kommando) {
         case "JA":
         System.out.println("Printing...");
         printValuables();
         break;
         case "NEJ":
         System.out.println("GUI, start ur engine");
         break;
         default:
         System.out.println("False commando");
         }
         **/
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
                NewJewelryForm newItem = new NewJewelryForm();
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
                NewStockForm newStock = new NewStockForm();
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
                NewDeviceForm newDevice = new NewDeviceForm();
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

    class NewJewelryForm extends JPanel {
        JTextField nameField = new JTextField(10);
        JTextField gemField = new JTextField(5);
        JCheckBox materialField = new JCheckBox("Av guld");

        NewJewelryForm() {
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

    class NewStockForm extends JPanel {
        JTextField stockNameField = new JTextField(10);
        JTextField stockQuantityField = new JTextField(5);
        JTextField stockPriceField = new JTextField(5);

        public NewStockForm() {
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            JPanel menuRow1 = new JPanel();
            JPanel menuRow2 = new JPanel();
            JPanel menuRow3 = new JPanel();
            JLabel nameLabel = new JLabel("Namn: ");
            JLabel quantityLabel = new JLabel("Antal: ");
            JLabel priceLabel = new JLabel("Kurs: ");

            menuRow1.add(nameLabel);
            menuRow1.add(stockNameField);
            add(menuRow1);
            menuRow2.add(quantityLabel);
            menuRow2.add(stockQuantityField);
            add(menuRow2);
            menuRow3.add(priceLabel);
            menuRow3.add(stockPriceField);
            add(menuRow3);
        }

        public String getName() {
            return stockNameField.getText();
        }

        public int getQuantity() {
            return Integer.parseInt(stockQuantityField.getText());
        }

        public double getPrice() {
            return Double.parseDouble(stockPriceField.getText());
        }

    }

    class NewDeviceForm extends JPanel {
        JTextField nameField = new JTextField(10);
        JTextField purchasePriceField = new JTextField(5);
        JTextField wearField = new JTextField(5);

        NewDeviceForm() {
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
/**
 private void spamJewelry(int size) {
 for (int i = 0; i < size; i++) {
 int randomNumber = (int) (Math.random() * jewelryTypes.length);
 int randomNumberTwo = (int) (Math.random() * 24) + 1;
 boolean gold;
 if (randomNumberTwo % 2 != 0) {
 gold = true;
 }
 else {
 gold = false;
 }
 String type = jewelryTypes[randomNumber];
 Jewelry jewelry = new Jewelry(type, randomNumberTwo, gold);
 registerOfValuables.add(jewelry);
 System.out.println(jewelry + " added");
 }
 }

 private void spamStocks(int size) {
 for (int i = 0; i < size; i++) {
 int randomNumber = (int) (Math.random() * jewelryTypes.length);
 int randomNumberTwo = (int) (Math.random() * 24) + 1;
 int marketPrice = randomNumber * randomNumberTwo / 5;
 String type = stockTypes[randomNumber];
 Stock stock = new Stock(type, randomNumberTwo, marketPrice);
 registerOfValuables.add(stock);
 System.out.println(stock + " added");
 }
 }

 private void spamDevices(int size) {
 for (int i = 0; i < size; i++) {
 int randomNumber = (int) (Math.random() * jewelryTypes.length);
 int randomNumberTwo = (int) (Math.random() * 2400);
 int randomWear = (int) (Math.random() * 10) + 1;
 String type = deviceTypes[randomNumber];
 Device device = new Device(type, randomNumberTwo, randomWear);
 registerOfValuables.add(device);
 System.out.println(device + " added");
 }
 }

 private void printValuables() {
 for (Valuable v : registerOfValuables) {
 System.out.println(v);
 }
 }

 **/

}