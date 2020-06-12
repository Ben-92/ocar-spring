package co.simplon.ocar.controller;

import co.simplon.ocar.exception.OfferNotFoundException;
import co.simplon.ocar.exception.UserNotFoundException;
import co.simplon.ocar.model.Offer;
import co.simplon.ocar.model.Sale;
import co.simplon.ocar.model.User;
import co.simplon.ocar.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
@ApiIgnore
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
//    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<User> getUserById(@PathVariable Long userId){

        Optional<User> user = userService.getUserById(userId);

        if (user.isPresent()){

            return ResponseEntity.ok(user.get()); // maybe it would be possible here to select the fields, instead of JsonIgnore
        }
        return ResponseEntity.notFound().build();
    }


    /**
     * save a new offer for a given user
     * @param userId    id of the user who deposits the offer
     * @param offerToAdd    Offer deposited by the user
     * @return  an Offer ResponseEntity type
     */
    @PostMapping("/{userId}/offer")
    public ResponseEntity<Offer> addOfferToUser(@PathVariable Long userId, @RequestBody Offer offerToAdd) {

        try {
            Offer createdOffer = userService.createOfferToUser(userId, offerToAdd);
            return ResponseEntity.ok(createdOffer);
        } catch (UserNotFoundException e){
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/{userId}/sale")
    public ResponseEntity<Sale> addSaleToUser(@PathVariable Long userId,
                                              @RequestBody Sale saleToAdd,
                                              @RequestParam Long offerId) {

        try {
            Sale createdSale = userService.createSaleToUser(userId, saleToAdd, offerId);
            return ResponseEntity.ok(createdSale);
        } catch (UserNotFoundException e){
            return ResponseEntity.notFound().build();
        } catch (OfferNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }


}
