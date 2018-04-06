public class ItemGenerator {
    private String[] jewelryTypes = {"Amulett", "Earring", "Hatpin", "Bolo tie", "Necklace", "Membership pin", "Armlet", "Bracelet", "Cuff links", "Championship ring", "Wedding ring", "Belly chain", "Brooch", "Anklet", "Amulet", "Celibacy vow ring", "Thumb ring", "Medallion", "Emblem"};
    private String[] stockTypes = {"Apple Inc.", "Boeing", "American Express Co", "Caterpillar Inc.", "Cisco Systems Inc.", "Chevron Corp", "General Electric Co", "Walt Disney", "Home Depot", "Intel Corp", "Goldman Sachs Group Inc", "Johnson & Johnson", "3M Co", "McDonalds Corp", "Visa Inc", "Pfizer Inc", "Ericsson", "H&M", "Boliden", "Sandviken", "Axfood", "Castellum", "Clas Ohlson", "Electrolux", "Kinnevik", "Skanska"};
    private String[] deviceTypes = {"Printer", "Nintendo DS", "Nintendo Wii", "Nintendo 8bit", "Super Nintendo", "Playstation 2", "LED TV", "Gameboy", "Gameboy Color", "Hub", "Apple TV", "iMac", "Macbook Pro", "Router", "CD-Rom", "DVD", "Keyboard", "42'' screen", "Samsung Galaxy", "iPhone 5s", "iPhone 3GS"};

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
