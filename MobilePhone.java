import java.util.ArrayList;

public class MobilePhone {
    // fields
    private String myNumber;
    private ArrayList<Contact> myContacts;

    // constructor
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    // method to add new contacts
    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact already exists.");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    // method to update an old contact, which replaces the old contact with soe new one
    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + " was not found.");
            return false;
        }
        myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }

    // method to delete a method from the contact list
    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            System.out.println(contact.getName() + " was not found.");
            return false;
        }
        myContacts.remove(foundPosition);
        System.out.println(contact.getName() + " was removed.");
        return true;
    }

    // method to check whether the contact already exists or not (using an object)
    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    // method to check whether the contact already exists or not (using the name field of object)
    private int findContact(String contactName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            if (contactName.equals(this.myContacts.get(i).getName()))
                return i;
        }
        return -1;
    }

    // method to check if a contact exists or not
    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    // method to print all contacts in the phone book
    public void printContacts() {
        System.out.println("Contact List :");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i+1) + ". " +
                    this.myContacts.get(i).getName() + " --> " +
                    this.myContacts.get(i).getPhoneNumber());
        }
    }
}
