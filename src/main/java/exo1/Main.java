package exo1;

import java.awt.Image;

public class Main {
    public static void main(String[] args) {
        testMessages();
    }

    /**
     * Should never not work after adding a new functionality.
     */
    static void testMessages() {
        ContactRepository repository = new InMemoryContactRepository();
        MessageService messageService = new BasicSMSService(); // could also be BasicEmailService()
        PhotoService photoService = new PhotoServiceAdapter(new ServicePhotoSending()); // we use the adapter because we cannot modify the pre-existing class ServicePhotoSending

        ContactService contactService = new ContactService(repository, messageService, photoService);

        Contact alice = new Contact("Alice", "123-456");
        contactService.addContact(alice);

        contactService.displayContacts();
        contactService.sendMessageToContact(alice, "Hello Alice! ; via SMS"); // Sends an SMS

        Image dummyImage = null;
        contactService.sendPhotoToContact(alice, dummyImage);
    }
}
