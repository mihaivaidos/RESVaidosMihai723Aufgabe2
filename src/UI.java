// UI
import Model.Character;
import Model.Produkt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {

    private final Controller controller;
    private final Scanner scanner = new Scanner(System.in);

    public UI(Controller controller) {
        this.controller = controller;
    }

    /**
     * Function that starts the user interface of the application.
     * and handles all the user input.
     */
    public void run() {
        while (true) {
            System.out.println("1. Product Operations");
            System.out.println("2. Character Operations");
            System.out.println("3. First filter");
            System.out.println("4. Second filter");
            System.out.println("5. Third filter");
            System.out.println("0. Exit");

            int option = Integer.parseInt(scanner.nextLine());

            try {
                switch (option) {
                    case 1:
                        //manage first object a)
                        manageNameObj();
                        break;
                    case 2:
                        // manage second object b)
                        manageIDObj();
                        break;
                    case 3:
                        // subpunctu c)
                        filterCharacterByHerkunftsort();
                        break;
                    case 4:
                        // subpunctu d)
                        filterCharacterByProdDorf();
                        break;
                    case 5:
                        // subpunctu e)
                        sortCharacterProdByPrice();
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option, try again");
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid option");
            }
        }
    }

    /**
     * Method that handles the CRUD operation for the products
     */
    private void manageNameObj() {
        while (true) {
            System.out.println("1. Add");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Get All");
            System.out.println("5. Get by name");
            System.out.println("0. Back");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter the name of the product: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter the price of the product: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter the region: ");
                    String region = scanner.nextLine();
                    controller.addProduct(name, price, region);
                    System.out.println("Added!");
                    break;
                case 2:
                    controller.getAllProducts().forEach(System.out::println);
                    System.out.println("Enter the name of the object you want to update: ");
                    String updateName = scanner.nextLine();
                    System.out.println("Enter the price: ");
                    double updatePrice = Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter the region: ");
                    String updateRegion = scanner.nextLine();
                    controller.updateProduct(updateName, updatePrice, updateRegion);
                    System.out.println("Object with name " + updateName + " updated!");
                    break;
                case 3:
                    controller.getAllProducts().forEach(System.out::println);
                    System.out.println("Enter the name you want to delete: ");
                    String nameDel = scanner.nextLine();
                    controller.deleteProduct(nameDel);
                    System.out.println("Object with name " + nameDel + " deleted!");
                    break;
                case 4:
                    controller.getAllProducts().forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Enter the name: ");
                    String nameGet = scanner.nextLine();
                    System.out.println(controller.getProduct(nameGet));
                    break;
                case 0:
                    return;
                default: System.out.println("Invalid option, try again");
                    break;
            }
        }
    }

    /**
     * Method that handles the CRUD operation for the character
     */
    private void manageIDObj() {
        while (true) {
            System.out.println("1. Add character");
            System.out.println("2. Update character");
            System.out.println("3. Delete character");
            System.out.println("4. Get All character");
            System.out.println("5. Get by ID character");
            System.out.println("0. Back");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter the name of the character: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter the herkunftsdorf of the character: ");
                    String herkunftsdorf = scanner.nextLine();
                    List<Produkt> produktList = new ArrayList<>();
                    controller.getAllProducts().forEach(System.out::println);
                    while (true){
                        System.out.println("Enter character product: ");
                        String prod = scanner.nextLine();
                        if(prod.isEmpty()){
                            break;
                        }
                        else {
                            produktList.add(controller.getProduct(prod));
                        }
                    }
                    System.out.println("Da");
                    controller.addCharacter(name,herkunftsdorf,produktList);
                    System.out.println("Added");
                    break;
                case 2:
                    controller.getAllCharacters().forEach(System.out::println);
                    System.out.println("Enter the id of the object you want to update: ");
                    int updateID = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the name of the product: ");
                    String nameUpt = scanner.nextLine();
                    System.out.println("Enter the herkunftsort: ");
                    String herkunftsortUpt = scanner.nextLine();
                    List<Produkt> prodList = new ArrayList<>();
                    while (true){
                        System.out.println("Enter character product: ");
                        String prod = scanner.nextLine();
                        if(prod.isEmpty()){
                            break;
                        }
                        else {
                            prodList.add(controller.getProduct(prod));
                        }
                    }
                    controller.updateCharacter(updateID, nameUpt, herkunftsortUpt, prodList);
                    System.out.println("Object with id: " + updateID + " updated!");
                    break;
                case 3:
                    controller.getAllCharacters().forEach(System.out::println);
                    System.out.println("Enter the id you want to delete: ");
                    int idDel = Integer.parseInt(scanner.nextLine());
                    controller.deleteCharacter(idDel);
                    System.out.println("Object with id: " + idDel + " deleted!");
                    break;
                case 4:
                    controller.getAllCharacters().forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Enter the id: ");
                    int idGet = Integer.parseInt(scanner.nextLine());
                    System.out.println(controller.getCharacter(idGet));
                    break;
                case 0:
                    return;
                default: System.out.println("Invalid option, try again");
                    break;
            }
        }
    }

    private void filterCharacterByHerkunftsort() {
        System.out.println("Enter a herkunftsort: ");
        String herkunftsort = scanner.nextLine();
        controller.filterCharacterByHerkunftsort(herkunftsort).stream().map(Character::getName).forEach(System.out::println);
    }

    private void sortCharacterProdByPrice() {
        controller.getAllCharacters().forEach(System.out::println);
        System.out.println("Enter a character ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the sorting mode (asc/desc): ");
        String type = scanner.nextLine();
        switch (type){
            case "asc" -> controller.sortCharacterProdByPrice(id,"asc").stream().map(p -> p.getName() + " - " + p.getPrice()).forEach(System.out::println);
            case "desc" -> controller.sortCharacterProdByPrice(id,"desc").stream().map(p -> p.getName() + " - " + p.getPrice()).forEach(System.out::println);
        }
    }

    private void filterCharacterByProdDorf() {
        System.out.println("Enter a region: ");
        String region = scanner.nextLine();
        controller.filterCharacterByProdRegion(region).stream().map(Character::getName).forEach(System.out::println);
    }

}
