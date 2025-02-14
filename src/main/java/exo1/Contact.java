package exo1;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Contact with a name and phone number.
 * This class follows the Single Responsibility Principle because it only stores contact details.
 */
public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", Phone Number: " + getPhoneNumber();
    }
}

/**
 * Defines the contract for storing contacts.
 * This interface follows the Dependency Inversion Principle by abstracting storage logic from high-level modules.
 */
interface ContactRepository {
    void addContact(Contact contact);
    void removeContact(Contact contact);
    List<Contact> getAllContacts();
}

/**
 * Implements an in-memory (List) storage for contacts.
 * This class follows the Open/Closed Principle since new storage implementations can be created without modifying existing code.
 */
class InMemoryContactRepository implements ContactRepository {
    private List<Contact> contacts = new ArrayList<>();

    @Override
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts);
    }
}

/**
 * Provides contact management operations.
 * <p>This class follows the Dependency Inversion Principle by depending on the
 * ContactRepository interface instead of a specific storage implementation.</p>
 * Specifically, this class delegates specific storage operations to the implementation of ContactRepository.
 *
 * @see ContactRepository
 */
class ContactService {
    /**
     * A repository represents the memory implementation. It could be a database, or a List in this project.
     */
    private ContactRepository repository;

    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    public void addContact(Contact contact) {
        repository.addContact(contact);
    }

    public void removeContact(Contact contact) {
        repository.removeContact(contact);
    }

    public void displayContacts() {
        for (Contact contact : repository.getAllContacts()) {
            System.out.println(contact);
        }
    }
}

/**
 * Defines the contract for email operations.
 * This interface follows the Interface Segregation Principle because it only handles email-related functionality.
 */
interface EmailService {
    void sendEmail(Contact contact, String message);
}

/**
 * Implements an email sending service.
 * This class follows the Open/Closed Principle because new email implementations can be added without modifying existing code.
 */
class BasicEmailService implements EmailService {
    @Override
    public void sendEmail(Contact contact, String message) {
        System.out.println("Sending email to " + contact.getName() + ": " + message);
    }
}
