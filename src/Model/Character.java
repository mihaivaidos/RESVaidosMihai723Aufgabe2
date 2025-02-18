package Model;

import java.util.List;

public class Character {

    private int ID;
    private String name;
    private String herkunftsdorf;
    private List<Produkt> produkts;

    @Override
    public String toString() {
        return "Character{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", herkunftsdorf='" + herkunftsdorf + '\'' +
                ", produkts=" + produkts +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHerkunftsdorf() {
        return herkunftsdorf;
    }

    public void setHerkunftsdorf(String herkunftsdorf) {
        this.herkunftsdorf = herkunftsdorf;
    }

    public List<Produkt> getProdukts() {
        return produkts;
    }

    public void setProdukts(List<Produkt> produkts) {
        this.produkts = produkts;
    }

    public Character(int ID, String name, String herkunftsdorf, List<Produkt> produkts) {
        this.ID = ID;
        this.name = name;
        this.herkunftsdorf = herkunftsdorf;
        this.produkts = produkts;
    }
}
