package co.simplon.ocar.service;

import co.simplon.ocar.model.Offer;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {

    Offer createOffer(Long clientId, Offer offerToAdd);
}
