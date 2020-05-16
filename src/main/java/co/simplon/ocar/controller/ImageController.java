package co.simplon.ocar.controller;

import co.simplon.ocar.model.Image;
import co.simplon.ocar.service.ImageService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/images")
@CrossOrigin("*")
public class ImageController {

ImageService imageService ;

    public ImageController (ImageService imageService) {
        this.imageService = imageService;
    }

//    /**
//     * getting an image by its name
//     * @param imageName name of the image
//     * @return an Offer ResponseEntity type
//     */
//    @GetMapping("/name/{imageName}")
//    public ResponseEntity<Image> getImageByName(@PathVariable("imageName") String imageName){
//        Optional<Image> optionalImageByName = imageService.getImageByName(imageName);
//        if (optionalImageByName.isPresent()){
//            return ResponseEntity.ok(optionalImageByName.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @DeleteMapping("/{imageId}")
    public ResponseEntity<Image> deleteImage (@PathVariable Long imageId){
        boolean isDeleted = imageService.deleteImage(imageId);

        if (isDeleted){
            return ResponseEntity.noContent().build();
        } else
            return ResponseEntity.notFound().build();
    }
}
