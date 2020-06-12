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
