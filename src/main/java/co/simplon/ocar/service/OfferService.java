package co.simplon.ocar.service;

import co.simplon.ocar.model.Image;
import co.simplon.ocar.model.Offer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OfferService {

    List<Offer> getOfferList();

    Optional<Offer> getOfferById(Long offerId);

    List<Offer> getFilteredOffer(String lowestBrand, String highestBrand,
                                 String lowestModel, String highestModel,
                                 Integer lowestPostCode, Integer highestPostCode,
                                 String lowestYear, String highestYear,
                                 String gearbox,
                                 Integer lowestPrice, Integer highestPrice);

    void addImageToOffer(Long offerId, Image imageToAdd);
}
