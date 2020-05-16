package co.simplon.ocar.controller;

import co.simplon.ocar.exception.OfferNotFoundException;
import co.simplon.ocar.model.Equipment;
import co.simplon.ocar.model.Image;
import co.simplon.ocar.model.Offer;
import co.simplon.ocar.service.OfferService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
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
     * retrieving a Page of existing Offers
     * @param pageNumber    number of the Page to retrieve
     * @param pageSize      number of Offers per page
     * @param criteria      sort criteria
     * @param direction     direction of sorting
     * @return  the result Page if existing
     */
    @GetMapping
    public Page<Offer> getOfferPage(
           @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
           @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
           @Valid @RequestParam(value = "sort", required = false) String criteria,
           @Valid @RequestParam(value = "direction", required = false) String direction) {

        return offerService.getOfferPage(pageNumber, pageSize, criteria, direction);
    }


    /**
     *
     * @param lowestBrand   Brand min value searched for
     * @param highestBrand  Brand max value searched for
     * @param lowestModel   Model min value searched for
     * @param highestModel  Model max value searched for
     * @param lowestPostCode    PostCode min value searched for
     * @param highestPostCode   PostCode max value searched for
     * @param lowestYear    Vehicle Year min value searched for
     * @param highestYear   Vehicle Year max value searched for
     * @param gearbox       gearbox value searched fo
     * @param lowestPrice   Vehicle price min value searched for
     * @param highestPrice  Vehicle price max value searched for
     * @param pageNumber    number of the Page to retrieve
     * @param pageSize      number of Offers per page
     * @param criteria      sort criteria
     * @param direction     direction of sorting
     * @return  the result Page if existing
     */
    @GetMapping("/filter")
    public Page<Offer> getFilteredOffer(
            @RequestParam String lowestBrand,
            @RequestParam String highestBrand,
            @RequestParam String lowestModel,
            @RequestParam String highestModel,
            @RequestParam Integer lowestPostCode,
            @RequestParam Integer highestPostCode,
            @RequestParam String lowestYear,
            @RequestParam String highestYear,
            @RequestParam String gearbox,
            @RequestParam Integer lowestPrice,
            @RequestParam Integer highestPrice,

            @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
            @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @Valid @RequestParam(value = "sort", required = false) String criteria,
            @Valid @RequestParam(value = "direction", required = false) String direction) {

        return offerService.getFilteredOffer(lowestBrand, highestBrand, lowestModel, highestModel,
                    lowestPostCode, highestPostCode, lowestYear, highestYear, gearbox, lowestPrice, highestPrice,
                pageNumber, pageSize, criteria, direction);

    }


    /**
     * getting a specific offer
     * @param offerId id of the offer to retrieve data from
     * @return an Offer ResponseEntity type
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
    public ResponseEntity<?> addImage(  @PathVariable Long offerId,
                                            @RequestParam("imageFile") MultipartFile file)
                                            throws IOException {

        Image img = new Image(  file.getOriginalFilename(),
                                file.getContentType(),
                                file.getBytes());

        try {
            offerService.addImageToOffer(offerId, img);
            return ResponseEntity.ok().build();
        } catch (OfferNotFoundException e){
            return ResponseEntity.notFound().build();
        }

    }

//    @PostMapping("{offerId}/images")
//    public ResponseEntity<Image> addImage(  @PathVariable Long offerId,
//                                            @RequestParam("imageFile") MultipartFile file)
//            throws IOException {
//
//        Image img = new Image(  file.getOriginalFilename(),
//                file.getContentType(),
//                file.getBytes());
//
//        offerService.addImageToOffer(offerId, img);
//        return ResponseEntity.ok().build();
//    }

    @PutMapping("{offerId}/equipments")
    public ResponseEntity<?> updateEquipmentToOffer(  @PathVariable Long offerId,
                                            @RequestBody List<Equipment> equipmentL)
    {

//        offerService.updateEquipmentToOffer(offerId, equipmentL);
//        return ResponseEntity.ok().build();

        try {
            offerService.updateEquipmentToOffer(offerId, equipmentL);
            return ResponseEntity.ok().build();
        } catch (OfferNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{offerId}")
    public ResponseEntity<Offer> deleteOffer (@PathVariable Long offerId){
        boolean isDeleted = offerService.deleteOffer(offerId);

        if (isDeleted){
            return ResponseEntity.noContent().build();
        } else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("/{offerId}")
    public ResponseEntity<Offer> updateOffer (@PathVariable Long offerId, @RequestBody Offer offerToUpdate) {

        try {
            Offer offerUpdated = offerService.updateOffer(offerId, offerToUpdate);
            return ResponseEntity.ok(offerUpdated);
        } catch (OfferNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

}

//    @PostMapping("{offerId}/equipments")
//    public ResponseEntity<?> addEquipment(  @PathVariable Long offerId,
//                                            @RequestBody List<Equipment> equipmentL)
//            {
//
//
//        offerService.addEquipmentToOffer(offerId, equipmentL);
//        return ResponseEntity.ok().build();
//    }
