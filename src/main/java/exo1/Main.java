package exo1;

import org.junit.jupiter.api.Test;

public class Main {
    public static void main(String[] args) {
        testMessages();
    }

    static void testMessages() {
        ContactRepository repository = new InMemoryContactRepository();
        MessageService messageService = new BasicSMSService(); // could also be BasicEmailService()

        ContactService contactService = new ContactService(repository, messageService);

        Contact alice = new Contact("Alice", "123-456");
        contactService.addContact(alice);

        contactService.displayContacts();
        contactService.sendMessageToContact(alice, "Hello Alice! ; via SMS"); // Sends an SMS

        MessageService emailService = new BasicEmailService();
        ContactService emailContactService = new ContactService(repository, emailService);
        emailContactService.sendMessageToContact(alice, "Hi Alice! ; via email");
    }
}
