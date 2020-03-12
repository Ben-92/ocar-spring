package co.simplon.ocar.service;

import co.simplon.ocar.model.Offer;
import org.springframework.stereotype.Service;

@Service
public interface SellerService {

    Offer createOffer(Long sellerId, Offer offerToAdd);
}
