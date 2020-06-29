package co.simplon.ocar.service;

import co.simplon.ocar.model.Image;
import co.simplon.ocar.repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService{

    ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository){
        this.imageRepository = imageRepository;
    }


    /**
     * deleting an image
     * @param idImageToDelete id of the image to delete
     * @return boolean true if image deleted. false if no image with this id is present in database
     */
    @Override
    public boolean deleteImage(Long idImageToDelete) {

        Optional<Image> imageToDelete = imageRepository.findById(idImageToDelete);
        if (imageToDelete.isPresent()){
            imageRepository.deleteById(idImageToDelete);
            return true;
        } else {
            return false;
        }
    }

}
