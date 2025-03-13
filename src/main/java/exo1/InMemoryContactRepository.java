package exo1;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements an in-memory (ArrayList) storage for contacts.
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
