package co.simplon.ocar.service;

import co.simplon.ocar.exception.OfferNotFoundException;
import co.simplon.ocar.model.Equipment;
import co.simplon.ocar.model.Image;
import co.simplon.ocar.model.Offer;
import co.simplon.ocar.repository.EquipmentRepository;
import co.simplon.ocar.repository.ImageRepository;
import co.simplon.ocar.repository.OfferRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;

@Service
public class OfferServiceImpl implements OfferService {

    private OfferRepository offerRepository;
    private ImageRepository imageRepository;
    private EquipmentRepository equipmentRepository;

    public OfferServiceImpl(OfferRepository offerRepository,
                            ImageRepository imageRepository,
                            EquipmentRepository equipmentRepository){
        this.offerRepository = offerRepository;
        this.imageRepository = imageRepository;
        this.equipmentRepository = equipmentRepository;
    }


    /**
     * retrieving an Offer Page, giving specific criteria parameters
     * @param pageNumber    number of the Page to retrieve
     * @param pageSize      number of Offers per page
     * @param criteria      sort criteria
     * @param direction     direction of sorting
     * @return  the result Page if existing
     */
    @Override
    public Page<Offer> getOfferPage(Integer pageNumber, Integer pageSize, String criteria, String direction) {

        // If page number is not null then use it for paging, otherwise provide page 0
        int pNumber = (pageNumber != null) ? pageNumber : 0;
        // If page size is not null then use it for paging, otherwise use default 3 page size
        int pSize = (pageSize != null) ? pageSize : 3;

        // By default sort on offer date
        String sortingCriteria = "date";

        // retrieving fields labels from Offer model. If user criteria matches one, using it for sorting
        Field[] fields = Offer.class.getDeclaredFields();
        List<String> possibleCriteria = new ArrayList<>();
        for (Field field : fields) {
            possibleCriteria.add(field.getName().toLowerCase());
        }
        if (criteria != null && possibleCriteria.contains(criteria)) {
            sortingCriteria = criteria;
        }

        // By default sorting descending, otherwise, using user choice sort direction
        Sort.Direction sortingDirection = Sort.Direction.DESC;
        if (direction != null) {
            sortingDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        }

        return offerRepository.findAllBySaleNull(PageRequest.of(pNumber, pSize, Sort.by(sortingDirection, sortingCriteria)));
    }

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
     * @param lowestGearbox    gearbox min value searched for
     * @param highestGearbox   gearbox max value searched for
     * @param lowestPrice   Vehicle price min value searched for
     * @param highestPrice  Vehicle price max value searched for
     * @param pageNumber    number of the Page to retrieve
     * @param pageSize      number of Offers per page
     * @param criteria      sort criteria
     * @param direction     direction of sorting
     * @return  the result Page if existing
     */
    @Override
    public Page<Offer> getFilteredOffer(String lowestBrand, String highestBrand,
                                        String lowestModel, String highestModel,
                                        Integer lowestPostCode, Integer highestPostCode,
                                        String lowestYear, String highestYear,
                                        String lowestGearbox,
                                        String highestGearbox,
                                        Integer lowestPrice, Integer highestPrice,
                                        Integer pageNumber, Integer pageSize, String criteria, String direction) {

        // If lowest brand is not null then use it for requesting, otherwise provide space
        String lBrand = (lowestBrand != null) ? lowestBrand : " ";

        // If highest brand is not null then use it for requesting, otherwise provide "zzz"
        String hBrand = (highestBrand != null) ? highestBrand : "zzz";

        // If lowest model is not null then use it for requesting, otherwise provide space
        String lModel = (lowestModel != null) ? lowestModel : " ";

        // If highest model is not null then use it for requesting, otherwise provide "zzz"
        String hModel = (highestModel != null) ? highestModel : "zzz";

        // If lowest post code is not null then use it for paging, otherwise provide 0
        int lPostCode = (lowestPostCode != null) ? lowestPostCode : 0;

        // If highest post code is not null then use it for paging, otherwise provide 99999
        int hPostCode = (highestPostCode != null) ? highestPostCode : 99999;

        // If lowest year is not null then use it for requesting, otherwise provide "0"
        String lYear = (lowestYear != null) ? lowestYear : "0";

        // If highest year is not null then use it for requesting, otherwise provide ""
        String hYear = (highestYear != null) ? highestYear : "9999";

        // If lowest gearbox is not null then use it for requesting, otherwise provide space
        String lGearbox = (lowestGearbox != null) ? lowestGearbox : " ";

        // If highest brand is not null then use it for requesting, otherwise provide "zzz"
        String hGearbox = (highestGearbox != null) ? highestGearbox : "zzz";

        // If lowest price code is not null then use it for paging, otherwise provide 0
        int lPrice = (lowestPrice != null) ? lowestPrice : 0;

        // If highest price is not null then use it for paging, otherwise provide 999999999
        int hPrice = (highestPrice != null) ? highestPrice : 999999999;

        // If page number is not null then use it for paging, otherwise provide page 0
        int pNumber = (pageNumber != null) ? pageNumber : 0;
        // If page size is not null then use it for paging, otherwise use default 3 page size
        int pSize = (pageSize != null) ? pageSize : 3;

        // By default sort on offer date
        String sortingCriteria = "date";

        // retrieving fields labels from Offer model. If user criteria matches one, using it for sorting
        Field[] fields = Offer.class.getDeclaredFields();
        List<String> possibleCriteria = new ArrayList<>();
        for (Field field : fields) {
            possibleCriteria.add(field.getName().toLowerCase());
        }
        if (criteria != null && possibleCriteria.contains(criteria)) {
            sortingCriteria = criteria;
        }

        // By default sorting descending, otherwise, using user choice sort direction
        Sort.Direction sortingDirection = Sort.Direction.DESC;
        if (direction != null) {
            sortingDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        }

        return offerRepository.findAllByCarBrandBetweenAndCarModelBetweenAndPostalCodeBetweenAndYearBetweenAndGearboxBetweenAndPriceBetweenAndSaleNull
                (lBrand, hBrand,
                lModel, hModel,
                lPostCode, hPostCode,
                lYear, hYear,
                lGearbox, hGearbox,
                lPrice, hPrice,
                PageRequest.of(pNumber, pSize, Sort.by(sortingDirection, sortingCriteria)));
    }


