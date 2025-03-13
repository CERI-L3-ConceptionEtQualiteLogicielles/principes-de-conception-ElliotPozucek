package exo1;

public class XmlFormatter implements ContactFormatter {
    @Override
    public String formatContact(Contact contact) {
        return "<contact<\n" +
                "  <name>" + contact.getName() + "</name>" +
                "  <phoneNumber>" + contact.getPhoneNumber() + "</phoneNumber" +
                "</contact>";
    }
}
