package exo1;

/**
 * Formats contact information as a String.
 */
public class TextFormatter implements ContactFormatter {
    @Override
    public String formatContact(Contact contact) {
        return "Name + " + contact.getName() + ", Phone number " + contact.getPhoneNumber();
    }
}