    @Override
    public Optional<Offer> getOfferById(Long offerId){
        return offerRepository.findById(offerId);
    }

    /**
     * creating an Image for an Offer
     * @param offerId   Id of the Offer
     * @param imageToAdd    Image Object to Persist
     */
    @Override
    public void addImageToOffer(Long offerId, Image imageToAdd) throws OfferNotFoundException {
        Optional<Offer> offerOptional = offerRepository.findById(offerId);

        if (offerOptional.isPresent()){
            imageToAdd.setOffer(offerOptional.get());
            imageRepository.save(imageToAdd);
        } else {
            throw new OfferNotFoundException();
        }
    }


    /**
     * update equipment to a given offer
     * @param offerId id of the offer the equipment has to be updated
     * @param equipmentL list of Equipment that will be updated
     * @throws OfferNotFoundException
     */
    @Override
    public void updateEquipmentToOffer(Long offerId, List<Equipment> equipmentL) throws OfferNotFoundException {

        Optional<Offer> optionalOffer = offerRepository.findById(offerId);

        if (optionalOffer.isPresent()){

            //retrieving existing offer
            Offer existingOffer = optionalOffer.get();

            //creating offer object to update existing offer
            Offer offerToUpdate = new Offer();
            offerToUpdate.setId(existingOffer.getId());
            offerToUpdate.setDate(existingOffer.getDate());
            offerToUpdate.setPostalCode(existingOffer.getPostalCode());
            offerToUpdate.setCarBrand(existingOffer.getCarBrand());
            offerToUpdate.setCarModel(existingOffer.getCarModel());
            offerToUpdate.setYear(existingOffer.getYear());
            offerToUpdate.setDescription(existingOffer.getDescription());
            offerToUpdate.setFourWheelDrive(existingOffer.isFourWheelDrive());
            offerToUpdate.setGearbox(existingOffer.getGearbox());
            offerToUpdate.setOuterColor(existingOffer.getOuterColor());

            offerToUpdate.setPrice(existingOffer.getPrice());
            offerToUpdate.setUser(existingOffer.getUser());
            offerToUpdate.setImages(existingOffer.getImages());

            //initialize existing offer list of equipments
            existingOffer.getEquipments().clear();

            //the list of equipment of the updated offer is cleared too
            offerToUpdate.setEquipments(existingOffer.getEquipments());

            //only if at least one equipment has been checked
            if (! equipmentL.isEmpty()) {
                //loop on each equipment checked by the user
                for (Equipment equip : equipmentL) {

                    Optional<Equipment> optionalEquipment = equipmentRepository.findByLabel(equip.getLabel());
                    if (optionalEquipment.isPresent()) { //equipment exists in database

                        offerToUpdate.getEquipments().add(optionalEquipment.get());

                        offerRepository.save(offerToUpdate);

                    } else {
//                        equipment doesn't exists in database - for future evolution if adding equipment is possible in the front side
//                        adding controls here would be better as well

                        equipmentRepository.save(equip);
                        Optional<Equipment> optionalEquipmentJustSaved = equipmentRepository.findByLabel(equip.getLabel());

                        offerToUpdate.getEquipments().add(optionalEquipmentJustSaved.get());

                        offerRepository.save(offerToUpdate);
                    }
                }
            } else {
                offerRepository.save(offerToUpdate);
            }

        } else {
            throw new OfferNotFoundException();
        }

    }

    /**
     * delete an offer
     * @param idOfferToDelete id of the offer to delete
     * @return boolean true if offer deleted, false if no offer with this id present in database
     */
    @Override
    public boolean deleteOffer(Long idOfferToDelete) {

        Optional<Offer> offerToDelete = offerRepository.findById(idOfferToDelete);
        if (offerToDelete.isPresent()){
            offerRepository.deleteById(idOfferToDelete);
            return true;
        } else {
            return false;
        }
    }

    /**
     * update an offer
     * @param idOfferToUpdate id of the offer to update
     * @param offerToUpdate offer object with attributes to update
     * @return offer updated, exception if offer not present in database
     * @throws OfferNotFoundException
     */
    @Override
    public Offer updateOffer (Long idOfferToUpdate, Offer offerToUpdate) throws OfferNotFoundException {
        boolean isOfferExist = offerRepository.existsById(idOfferToUpdate);

        if (isOfferExist && offerToUpdate.getId().equals(idOfferToUpdate)) {
            return offerRepository.save(offerToUpdate);
        } else {
            throw new OfferNotFoundException();
        }
    }
}

