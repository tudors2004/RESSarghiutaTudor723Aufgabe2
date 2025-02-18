package Controller;
import Model.Characters;
import Model.Products;
import Repository.CharactersRepository;
import Repository.ProductsRepository;
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


}
