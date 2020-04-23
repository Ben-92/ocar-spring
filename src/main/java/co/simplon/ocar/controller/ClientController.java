//package co.simplon.ocar.controller;
//
//import co.simplon.ocar.model.Client;
//import co.simplon.ocar.model.Offer;
//import co.simplon.ocar.service.ClientService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/clients")
//@CrossOrigin("*")
//public class ClientController {
//
//    private ClientService clientService;
//
//    public ClientController(ClientService clientService){
//        this.clientService = clientService;
//    }

//    /**
//     * retrieving a client response entity, giving its Id
//     * @param clientId Id of the client
//     * @return a Client ResponseEntity type
//     */
//    @GetMapping("/{clientId}")
//    public ResponseEntity<Client> getClientById(@PathVariable Long clientId){
//
//        Optional<Client> client = clientService.getClientById(clientId);
//
//        if (client.isPresent()){
//            return ResponseEntity.ok(client.get());
//        }
//        return ResponseEntity.notFound().build();
//    }


//    /**
//     * request received just after being authenticated with external provider (like github)
//     * saving client if non existing and send it back to front
//     * sending existing client if already existing (username + email already existing)
//     * @param clientToCreate
//     * @return a Client ResponseEntity type
//     */
//    @PostMapping
//    public ResponseEntity<Client> addClientIfNonExisting (@RequestBody Client clientToCreate) {
//
//        Client createdOrExistingClient= clientService.createClient(clientToCreate);
//        if (createdOrExistingClient != null) {
//            return ResponseEntity.ok(createdOrExistingClient);
//        } else {
//            return ResponseEntity.badRequest().build();
//        }
//    }
//
//    /**
//     * save a new offer for a given client
//     * @param clientId id of the client who deposits the offer
//     * @param offerToAdd Offer deposited by the client
//     * @return an Offer ResponseEntity type
//     */
//    @PostMapping("/{clientId}/offer")
//    public ResponseEntity<Offer> addOfferToClient(@PathVariable Long clientId, @RequestBody Offer offerToAdd) {
//        Offer createdOffer = clientService.createOfferToClient(clientId, offerToAdd);
//        if (createdOffer != null) {
//            return ResponseEntity.ok(createdOffer);
//        } else {
//            return ResponseEntity.badRequest().build();
//        }
//    }
//}
