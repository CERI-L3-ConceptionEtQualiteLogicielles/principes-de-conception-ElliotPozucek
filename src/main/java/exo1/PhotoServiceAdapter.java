package exo1;

import java.awt.Image;

/**
 * The class adapts ServicePhotoSending to fit PhotoService interface.
 * We do this because we cannot modify the pre-existing class ServicePhotoSending in order
 * to respect the Dependency Inversion Principle.
 */
public class PhotoServiceAdapter implements PhotoService {
    private ServicePhotoSending servicePhotoSending;

    public PhotoServiceAdapter(ServicePhotoSending photoSending) {
        this.servicePhotoSending = photoSending;
    }

    @Override
    public void sendPhoto(Contact contact, Image image) {
        servicePhotoSending.sendPhoto(contact, image);
    }
}
