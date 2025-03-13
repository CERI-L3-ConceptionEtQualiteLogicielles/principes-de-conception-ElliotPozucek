package exo1;

/**
 * Represents a Contact with a name and phone number.
 * This class follows the Single Responsibility Principle because it only stores contact details.
 * <p>The information are immutable and the constructor is private because we implement a builder pattern.</p>
 */
public class Contact {
    private final String name;
    private final String phoneNumber;
    private final String firstName;
    private final String email;
    private final String workplace;
    private final String city;
    private final String state;
    private final String birthday;

    /**
     * Constructor is private because we want the Contact class to be immutable.
     * Only name and phoneNumber are mandatory.
     * @param builder The builder which enforce immutability.
     */
    private Contact(ContactBuilder builder) {
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.firstName = builder.firstName;
        this.email = builder.email;
        this.workplace = builder.workplace;
        this.city = builder.city;
        this.state = builder.state;
        this.birthday = builder.birthday;
    }

    public String getName() {return name;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getFirstName() {return firstName;}
    public String getEmail() {return email;}
    public String getWorkplace() {return workplace;}
    public String getCity() {return city;}
    public String getState() {return state;}
    public String getBirthday() {return birthday;}

    @Override
    public String toString() {
        return "Contact{name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", workplace='" + workplace + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    /**
     * Inner Builder class.
     */
    public static class ContactBuilder {
        private final String name;
        private final String phoneNumber;
        private String firstName;
        private String email;
        private String workplace;
        private String city;
        private String state;
        private String birthday;

        /**
         * Constructor with mandatory fields.
         * @param name Name of the contact.
         * @param phoneNumber Phone number of the contact.
         */
        public ContactBuilder(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        /* All the following methods are used to add optional fields  */
        public ContactBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ContactBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public ContactBuilder setWorkplace(String workplace) {
            this.workplace = workplace;
            return this;
        }

        public ContactBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public ContactBuilder setState(String state) {
            this.state = state;
            return this;
        }

        public ContactBuilder setBirthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }
}

