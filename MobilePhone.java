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
}
