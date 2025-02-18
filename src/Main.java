import Controller.*;
import Model.*;
import Repository.CharactersRepository;
import Repository.ProductsRepository;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new CharactersRepository(), new ProductsRepository());
        Scanner scanner = new Scanner(System.in);
    }
}