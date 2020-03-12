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
