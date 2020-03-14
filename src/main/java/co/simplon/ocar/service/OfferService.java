package co.simplon.ocar.service;

import co.simplon.ocar.model.Image;
import co.simplon.ocar.model.Offer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OfferService {

    List<Offer> getOfferList();

    Optional<Offer> getOfferById(Long carId);

    List<Offer> getFilteredOffer(String brand, Integer lowestPrice, Integer highestPrice);

    void addImageToOffer(Long offerId, Image imageToAdd);
}
