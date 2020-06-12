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


    @DeleteMapping("/{imageId}")
    public ResponseEntity<Image> deleteImage (@PathVariable Long imageId){
        boolean isDeleted = imageService.deleteImage(imageId);

        if (isDeleted){
            return ResponseEntity.noContent().build();
        } else
            return ResponseEntity.notFound().build();
    }
}
