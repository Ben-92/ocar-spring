package co.simplon.ocar.service;

import co.simplon.ocar.model.Client;
import co.simplon.ocar.model.Offer;
import co.simplon.ocar.repository.OfferRepository;
import co.simplon.ocar.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{

    private ClientRepository clientRepository;
    private OfferRepository offerRepository;

    public ClientServiceImpl(ClientRepository clientRepository,
                             OfferRepository offerRepository){
        this.clientRepository = clientRepository;
        this.offerRepository = offerRepository;
    }

    @Override
    public Offer createOffer(Long clientId, Offer offerToCreate) {
        Optional<Client> client = clientRepository.findById(clientId);

        if (client.isPresent()) {
            offerToCreate.setClient(client.get());
            return offerRepository.save(offerToCreate);
        } else {
            // On devrait renvoyer une exception
            return null;
        }
    }
}
