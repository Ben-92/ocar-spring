package co.simplon.ocar.service;

import co.simplon.ocar.model.Offer;
import co.simplon.ocar.repository.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    private OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository){
        this.offerRepository = offerRepository;
    }

    @Override
    public List<Offer> getOfferList(){
        return this.offerRepository.findAll();
    }

    @Override
    public List<Offer> getFilteredOffer(String brand, Integer lowestPrice, Integer highestPrice){
//        return this.offerRepository.findAllByPriceBetween(lowestPrice, highestPrice);
        return this.offerRepository.findAllByCarBrandAndPriceBetween(brand, lowestPrice, highestPrice);
    }

    @Override
    public Optional<Offer> getOfferById(Long offerId){
        return offerRepository.findById(offerId);
    }

}
