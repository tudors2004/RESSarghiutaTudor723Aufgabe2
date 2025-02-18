package Repository;

import Model.Characters;

import java.util.ArrayList;
import java.util.List;

public class CharactersRepository {
    private List<Characters> characters = new ArrayList<>();
    public void addCharacter(Characters character) {
        characters.add(character);
    }
    public void deleteCharacter(String name){
        characters.removeIf(character -> character.getName().equals(name));
    }
    public void updateCharacter(Characters newCharacter, String name){
        deleteCharacter(name);
        addCharacter(newCharacter);
    }
    public List<Characters> getAllCharacters() {
        return characters;
    }
    public Characters getCharacterByName(String name){
        for (Characters character : characters) {
            if (character.getName().equals(name)) {
                return character;
            }
        }
        return null;
    }
    public Characters getCharacterById(int id){
        for (Characters character : characters) {
            if (character.getId() == id) {
                return character;
            }
        }
        return null;
    }
}
