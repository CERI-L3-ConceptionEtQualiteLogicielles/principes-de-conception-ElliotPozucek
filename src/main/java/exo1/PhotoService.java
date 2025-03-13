package exo1;

import java.awt.Image;

/**
 * Defines the contract for sending photo operations.
 * Follows Interface Segregation Principle.
 */
public interface PhotoService {
    void sendPhoto(Contact contact, Image image);
}
