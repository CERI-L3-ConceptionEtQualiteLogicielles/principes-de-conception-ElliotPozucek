package exo1.init;

public interface ContactServiceInit {
    void addContact(ContactInit contact);
    void removeContact(ContactInit contact);
    void sendEmail(ContactInit contact, String message);
    void displayContacts();
}