package exo1;

/**
 * Defines the contract for messages operations.
 * This interface follows the Interface Segregation Principle because it only handles message-related functionality.
 */
interface MessageService {
    void sendMessage(Contact contact, String message);
}
