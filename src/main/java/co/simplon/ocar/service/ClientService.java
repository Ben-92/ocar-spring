package co.simplon.ocar.service;

import co.simplon.ocar.model.Client;
import co.simplon.ocar.model.Offer;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ClientService {

    Optional<Client> getClientById(Long clientId);

    Client createClient (Client clientToCreate);

    Offer createOfferToClient(Long clientId, Offer offerToAdd);
}
