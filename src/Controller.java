// Controller
import Model.Character;
import Model.Produkt;
import Repo.ObjectWithIDRepo;
import Repo.ObjectWithNameRepo;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final ObjectWithIDRepo characterRepo;
    private final ObjectWithNameRepo productRepo;
    private int newObjID = 5;

    /**
     * Constructs a new Controller with the given repositories.
     *
     * @param characterRepo the repository for
     * @param productRepo the repository for
     */
    public Controller(ObjectWithIDRepo characterRepo, ObjectWithNameRepo productRepo) {
        this.characterRepo = characterRepo;
        this.productRepo = productRepo;
    }

    /**
     * Adds an object to the product repo.
     */
    public void addProduct(String name, double price, String region) {
        productRepo.add(new Produkt(name, price, region));
    }

    /**
     * Adds an object to the character repo.
     */
    public void addCharacter(String name, String herkunftsdorf, List<Produkt> produkts) {
        characterRepo.add(new Character(++newObjID, name, herkunftsdorf, produkts));
    }

    /**
     * Updates an object in the product repo.
     */
    public void updateProduct(String name, double price, String region) {
        productRepo.update(new Produkt(name, price, region));
    }

    /**
     * Updates an object in the character repo.
     */
    public void updateCharacter(int ID, String name, String herkunftsdorf, List<Produkt> produkts) {
        characterRepo.update(new Character(ID, name, herkunftsdorf, produkts));
    }

    /**
     * Removes an object from the product repo
     *
     * @param name the name of the product
     */
    public void deleteProduct(String name) {
        productRepo.delete(name);
    }

    /**
     * Removes an object from the character repo
     *
     * @param id the id of the character
     */
    public void deleteCharacter(int id) {
        characterRepo.delete(id);
    }

    /**
     * Retrieves an object from the product repo by its name.
     *
     * @param name the name of the product
     * @return the object
     */
    public Produkt getProduct(String name) {
        return productRepo.get(name);
    }

    /**
     * Retrieves an object from the character repo by its id.
     *
     * @param id the id of the character
     * @return the object
     */
    public Character getCharacter(int id) {
        return characterRepo.get(id);
    }

    /**
     * Retrieves all product
     *
     * @return a list of all product
     */
    public List<Produkt> getAllProducts() {
        return productRepo.getAll();
    }

    /**
     * Retrieves all character
     *
     * @return a list of all character
     */
    public List<Character> getAllCharacters() {
        return characterRepo.getAll();
    }

    /**
     * Filters characters by a herkunftdorf
     *
     * @param herkunftsort the herkunftdorf to filter
     * @return the filtered list
     */
    public List<Character> filterCharacterByHerkunftsort(String herkunftsort) {
        return characterRepo.getAll().stream().filter(c -> c.getHerkunftsdorf().equals(herkunftsort)).toList();
    }

    /**
     * Method that sorts a character products by their price
     *
     * @param charID the character
     * @param sortMode the sorting mode (asc/desc)
     * @return the list of products
     */
    public List<Produkt> sortCharacterProdByPrice(int charID, String sortMode) {
        Character c = characterRepo.get(charID);
        return c.getProdukts().stream().sorted((p1, p2) -> sortMode.equals("asc") ? Double.compare(p1.getPrice(), p2.getPrice()) : Double.compare(p2.getPrice(), p1.getPrice())).toList();
    }

    /**
     * Method that filters characters by a product region
     *
     * @param region the products region
     * @return the character list
     */
    public List<Character> filterCharacterByProdRegion(String region) {
        List<Character> characters = new ArrayList<>();
        for(Character c : characterRepo.getAll()) {
            if(c.getProdukts().stream().filter(p -> p.getRegion().equals(region)).toList().isEmpty()) {
                characters.add(c);
            }
        }
        return characters;
    }
}
