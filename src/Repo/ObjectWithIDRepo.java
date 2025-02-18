// ObjectWithIDRepo
package Repo;

import Model.Character;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectWithIDRepo {

    private final Map<Integer, Character> data = new HashMap<>();

    /**
     * Creates a new object in the repository.
     *
     * @param obj the object to be added
     */
    public void add(Character obj) {
        data.putIfAbsent(obj.getID(), obj);
    }

    /**
     * Updates an object in the repository.
     *
     * @param obj the object to be updated
     */
    public void update(Character obj) {
        data.replace(obj.getID(), obj);
    }

    /**
     * Removes an object from the repository by its ID.
     *
     * @param id the unique identifier of the object to delete.
     */
    public void delete(int id) {
        data.remove(id);
    }

    /**
     * Retrieves an object from the repository by its ID.
     *
     * @param id the unique identifier of the object to retrieve.
     * @return the object with the specified ID, or null if not found.
     */
    public Character get(int id) {
        return data.get(id);
    }

    /**
     * Retrieves all objects from the repository.
     *
     * @return A list of all objects in the repository.
     */
    public List<Character> getAll() {
        return data.values().stream().toList();
    }
}
