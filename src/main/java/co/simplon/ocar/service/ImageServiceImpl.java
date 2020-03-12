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

    public void addImage(Image imageToAdd) {
        imageRepository.save(imageToAdd);
    }

    @Override
    public Optional<Image> getImageByName(String imageName) {
        return imageRepository.findByName(imageName);
    }
}
