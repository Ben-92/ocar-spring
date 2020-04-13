package co.simplon.ocar.service;

import co.simplon.ocar.model.Image;
import co.simplon.ocar.model.Offer;
import co.simplon.ocar.repository.ImageRepository;
import co.simplon.ocar.repository.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    private OfferRepository offerRepository;
    private ImageRepository imageRepository;

    public OfferServiceImpl(OfferRepository offerRepository, ImageRepository imageRepository){
        this.offerRepository = offerRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public List<Offer> getOfferList(){
        return this.offerRepository.findAll();
    }

    @Override
    public List<Offer> getFilteredOffer(String lowestBrand, String highestBrand,
                                        String lowestModel, String highestModel,
                                        Integer lowestPostCode, Integer highestPostCode,
                                        String lowestYear, String highestYear,
                                        String gearbox,
                                        Integer lowestPrice, Integer highestPrice){

        return this.offerRepository.findAllByCarBrandBetweenAndCarModelBetweenAndPostalCodeBetweenAndYearBetweenAndGearboxAndPriceBetween(
                lowestBrand, highestBrand,
                lowestModel, highestModel,
                lowestPostCode, highestPostCode,
                lowestYear, highestYear,
                gearbox,
                lowestPrice, highestPrice);
    }

    @Override
    public Optional<Offer> getOfferById(Long offerId){
        return offerRepository.findById(offerId);
    }

    @Override
    public void addImageToOffer(Long offerId, Image imageToAdd) {
        Optional<Offer> offerOptional = offerRepository.findById(offerId);

        if (offerOptional.isPresent()){
            imageToAdd.setOffer(offerOptional.get());
            imageRepository.save(imageToAdd);
        } else {
            System.out.println("Offer non trouvée en base");
            //ajouter ici une erreur, lancer une exception, à catcher dans le controller
        }


    }

}
