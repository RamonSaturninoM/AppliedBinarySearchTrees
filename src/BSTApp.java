import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BSTApp {
    
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        readFile("src/Person.txt", tree);

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = sc.nextInt();
            sc.nextLine();

            processMenu(tree, sc, choice);

        } while (choice != 7);
        sc.close();
    }
    
    private static void readFile(String filename, BinarySearchTree tree){
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Person person = new Person(parts[0].trim(), parts[1].trim(), parts[2].trim());
                    tree.insert(person);
                }
            }
            System.out.println("Data Loaded from persons.txt");
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        }
    }
    
    private static void addNewEntry(BinarySearchTree tree, Scanner sc){
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.print("Enter phone: ");
        String phone = sc.nextLine();

        Person newPerson = new Person(name, address, phone);
        tree.insert(newPerson);
        System.out.println("Contact added successfully.");
    }
    
    private static void displayMenu(){
        System.out.println("MENU:");
        System.out.println("1. Display Contacts (Sorted)");
        System.out.println("2. Search Contact");
        System.out.println("3. Count Total Contacts");
        System.out.println("4. Find BST Height");
        System.out.println("5. Find Min & Max Name");
        System.out.println("6. Add New Contact");
        System.out.println("7. Exit");
        System.out.print("Choose an option: ");
    }
    
    private static void processMenu(BinarySearchTree tree, Scanner sc, int choice){
        switch (choice) {
            case 1:
                System.out.println("\nContacts (Sorted):");
                System.out.printf("%-20s %-30s %-15s\n", "Name", "Address", "Phone"); // Header
                tree.inorderTraversal();
                System.out.println("");
                break;
            case 2:
                System.out.print("Enter name to search: ");
                String searchName = sc.nextLine();
                Person foundPerson = tree.search(searchName);
                if (foundPerson != null) {
                    System.out.println("Contact found:");
                    System.out.println(foundPerson);
                } else {
                    System.out.println("Contact not found.");
                }
                System.out.println("");
                break;
            case 3:
                System.out.println("Total contacts: " + tree.countNodes());
                System.out.println("");
                break;
            case 4:
                System.out.println("BST height: " + tree.height());
                System.out.println("");
                break;
            case 5:
                Person minPerson = tree.findMin();
                Person maxPerson = tree.findMax();
                if (minPerson != null && maxPerson != null) {
                    System.out.println("Min Name: " + minPerson.name);
                    System.out.println("Max Name: " + maxPerson.name);
                } else {
                    System.out.println("No contacts in the tree.");
                }
                System.out.println("");
                break;
            case 6:
                addNewEntry(tree, sc);
                break;
            case 7:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
