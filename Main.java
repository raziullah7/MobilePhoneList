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
                case 0 -> {
                    System.out.println("Shutting Down . . .");
                    quit = true;
                }
                case 1 -> mobilePhone.printContacts();
                case 2 -> addNewContact();
                case 3 -> updateContact();
                case 4 -> removeContact();
                case 5 -> queryContact();
                case 6 -> printActions();
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

    // method to update(override) an existing contact
    private static void updateContact() {
        System.out.println("Enter existing contact name :");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Enter new name :");
        String newName = scanner.nextLine();
        System.out.println("Enter new number : ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if (mobilePhone.updateContact(existingContactRecord, newContact))
            System.out.println("Successfully updated contact.");
        else
            System.out.println("Error updating contact.");
    }

    // method to remove an existing contact
    private static void removeContact() {
        System.out.println("Enter existing contact name :");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        if (mobilePhone.removeContact(existingContactRecord))
            System.out.println("Successfully deleted contact.");
        else
            System.out.println("Error deleting contact.");
    }

    // method to query if a contact exists or not
    private static void queryContact() {
        System.out.println("Enter existing contact name :");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Name : "+ existingContactRecord.getName() +" Phone Number : "+ existingContactRecord.getPhoneNumber());
    }

    // method to start up the phone
    private static void startPhone() {
        System.out.println("Starting Phone  . . .");
    }

    // method to print all available options
    private static void printActions() {
        System.out.println("""
                Available Actions : (Press)
                0 -- To shutdown
                1 -- To print contacts
                2 -- To add a new contact
                3 -- To update an existing contact
                4 -- To remove an existing contact
                5 -- To query if a contact exists or not
                6 -- To print the list of available actions
                """);
    }
}
