//package co.simplon.ocar.service;
//
//import co.simplon.ocar.exception.ClientAlreadyExistsException;
//import co.simplon.ocar.model.Client;
//import co.simplon.ocar.model.Offer;
//import co.simplon.ocar.repository.OfferRepository;
//import co.simplon.ocar.repository.ClientRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class ClientServiceImpl implements ClientService{
//
//    private ClientRepository clientRepository;
//    private OfferRepository offerRepository;
//
//    public ClientServiceImpl(ClientRepository clientRepository,
//                             OfferRepository offerRepository){
//        this.clientRepository = clientRepository;
//        this.offerRepository = offerRepository;
//    }

//    @Override
//    public Optional<Client> getClientById(Long clientId){
//        return clientRepository.findById(clientId);
//    }
//
//    @Override
//    public Client createClient(Client clientToCreate)  {
//
//        /*checking for the already existing client credentials userName and email*/
//        Optional<Client> optionalClient =
//                clientRepository.findClientByUserNameAndEmail(clientToCreate.getUserName(), clientToCreate.getEmail());
//
//        if (optionalClient.isPresent()){
//            return optionalClient.get();
//            /*throw new ClientAlreadyExistsException();*/
//        } else {
//            return clientRepository.save(clientToCreate);
//        }
//    }

//    /**
//     * creating an Offer to a Client
//     * @param clientId  Id of the client
//     * @param offerToCreate Offer object to persist
//     * @return  the Offer created
//     */
//    @Override
//    public Offer createOfferToClient(Long clientId, Offer offerToCreate) {
//        Optional<Client> client = clientRepository.findById(clientId);
//
//        if (client.isPresent()) {
//            offerToCreate.setClient(client.get());
//            return offerRepository.save(offerToCreate);
//        } else {
//            // On devrait renvoyer une exception
//            return null;
//        }
//    }
//}
