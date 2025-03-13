package exo1;

/**
 * Implements an email sending service.
 * This class follows the Open/Closed Principle because new email implementations can be added without modifying existing code.
 */
class BasicEmailService implements MessageService {
    @Override
    public void sendMessage(Contact contact, String message) {
        System.out.println("Sending email to " + contact.getName() + ": " + message);
    }
}
