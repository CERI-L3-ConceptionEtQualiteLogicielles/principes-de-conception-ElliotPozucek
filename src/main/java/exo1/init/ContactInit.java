package exo1.init;

import java.util.ArrayList;
import java.util.List;

public class ContactInit implements ContactServiceInit {
    private static List<ContactInit> contacts = new ArrayList<>();
    private String name;
    private String number;

    public ContactInit(String name, String number) {
        this.name = name;
        this.number = number;
        contacts.add(this);
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getInfoContact() {
        return "Name: " + getName() + ", Number: " + getNumber();
    }

    public void addContact(ContactInit contact) {
        contacts.add(contact);
    }

    public void removeContact(ContactInit contact) {
        contacts.remove(contact);
    }

    public void displayContacts() {
        for (ContactInit contact : contacts) {
            System.out.println("Name: " + contact.getName() + ", Number: " + contact.getNumber());
        }
    }

    public void saveInDB() {
        // logic for saving contacts in database
    }

    public void sendEmail(ContactInit contact, String message) {
        // logic for sending email
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", Number: " + getNumber();
    }
}

