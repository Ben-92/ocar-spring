package co.simplon.ocar.service;

import co.simplon.ocar.model.Image;
import co.simplon.ocar.model.Offer;
import co.simplon.ocar.repository.ImageRepository;
import co.simplon.ocar.repository.OfferRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
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

//    @Override
//    public List<Offer> getOfferList(){
//        return this.offerRepository.findAll();
//    }

    @Override
    public Page<Offer> getOfferList(Integer pageNumber, Integer pageSize, String criteria, String direction) {
        System.out.println("pageNumber: " + pageNumber);
        System.out.println("pageSize: " + pageSize);
        System.out.println("criteria: " + criteria);
        System.out.println("direction: " + direction);
        // If page number is not null then use it for paging, otherwise provide page 0
        int pNumber = (pageNumber != null) ? pageNumber : 0;
        // If page size is not null then use it for paging, otherwise use default 50 page size
        int pSize = (pageSize != null) ? pageSize : 3;

        // By default sort on aliment name
        String sortingCriteria = "date";

        // If sorting criteria matches an aliment field name, then use it for sorting
        Field[] fields = Offer.class.getDeclaredFields();
        List<String> possibleCriteria = new ArrayList<>();
        for (Field field : fields) {
            possibleCriteria.add(field.getName().toLowerCase());
        }
        if (criteria != null && possibleCriteria.contains(criteria)) {
            sortingCriteria = criteria;
        }

        // By default sorting ascending, but if user explicitely choose desc, then sort descending
        Sort.Direction sortingDirection = Sort.Direction.ASC;
        if (direction != null) {
            sortingDirection = direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        }

        return offerRepository.findAll(PageRequest.of(pNumber, pSize, Sort.by(sortingDirection, sortingCriteria)));
    }

    @Override
    public Page<Offer> getFilteredOffer(String lowestBrand, String highestBrand,
                                        String lowestModel, String highestModel,
                                        Integer lowestPostCode, Integer highestPostCode,
                                        String lowestYear, String highestYear,
                                        String gearbox,
                                        Integer lowestPrice, Integer highestPrice,
                                        Integer pageNumber, Integer pageSize, String criteria, String direction) {

        // If page number is not null then use it for paging, otherwise provide page 0
        int pNumber = (pageNumber != null) ? pageNumber : 0;
        // If page size is not null then use it for paging, otherwise use default 50 page size
        int pSize = (pageSize != null) ? pageSize : 3;

        // By default sort on aliment name
        String sortingCriteria = "date";

        // If sorting criteria matches an aliment field name, then use it for sorting
        Field[] fields = Offer.class.getDeclaredFields();
        List<String> possibleCriteria = new ArrayList<>();
        for (Field field : fields) {
            possibleCriteria.add(field.getName().toLowerCase());
        }
        if (criteria != null && possibleCriteria.contains(criteria)) {
            sortingCriteria = criteria;
        }

        // By default sorting ascending, but if user explicitely choose desc, then sort descending
        Sort.Direction sortingDirection = Sort.Direction.ASC;
        if (direction != null) {
            sortingDirection = direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        }

        return offerRepository.findAllByCarBrandBetweenAndCarModelBetweenAndPostalCodeBetweenAndYearBetweenAndGearboxAndPriceBetween
                (lowestBrand, highestBrand,
                lowestModel, highestModel,
                lowestPostCode, highestPostCode,
                lowestYear, highestYear,
                gearbox,
                lowestPrice, highestPrice,
                PageRequest.of(pNumber, pSize, Sort.by(sortingDirection, sortingCriteria)));
    }

//    @Override
//    public List<Offer> getFilteredOffer(String lowestBrand, String highestBrand,
//                                        String lowestModel, String highestModel,
//                                        Integer lowestPostCode, Integer highestPostCode,
//                                        String lowestYear, String highestYear,
//                                        String gearbox,
//                                        Integer lowestPrice, Integer highestPrice){
//
//        return this.offerRepository.findAllByCarBrandBetweenAndCarModelBetweenAndPostalCodeBetweenAndYearBetweenAndGearboxAndPriceBetween(
//                lowestBrand, highestBrand,
//                lowestModel, highestModel,
//                lowestPostCode, highestPostCode,
//                lowestYear, highestYear,
//                gearbox,
//                lowestPrice, highestPrice);
//    }

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
