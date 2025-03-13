package exo1;

/**
 * Implements an SMS sending Service.
 */
class BasicSMSService implements MessageService {
    @Override
    public void sendMessage(Contact contact, String message) {
        System.out.println("Sending a SMS to " + contact.getName() + ": " + message);
    }
}
