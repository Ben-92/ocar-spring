package co.simplon.ocar.controller;

import co.simplon.ocar.model.Image;
import co.simplon.ocar.service.ImageService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;


@RestController
@RequestMapping("/api/images")
@CrossOrigin("*")
@ApiIgnore
public class ImageController {

ImageService imageService ;

    public ImageController (ImageService imageService) {
        this.imageService = imageService;
    }


    /**
     * Deleting an image from DB, given its Id
     * @param imageId id of the image to delete
     * @return status code 204 if deleted, 404 if image not found
     */
    @DeleteMapping("/{imageId}")
    public ResponseEntity<Image> deleteImage (@PathVariable Long imageId){
        boolean isDeleted = imageService.deleteImage(imageId);

        if (isDeleted){
            return ResponseEntity.noContent().build();
        } else
            return ResponseEntity.notFound().build();
    }
}
