package exo1;

/**
 * Represents a Contact with a name and phone number.
 * This class follows the Single Responsibility Principle because it only stores contact details.
 */
public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", Phone Number: " + getPhoneNumber();
    }
}

