import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("0039 330 4404");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();

        while (!quit) {
            System.out.println("\nEnter action : (6 available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Shutting Down . . .");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updatContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    updateContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }

    // method to add new contact
    private static void addNewContact() {
        System.out.println("Enter new contact name : ");
        String name = scanner.nextLine();
        System.out.println("Enter new contact phone number : ");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if (mobilePhone.addNewContact(newContact))
            System.out.println("New contact added : name =" + name + ", phone = " + phone);
        else
            System.out.println("Cannot add, " + name + " already on file");
    }

    // method to start up the phone
    private static void startPhone() {
        System.out.println("Starting Phone  . . .");
    }

    // method to print all available options
    private static void printActions() {
        System.out.println("""
                Available Action :
                Press 0 -- To shutdown
                1 -- To print contacts
                2 -- To add a new contact
                3 -- To update an existing contact
                4 -- To remove an existing contact
                5 -- To query if a contact exists or not
                6 -- To print the list of available actions
                """);
        System.out.println("Choose your action :");
    }
}
