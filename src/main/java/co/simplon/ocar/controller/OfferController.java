package co.simplon.ocar.controller;

import co.simplon.ocar.model.Image;
import co.simplon.ocar.model.Offer;
import co.simplon.ocar.service.OfferService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
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
//    @GetMapping
//    public List<Offer> getOfferList() {
//        return this.offerService.getOfferList();
//    }

    @GetMapping
    public Page<Offer> getOfferList(
           @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
           @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
           @Valid @RequestParam(value = "sort", required = false) String criteria,
           @Valid @RequestParam(value = "direction", required = false) String direction) {

        return offerService.getOfferList(pageNumber, pageSize, criteria, direction);
    }



    /**
     * getting filtered list of offers
     * @param lowestPrice minimum price criteria
     * @param highestPrice maximum price criteria
     * @return
     */
    @GetMapping("/filter")

    public List<Offer> getFilteredOffer(@RequestParam String lowestBrand,
                                        @RequestParam String highestBrand,
                                        @RequestParam String lowestModel,
                                        @RequestParam String highestModel,
                                        @RequestParam Integer lowestPostCode,
                                        @RequestParam Integer highestPostCode,
                                        @RequestParam String lowestYear,
                                        @RequestParam String highestYear,
                                        @RequestParam String gearbox,
                                        @RequestParam Integer lowestPrice,
                                        @RequestParam Integer highestPrice){

            return offerService.getFilteredOffer(lowestBrand, highestBrand, lowestModel, highestModel,
                    lowestPostCode, highestPostCode, lowestYear, highestYear, gearbox, lowestPrice, highestPrice);

    }

    /**
     * getting a specific offer
     * @param offerId id of the offer to retrieve data from
     * @return a ResponseEntity with the Offer retrieved
     */
    @GetMapping("/{offerId}")
    public ResponseEntity<Offer> getOfferById(@PathVariable Long offerId){

        Optional<Offer> offer = offerService.getOfferById(offerId);

        if (offer.isPresent()){
            return ResponseEntity.ok(offer.get());
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * persist a new Image to a specific Offer
     * @param offerId the added will be saved to this Offer Id
     * @param file The Image to save
     * @return A ResponseEntity with the Image saved
     * @throws IOException
     */
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
