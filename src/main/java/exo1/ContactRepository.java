package exo1;

import java.util.List;

/**
 * Defines the contract for storing contacts.
 * This interface follows the Dependency Inversion Principle by abstracting storage logic from high-level modules.
 */
interface ContactRepository {
    void addContact(Contact contact);

    void removeContact(Contact contact);

    List<Contact> getAllContacts();
}
