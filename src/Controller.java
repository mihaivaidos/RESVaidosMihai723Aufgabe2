// Controller
import Model.Character;
import Model.Produkt;
import Repo.ObjectWithIDRepo;
import Repo.ObjectWithNameRepo;

import java.util.List;

public class Controller {

    private final ObjectWithIDRepo objectWithIDRepo;
    private final ObjectWithNameRepo objectWithNameRepo;
    private int newObjID = 0;

    /**
     * Constructs a new Controller with the given repositories.
     *
     * @param objectWithIDRepo the repository for
     * @param objectWithNameRepo the repository for
     */
    public Controller(ObjectWithIDRepo objectWithIDRepo, ObjectWithNameRepo objectWithNameRepo) {
        this.objectWithIDRepo = objectWithIDRepo;
        this.objectWithNameRepo = objectWithNameRepo;
    }

    /**
     * Adds an object to the .... repo.
     */
    public void addObjWithName(String name, double price, String region) {
        objectWithNameRepo.add(new Produkt(name, price, region));
    }

    /**
     * Adds an object to the ... repo.
     */
    public void addObjWithID(String name, String herkunftsdorf, List<Produkt> produkts) {
        objectWithIDRepo.add(new Character(++newObjID, name, herkunftsdorf, produkts));
    }

    /**
     * Updates an object in the .... repo.
     */
    public void updateObjWithName(String name, double price, String region) {
        objectWithNameRepo.update(new Produkt(name, price, region));
    }

    /**
     * Updates an object in the ... repo.
     */
    public void updateObjWithID(int ID, String name, String herkunftsdorf, List<Produkt> produkts) {
        objectWithIDRepo.update(new Character(ID, name, herkunftsdorf, produkts));
    }

    /**
     * Removes an object from the .... repo
     *
     * @param name the name of the ....
     */
    public void deleteObjWithName(String name) {
        objectWithNameRepo.delete(name);
    }

    /**
     * Removes an object from the ... repo
     *
     * @param id the id of the ...
     */
    public void deleteObjWithID(int id) {
        objectWithIDRepo.delete(id);
    }

    /**
     * Retrieves an object from the .... repo by its name.
     *
     * @param name the name of the ....
     * @return the object
     */
    public Produkt getObjWithName(String name) {
        return objectWithNameRepo.get(name);
    }

    /**
     * Retrieves an object from the ... repo by its id.
     *
     * @param id the id of the ...
     * @return the object
     */
    public Character getObjWithID(int id) {
        return objectWithIDRepo.get(id);
    }

    /**
     * Retrieves all ....
     *
     * @return a list of all ....
     */
    public List<Produkt> getAllObjWithName() {
        return objectWithNameRepo.getAll();
    }

    /**
     * Retrieves all ...
     *
     * @return a list of all ...
     */
    public List<Character> getAllObjWithID() {
        return objectWithIDRepo.getAll();
    }

    // subpunctu c) d) si e)

    // subpunctu e)
//    public List<Object> sortByValue(int ID, String mode) {
//        //Vereine vereine = vereinRepo.get(vereinID);
//        List<ObjName> data = objectWithIDRepo.getAll();//.getPlayerList();
//
//        data.sort((p1, p2) -> mode.equals("asc") ? Integer.compare(p1.getValue(), p2.getValue()) : Integer.compare(p2.getValue(), p1.getValue()));
//        return data;
//    }

    public List<Character> filterCharacterByHerkunftsort(String herkunftsort) {
        return objectWithIDRepo.getAll().stream().filter(c -> c.getHerkunftsdorf().equals(herkunftsort)).toList();
    }

}
