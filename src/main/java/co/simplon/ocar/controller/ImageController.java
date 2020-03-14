package co.simplon.ocar.controller;

import co.simplon.ocar.model.Image;
import co.simplon.ocar.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/images")
@CrossOrigin("*")
public class ImageController {

ImageService imageService ;

    public ImageController (ImageService imageService) {
        this.imageService = imageService;
    }

    //à deleter ainsi que la méthode appellée
    @PostMapping
    public ResponseEntity<Image> addImage(@RequestParam("imageFile") MultipartFile file) throws IOException {

        Image img = new Image(file.getOriginalFilename(), file.getContentType(),file.getBytes());
        imageService.addImage(img);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/name/{imageName}")
    public ResponseEntity<Image> getImageByName(@PathVariable("imageName") String imageName){
        Optional<Image> optionalImageByName = imageService.getImageByName(imageName);
        if (optionalImageByName.isPresent()){
            return ResponseEntity.ok(optionalImageByName.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
