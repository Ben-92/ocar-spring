package co.simplon.ocar.controller;

import co.simplon.ocar.model.Offer;
import co.simplon.ocar.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * save a new offer for a given user
     * @param userId    id of the user who deposits the offer
     * @param offerToAdd    Offer deposited by the user
     * @return  an Offer ResponseEntity type
     */
    @PostMapping("/{userId}/offer")
    public ResponseEntity<Offer> addOfferToUser(@PathVariable Long userId, @RequestBody Offer offerToAdd) {
        Offer createdOffer = userService.createOfferToUser(userId, offerToAdd);
        if (createdOffer != null) {
            return ResponseEntity.ok(createdOffer);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
