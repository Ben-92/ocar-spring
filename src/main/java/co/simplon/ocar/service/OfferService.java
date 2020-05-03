package co.simplon.ocar.service;

import co.simplon.ocar.model.Equipment;
import co.simplon.ocar.model.Image;
import co.simplon.ocar.model.Offer;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OfferService {

    /**
     * retrieving an Offer Page, giving specific criteria parameters
     * @param pageNumber    number of the Page to retrieve
     * @param pageSize      number of Offers per page
     * @param criteria      sort criteria
     * @param direction     direction of sorting
     * @return  the result Page if existing
     */
    Page<Offer> getOfferPage(Integer pageNumber, Integer pageSize, String criteria, String direction);

    Optional<Offer> getOfferById(Long offerId);


    /**
     * retrieving a multi-criterias filtered Page
     * @param lowestBrand   Brand min value searched for
     * @param highestBrand  Brand max value searched for
     * @param lowestModel   Model min value searched for
     * @param highestModel  Model max value searched for
     * @param lowestPostCode    PostCode min value searched for
     * @param highestPostCode   PostCode max value searched for
     * @param lowestYear    Vehicle Year min value searched for
     * @param highestYear   Vehicle Year max value searched for
     * @param gearbox       gearbox value searched fo
     * @param lowestPrice   Vehicle price min value searched for
     * @param highestPrice  Vehicle price max value searched for
     * @param pageNumber    number of the Page to retrieve
     * @param pageSize      number of Offers per page
     * @param criteria      sort criteria
     * @param direction     direction of sorting
     * @return  the result Page if existing
     */
    Page<Offer> getFilteredOffer(String lowestBrand, String highestBrand,
                                 String lowestModel, String highestModel,
                                 Integer lowestPostCode, Integer highestPostCode,
                                 String lowestYear, String highestYear,
                                 String gearbox,
                                 Integer lowestPrice, Integer highestPrice,
                                 Integer pageNumber, Integer pageSize, String criteria, String direction);



    /**
     * creating an Image for an Offer
     * @param offerId   Id of the Offer
     * @param imageToAdd    Image Object to Persist
     */
    void addImageToOffer(Long offerId, Image imageToAdd);

    void addEquipmentToOffer(Long offerId, List<Equipment> equipmentL);

    void updateEquipmentToOffer(Long offerId, List<Equipment> equipmentL);

    boolean deleteOffer (Long idOfferToDelete);

    Offer updateOffer (Long idOfferToUpdate, Offer offerToUpdate);
}
