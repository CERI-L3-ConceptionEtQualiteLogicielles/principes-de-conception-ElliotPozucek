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
        ContactFormatter contactFormatter = new JsonFormatter(); // could be JsonFormatter or XmlFormatter

        ContactService contactService = ContactService.getInstance(repository, messageService, photoService, contactFormatter);

        Contact contact1 = new Contact.ContactBuilder("Lauret", "0606060606")
                .setFirstName("Alice")
                .setEmail("alice.extra@yahoo.com")
                .build();

        Contact contact2 = new Contact.ContactBuilder("Paters", "0612345678")
                .setFirstName("Téo")
                .setCity("Orgon")
                .setState("France")
                .setWorkplace("CERI")
                .build();

        // Add the contacts to the repository passed in contactService
        contactService.addContact(contact1);
        contactService.addContact(contact2);

        // We used the TextFormatter
        contactService.displayContacts();

        contactService.sendMessageToContact(contact1, "Hello Alice!"); // sends an SMS

        Image dummyImage = null;
        contactService.sendPhotoToContact(contact2, dummyImage); // sends an image
    }
}
