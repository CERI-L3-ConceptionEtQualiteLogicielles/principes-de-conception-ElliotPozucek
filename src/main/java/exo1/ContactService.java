package exo1;

import java.awt.Image;

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
    /**
     * Represents the messaging service. It could be an instance of BasicEmailService or BasicSMSService.
     */
    private MessageService messageService;
    /**
     * Represents an implementation of the photo service implementation.
     */
    private PhotoService photoService;
    /**
     * Represents the implementation of the formatter for contacts.
     */
    private ContactFormatter contactFormatter;

    public ContactService(ContactRepository repository,
                          MessageService messageService,
                          PhotoService photoService,
                          ContactFormatter contactFormatter) {
        this.repository = repository;
        this.messageService = messageService;
        this.photoService = photoService;
        this.contactFormatter = contactFormatter;
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

    public void sendMessageToContact(Contact contact, String message) {
        messageService.sendMessage(contact, message);
    }

    public void sendPhotoToContact(Contact contact, Image image) {
        photoService.sendPhoto(contact, image);
    }

}
