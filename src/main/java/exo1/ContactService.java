package exo1;

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

    public ContactService(ContactRepository repository, MessageService messageService) {
        this.repository = repository;
        this.messageService = messageService;
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

}
