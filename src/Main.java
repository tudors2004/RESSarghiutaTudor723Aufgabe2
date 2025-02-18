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
            System.out.println("13. Filter Characters By Region");
            System.out.println("14. Filter Characters By Product's Universe");
            System.out.println("15. Sort the Character's Products by Price");
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
                case 13:
                    System.out.print("Enter region: ");
                    region = scanner.nextLine();
                    controller.getCharactersByRegion(region);
                    break;
                case 14:
                    System.out.print("Enter universe: ");
                    universe = scanner.nextLine();
                    controller.getCharactersByProductUniverse(universe);
                    break;
                case 15:
                    System.out.print("Enter character name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter the sorting order (asc/desc): ");
                    String sortType = scanner.nextLine();
                    controller.sortProductsByPrice(name, sortType);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}