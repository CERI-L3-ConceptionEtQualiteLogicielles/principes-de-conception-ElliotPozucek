# SOLID Principles Violation in Contact class


## 1. Single Responsibility Principle

### Definition
A class should have only one reason to change, meaning it should only have one job. <br>
The modification of a particular feature should only affect the behaviour of the feature and nothing else.

### Violation
The Contact class handles multiples features (too many responsibilities) :
- storing contact details
- managing the list of contact
- displaying contacts
- sending emails

### Fix
The responsibilities are split into separate classes :
- `Contact` : stores contact details
- `ContactRepository` & `MemoryContactRepository` : manage the contact storage
- `ContactService` : handles contact operations
- `EmailService` : handles emails


## 2. Open/Closed Principle

### Definition
A class should be open for extension but closed for modification. <br>
The behaviour of a class should be extended without modifying existing code.

### Violation
If it is needed to change how contacts are stored (for example, from a list to a database), the `Contact` class would have to be modified.<br>
If a new email system is needed, it would be needed to change `Contact`.

### Fix
- `ContactRepository` : any way of storing data can be created without modifying `Contact`
- `EmailService` : any way of sending email can be created without changing `Contact`

## 3. Liskov Substitution Principle

### Definition
Subclasses should be replaceable for their parent class without breaking the code.

### Violation
If `Contact` was subclassed for a specific type of contact, they might not behave like a 'normal' `Contact`.<br>
For example, `FavoriteContact` could have a different way of storing contact. The `Contact` class would not allow this behaviour, resulting in breaking the program.

### Fix
`Contact` is now a data model. Any subclass would be valid. The storage logic moved to `ContactRepository`.

## 4. Interface Segregation Principle
A class should not be forced to implement methods it does not use.

### Violation
`ContactService` interface forced the implementation of email-related methods, meaning every class implementation had to handle emails, even if they did not need to.

### Fix
Storage logic (`ContactRepository` interface) separated from email logic (`EmailService` interface).

## 5. Dependency Inversion Principle

### Definition
High-level modules should depend on abstractions, not concrete classes.

### Violation
- `ContactService` directly manages `Contact` storage using `ArrayList`
- `Contact` has database logic hardcoded `saveInDB`

### Fix
- `ContactService` now depends on `ContactRepository` in order to handle multiple storage implementation.









