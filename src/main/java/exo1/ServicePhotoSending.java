package exo1;

import java.awt.Image;

/**
 * We assume this class existed before the creation of PhotoService interface.
 */
public class ServicePhotoSending {
    public void sendPhoto(Contact contact, Image image) {
        System.out.println("Sending photo to " + contact.getName());
    }
}
