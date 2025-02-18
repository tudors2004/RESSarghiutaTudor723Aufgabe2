import Controller.*;
import Model.*;
import Repository.CharactersRepository;
import Repository.ProductsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new CharactersRepository(), new ProductsRepository());
        Scanner scanner = new Scanner(System.in);
//        List<Products> produkte = new ArrayList<>();
//        produkte.add(new Produkt("Mjolnir", 500.0, "Asgard"));
//        produkte.add(new Produkt("Vibranium-Schild", 700.0, "Wakanda"));
//        produkte.add(new Produkt("Infinity Gauntlet", 10000.0, "Titan"));
//        produkte.add(new Produkt("Web-Shooter", 250.0, "Terra"));
//        produkte.add(new Produkt("Arc-Reaktor", 1500.0, "Terra"));
//        produkte.add(new Produkt("Norn Stones", 1200.0, "Asgard"));
//        produkte.add(new Produkt("Quantum Suit", 3000.0, "Terra"));
//        produkte.add(new Produkt("X-Gene Serum", 850.0, "X-Mansion"));
//        produkte.add(new Produkt("Cosmic Cube", 9000.0, "Multiverse"));
//        produkte.add(new Produkt("Darkhold", 2000.0, "Multiverse"));
//
//        // Initialisierung der Charaktere
//        List<Characters> charaktere = new ArrayList<>();
//
//        Charakter c1 = new Charakter(1, "Thor", "Asgard");
//        c1.kaufeProdukt(produkte.get(0)); // Mjolnir
//        c1.kaufeProdukt(produkte.get(5)); // Norn Stones
//        c1.kaufeProdukt(produkte.get(9)); // Darkhold
//
//        Charakter c2 = new Charakter(2, "Black Panther", "Wakanda");
//        c2.kaufeProdukt(produkte.get(1)); // Vibranium-Schild
//        c2.kaufeProdukt(produkte.get(7)); // X-Gene Serum
//
//        Charakter c3 = new Charakter(3, "Iron Man", "Terra");
//        c3.kaufeProdukt(produkte.get(4)); // Arc-Reaktor
//        c3.kaufeProdukt(produkte.get(6)); // Quantum Suit
//        c3.kaufeProdukt(produkte.get(3)); // Web-Shooter
//
//        Charakter c4 = new Charakter(4, "Spider-Man", "Terra");
//        c4.kaufeProdukt(produkte.get(3)); // Web-Shooter
//        c4.kaufeProdukt(produkte.get(8)); // Cosmic Cube
//
//        Charakter c5 = new Charakter(5, "Doctor Strange", "Multiverse");
//        c5.kaufeProdukt(produkte.get(9)); // Darkhold
//        c5.kaufeProdukt(produkte.get(8)); // Cosmic Cube
//        c5.kaufeProdukt(produkte.get(2)); // Infinity Gauntlet
//
//        charaktere.add(c1);
//        charaktere.add(c2);
//        charaktere.add(c3);
//        charaktere.add(c4);
//        charaktere.add(c5);
        while (true) {
            System.out.println("1. Add Character");
            System.out.println("2. Delete Character");
            System.out.println("3. Update Character");
            System.out.println("4. Get All Characters");
            System.out.println("5. Get Character By Name");
            System.out.println("6. Get Character By Id");
            System.out.println("7. Add Product");
            System.out.println("8. Delete Product");
            System.out.println("9. Update Product");
            System.out.println("10. Get All Products");
            System.out.println("11. Get Product By Name");
            System.out.println("12. Add Product To Character");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter region: ");
                    String region = scanner.nextLine();
                    Characters character = new Characters(id, name, region);
                    controller.addCharacter(character);
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    controller.deleteCharacter(name);
                    break;
                case 3:
                    System.out.println("Enter character name you want to update: ");
                    String oldName = scanner.nextLine();
                    System.out.print("Enter id: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter region: ");
                    region = scanner.nextLine();
                    Characters newCharacter = new Characters(id, name, region);
                    controller.updateCharacter(newCharacter, oldName);
                case 4:
                    System.out.println(controller.getAllCharacters());
                    break;
                case 5:
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    System.out.println(controller.getCharacterByName(name));
                    break;
                case 6:
                    System.out.print("Enter id: ");
                    id = scanner.nextInt();
                    System.out.println(controller.getCharacterById(id));
                    break;
                case 7:
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter universe: ");
                    String universe = scanner.nextLine();
                    Products product = new Products(name, price, universe);
                    controller.addProduct(product);
                    break;
                case 8:
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    controller.deleteProduct(name);
                    break;
                case 9:
                    System.out.println("Enter product name you want to update: ");
                    String oldProductName = scanner.nextLine();
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter price: ");
                    price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter universe: ");
                    universe = scanner.nextLine();
                    Products newProduct = new Products(name, price, universe);
                    controller.updateProduct(newProduct, oldProductName);
                    break;
                case 10:
                    System.out.println(controller.getAllProducts());
                    break;
                case 11:
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    System.out.println(controller.getProductByName(name));
                    break;
                case 12:
                    System.out.print("Enter character name: ");
                    String characterName = scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    controller.addProductToCharacter(characterName, productName);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}