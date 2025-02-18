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
                    controller.addObjWithName(name, price, region);
                    System.out.println("Added!");
                    break;
                case 2:
                    controller.getAllObjWithName().forEach(System.out::println);
                    System.out.println("Enter the name of the object you want to update: ");
                    String updateName = scanner.nextLine();
                    System.out.println("Enter the price: ");
                    double updatePrice = Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter the region: ");
                    String updateRegion = scanner.nextLine();
                    controller.updateObjWithName(updateName, updatePrice, updateRegion);
                    System.out.println("Object with name " + updateName + " updated!");
                    break;
                case 3:
                    controller.getAllObjWithName().forEach(System.out::println);
                    System.out.println("Enter the name you want to delete: ");
                    String nameDel = scanner.nextLine();
                    controller.deleteObjWithName(nameDel);
                    System.out.println("Object with name " + nameDel + " deleted!");
                    break;
                case 4:
                    controller.getAllObjWithName().forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Enter the name: ");
                    String nameGet = scanner.nextLine();
                    System.out.println(controller.getObjWithName(nameGet));
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
            System.out.println("1. Add");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Get All");
            System.out.println("5. Get by ID");
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
                     while (true){
                                System.out.println("Enter character product: ");
                                String prod = scanner.nextLine();
                                if(prod.isEmpty()){
                                    break;
                                }
                                else {
                                    produktList.add(controller.getObjWithName(prod));
                                }
                            }
                     controller.addObjWithID(name,herkunftsdorf,produktList);
                    break;
                case 2:
                    controller.getAllObjWithID().forEach(System.out::println);
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
                            prodList.add(controller.getObjWithName(prod));
                        }
                    }
                    controller.updateObjWithID(updateID, nameUpt, herkunftsortUpt, prodList);
                    System.out.println("Object with id: " + updateID + " updated!");
                    break;
                case 3:
                    controller.getAllObjWithID().forEach(System.out::println);
                    System.out.println("Enter the id you want to delete: ");
                    int idDel = Integer.parseInt(scanner.nextLine());
                    controller.deleteObjWithID(idDel);
                    System.out.println("Object with id: " + idDel + " deleted!");
                    break;
                case 4:
                    controller.getAllObjWithID().forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Enter the id: ");
                    int idGet = Integer.parseInt(scanner.nextLine());
                    System.out.println(controller.getObjWithID(idGet));
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
        controller.getAllObjWithID().forEach(System.out::println);
        System.out.println("Enter a character ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the sorting mode (asc/desc): ");
        String type = scanner.nextLine();
        switch (type){
            case "asc" -> controller.sortCharacterProdByPrice(id,"asc").forEach(System.out::println);
            case "desc" -> controller.sortCharacterProdByPrice(id,"desc").forEach(System.out::println);
        }

    }

}
