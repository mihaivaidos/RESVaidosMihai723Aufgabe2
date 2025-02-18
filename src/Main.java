import Model.Character;
import Model.Produkt;
import Repo.ObjectWithIDRepo;
import Repo.ObjectWithNameRepo;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ObjectWithNameRepo productRepo = new ObjectWithNameRepo();
        ObjectWithIDRepo characterRepo = new ObjectWithIDRepo();

        Produkt p1 = new Produkt("Kunai", 50.0, "Konoha");
        Produkt p2 =new Produkt("Shuriken", 30.0, "Konoha");
        Produkt p3 = new Produkt("Schwert", 200.0, "Kirigakure");
        Produkt p4 = new Produkt("Heiltrank", 100.0, "Sunagakure");
        Produkt p5 = new Produkt("Sprengsiegel", 75.0, "Iwagakure");
        Produkt p6 = new Produkt("Riesenfächer", 300.0, "Sunagakure");
        Produkt p7 = new Produkt("Giftklinge", 150.0, "Kirigakure");
        Produkt p8 = new Produkt("Explosionskugel", 250.0, "Iwagakure");
        Produkt p9 = new Produkt("Schattendolch", 180.0, "Konoha");
        Produkt p10 = new Produkt("Wasserperle", 90.0, "Kirigakure");

        List<Produkt> listC1 = List.of(p1, p4, p9, p6);
        Character c1 = new Character(1, "Naruto Uzumaki", "Konoha", listC1);

        List<Produkt> listC2 = List.of(p3, p5, p7, p2);
        Character c2 = new Character(2, "Gaara", "Sunagakure", listC2);

        List<Produkt> listC3 = List.of(p2, p3, p4, p8, p10);
        Character c3 = new Character(3, "Kisame Hoshigaki", "Kirigakure", listC3);

        List<Produkt> listC4 = List.of(p1, p5, p8, p10);

        Character c4 = new Character(4, "Deidara", "Iwagakure", listC4);

        List<Produkt> listC5 = List.of(p9, p7, p3, p8);
        Character c5 = new Character(5, "Itachi Uchiha", "Konoha", listC5);

        productRepo.add(p1);
        productRepo.add(p2);
        productRepo.add(p3);
        productRepo.add(p4);
        productRepo.add(p5);
        productRepo.add(p6);
        productRepo.add(p7);
        productRepo.add(p8);
        productRepo.add(p9);
        productRepo.add(p10);

        characterRepo.add(c1);
        characterRepo.add(c2);
        characterRepo.add(c3);
        characterRepo.add(c4);
        characterRepo.add(c5);

        Controller controller = new Controller(characterRepo, productRepo);
        UI ui = new UI(controller);

        ui.run();

    }
}