package co.simplon.ocar.controller;

import co.simplon.ocar.model.Offer;
import co.simplon.ocar.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin("*")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    /**
     * save a new offer for a given client
     * @param clientId id of the client who deposits the offer
     * @param offerToAdd Offer deposited by the client defined by id client
     * @return Offer created
     */
    @PostMapping("/{clientId}/offer")
    public ResponseEntity<Offer> addOfferToClient(@PathVariable Long clientId, @RequestBody Offer offerToAdd) {
        Offer createdOffer = clientService.createOffer(clientId, offerToAdd);
        if (createdOffer != null) {
            return ResponseEntity.ok(createdOffer);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
