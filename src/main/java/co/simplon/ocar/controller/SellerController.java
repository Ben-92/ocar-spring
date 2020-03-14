package co.simplon.ocar.controller;

import co.simplon.ocar.model.Offer;
import co.simplon.ocar.model.Seller;
import co.simplon.ocar.service.SellerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sellers")
@CrossOrigin("*")
public class SellerController {

    private SellerService sellerService;

    public SellerController(SellerService sellerService){
        this.sellerService = sellerService;
    }

    /**
     * save a new offer for a given seller
     * @param sellerId id of the seller who deposits the offer
     * @param offerToAdd Offer deposited by the seller defined by id seller
     * @return Offer created
     */
    @PostMapping("/{sellerId}/offer")
    public ResponseEntity<Offer> addOfferToSeller(@PathVariable Long sellerId, @RequestBody Offer offerToAdd) {
        Offer createdOffer = sellerService.createOffer(sellerId, offerToAdd);
        if (createdOffer != null) {
            return ResponseEntity.ok(createdOffer);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
