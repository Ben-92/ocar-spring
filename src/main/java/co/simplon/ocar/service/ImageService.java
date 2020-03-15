package co.simplon.ocar.service;

import co.simplon.ocar.model.Image;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ImageService {


Optional<Image> getImageByName (String imageName);

}
