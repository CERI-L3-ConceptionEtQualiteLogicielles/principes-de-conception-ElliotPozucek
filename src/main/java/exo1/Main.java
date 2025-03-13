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
        ContactFormatter contactFormatter = new TextFormatter(); // could be JsonFormatter or XmlFormatter

        ContactService contactService = new ContactService(repository, messageService, photoService, contactFormatter);

        Contact contact1 = new Contact.ContactBuilder("Extra", "123-456")
                .setFirstName("Alice")
                .setEmail("alice.extra@yahoo.com")
                .build();

        contactService.addContact(contact1);
        contactService.displayContacts();
        contactService.sendMessageToContact(contact1, "Hello Alice! ; via SMS"); // Sends an SMS
        Image dummyImage = null;
        contactService.sendPhotoToContact(contact1, dummyImage);
    }
}
