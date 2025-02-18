// ObjectWithNameRepo
package Repo;

import Model.Produkt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectWithNameRepo {

    private final Map<String, Produkt> data = new HashMap<>();

    /**
     * Creates a new object in the repository.
     *
     * @param obj the object to be added
     */
    public void add(Produkt obj) {
        data.putIfAbsent(obj.getName(), obj);
    }

    /**
     * Updates an object in the repository.
     *
     * @param obj the object to be updated
     */
    public void update(Produkt obj) {
        data.replace(obj.getName(), obj);
    }

    /**
     * Removes an object from the repository by its name.
     *
     * @param name the name of the object to delete.
     */
    public void delete(String name) {
        data.remove(name);
    }

    /**
     * Retrieves an object from the repository by its name.
     *
     * @param name the name of the object to retrieve.
     * @return the object with the specified name, or null if not found.
     */
    public Produkt get(String name) {
        return data.get(name);
    }

    /**
     * Retrieves all objects from the repository.
     *
     * @return A list of all objects in the repository.
     */
    public List<Produkt> getAll() {
        return data.values().stream().toList();
    }
}
