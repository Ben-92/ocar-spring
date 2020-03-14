package co.simplon.ocar.controller;

import co.simplon.ocar.model.Image;
import co.simplon.ocar.model.Offer;
import co.simplon.ocar.service.OfferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/offers")
@CrossOrigin("*")
public class OfferController {

    private OfferService offerService;

    public OfferController(OfferService offerService){
        this.offerService = offerService;
    }

    /**
     * getting list of all offers
     * @return list of offers in database
     */
    @GetMapping
    public List<Offer> getOfferList() {
        return this.offerService.getOfferList();
    }

    /**
     * getting filtered list of offers
     * @param lowestPrice minimum price criteria
     * @param highestPrice maximum price criteria
     * @return
     */
    @GetMapping("/filter")
    public List<Offer> getFilteredOffer(@RequestParam String brand,
                                        @RequestParam Integer lowestPrice,
                                        @RequestParam Integer highestPrice){
        return offerService.getFilteredOffer(brand, lowestPrice, highestPrice);
    }

    /**
     * getting a specific offer
     * @param offerId id of the offer to retrieve data from
     * @return a specific offer
     */
    @GetMapping("/{offerId}")
    public ResponseEntity<Offer> getOfferById(@PathVariable Long offerId){

        Optional<Offer> offer = offerService.getOfferById(offerId);

        if (offer.isPresent()){
            return ResponseEntity.ok(offer.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("{offerId}/images")
    public ResponseEntity<Image> addImage(  @PathVariable Long offerId,
                                            @RequestParam("imageFile") MultipartFile file)
                                            throws IOException {

        Image img = new Image(  file.getOriginalFilename(),
                                file.getContentType(),
                                file.getBytes());

        offerService.addImageToOffer(offerId, img);
        return ResponseEntity.ok().build();
    }

}
