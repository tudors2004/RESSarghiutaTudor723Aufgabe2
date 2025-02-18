package Controller;
import Model.Characters;
import Model.Products;
import Repository.CharactersRepository;
import Repository.ProductsRepository;

import java.util.Comparator;
import java.util.List;
public class Controller {
    private CharactersRepository charactersRepository;
    private ProductsRepository productsRepository;

    public Controller(CharactersRepository charactersRepository, ProductsRepository productsRepository) {
        this.charactersRepository = charactersRepository;
        this.productsRepository = productsRepository;
    }

    public void addCharacter(Characters character) {
        charactersRepository.addCharacter(character);
    }
    public void deleteCharacter(String name) {
        charactersRepository.deleteCharacter(name);
    }
    public void updateCharacter(Characters newCharacter, String name) {
        charactersRepository.updateCharacter(newCharacter, name);
    }
    public List<Characters> getAllCharacters() {
        return charactersRepository.getAllCharacters();
    }
    public Characters getCharacterByName(String name) {
        return charactersRepository.getCharacterByName(name);
    }
    public Characters getCharacterById(int id) {
        return charactersRepository.getCharacterById(id);
    }
    public void addProduct(Products product) {
        productsRepository.addProduct(product);
    }
    public void deleteProduct(String name) {
        productsRepository.deleteProduct(name);
    }
    public void updateProduct(Products newProduct, String name) {
        productsRepository.updateProduct(newProduct, name);
    }
    public List<Products> getAllProducts() {
        return productsRepository.getAllProducts();
    }
    public Products getProductByName(String name) {
        return productsRepository.getProductByName(name);
    }
    public void addProductToCharacter(String characterName, String productName){
        Characters character = charactersRepository.getCharacterByName(characterName);
        Products product = productsRepository.getProductByName(productName);
        character.getProducts().add(product);
    }

    /**
     * This method prints all the characters from a specific region
     * @param region the region of the characters
     */
    public void getCharactersByRegion(String region) {
        List<Characters> characters = charactersRepository.getAllCharacters();
        for (Characters character : characters) {
            if (character.getRegion().equals(region)) {
                System.out.println(character.getName());
            }
        }
    }
    /**
     * This method prints all the characters that have products from a specific universe
     * @param universe the universe of the characters
     */
    public void getCharactersByProductUniverse(String universe){
        List<Characters> characters = charactersRepository.getAllCharacters();
        for (Characters character : characters) {
            for (Products product : character.getProducts()) {
                if (product.getUniverse().equals(universe)) {
                    System.out.println(character.getName());
                    break;
                }
            }
        }
    }
    /**
     * This method sorts the products of a character by price
     * @param characterName the name of the character
     * @param sortType the type of sorting
     */
    public void sortProductsByPrice(String characterName, String sortType){
        Characters character = charactersRepository.getCharacterByName(characterName);
        List<Products> products = character.getProducts();
        if (sortType.equals("ascending")) {
            products.sort((product1, product2) -> Double.compare(product2.getPrice(), product1.getPrice()));
        } else {
            products.sort(Comparator.comparingDouble(Products::getPrice));
        }
        for (Products product : products) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
    }

}
