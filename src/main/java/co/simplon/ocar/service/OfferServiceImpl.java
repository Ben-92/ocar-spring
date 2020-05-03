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
     * @param gearbox       gearbox value searched for
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

    @Override
    public void addEquipmentToOffer(Long offerId, List<Equipment> equipmentL) {

        Optional<Offer> optionalOffer = offerRepository.findById(offerId);

        if (optionalOffer.isPresent()){

            Offer existingOffer = optionalOffer.get();

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

            offerToUpdate.setEquipments(existingOffer.getEquipments());

            System.out.println("equipment en base: ");
            for (Equipment equipInDb : existingOffer.getEquipments()){
                System.out.println(equipInDb);
            }

            System.out.println("entrée dans boucle equipement reçu");

            for (Equipment equip : equipmentL){
                Optional<Equipment> optionalEquipment = equipmentRepository.findByLabel(equip.getLabel());
                System.out.println("equipement reçu: " + equip.getLabel());
                if (optionalEquipment.isPresent()){ //l'equipement existe en base   Offer offerToAddToSet = new Offer ();
                    // option 1 : dans le sens : ajouter un equipement à l'offre - Ajouter l'equipement dans le Set<equipement> de l'Offer
                    System.out.println("equipment is present in db equipment");


//                    offerToUpdate.setEquipments(existingOffer.getEquipments());

                    System.out.println("optionalEquipment.get(): " + optionalEquipment.get());

                    offerToUpdate.getEquipments().add(optionalEquipment.get());

                    System.out.println("offerToUpdate : " + offerToUpdate);

                    offerRepository.save(offerToUpdate);

                } else { // l'equipement n'existe pas en base equipment

                    System.out.println("equipment not present in db equipment");

//                    offerToUpdate.setEquipments(existingOffer.getEquipments());

                    equipmentRepository.save(equip);
                    Optional<Equipment> optionalEquipmentJustSaved = equipmentRepository.findByLabel(equip.getLabel());

//                    System.out.println("equip: " + equip);
//                    ajouter equip sans le save dans equipment d'abord ne fonctionne pas : il créee bien la relation, mais alimente type et label à null dans la base Equipment
//                    offerToUpdate.getEquipments().add(equip);

                    System.out.println("optionalEquipmentJustSaved.get(): " + optionalEquipmentJustSaved.get());
                    offerToUpdate.getEquipments().add(optionalEquipmentJustSaved.get());

                    System.out.println("offerToUpdate : " + offerToUpdate);

                    offerRepository.save(offerToUpdate);
                }
            }
        }
    }

    @Override
    public void updateEquipmentToOffer(Long offerId, List<Equipment> equipmentL) {

        System.out.println("updateEquipmentToOffer");
        Optional<Offer> optionalOffer = offerRepository.findById(offerId);

        if (optionalOffer.isPresent()){

            Offer existingOffer = optionalOffer.get();

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

            existingOffer.getEquipments().clear();
            offerToUpdate.setEquipments(existingOffer.getEquipments());

//            System.out.println("liste des équipements: ");
//            for (Equipment equip : equipmentL){
//                System.out.println(equip);
//            }
            if (! equipmentL.isEmpty()) {

                for (Equipment equip : equipmentL) {

                    Optional<Equipment> optionalEquipment = equipmentRepository.findByLabel(equip.getLabel());
                    if (optionalEquipment.isPresent()) { //l'equipement existe en base   Offer offerToAddToSet = new Offer ();

                        offerToUpdate.getEquipments().add(optionalEquipment.get());

                        offerRepository.save(offerToUpdate);

                    } else { // l'equipement n'existe pas en base equipment

                        equipmentRepository.save(equip);
                        Optional<Equipment> optionalEquipmentJustSaved = equipmentRepository.findByLabel(equip.getLabel());

//                    offerToUpdate.getEquipments().add(equip);
                        offerToUpdate.getEquipments().add(optionalEquipmentJustSaved.get());

                        offerRepository.save(offerToUpdate);
                    }
                }
            } else {
                offerRepository.save(offerToUpdate);
            }

        }

    }

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

// récupérer le set d'offers de l'equipment
// option 2 : dans le sens : ajouter une offre à l'équipement : ça ne fonctionne pas car c'est l'offer qui est maitre
//alimenter dans le set d'offers de l'objet Equipment, l'Offer en cours
//                        Set<Offer> offerset = new HashSet<>();
//                        offerset.add(existingOffer);
//                        equip.setOffers(offerset);
//                        //sauver l'equipement
//                        equipmentRepository.save(equip);

//                    Equipment equipmentToAdd = new Equipment();
//                    equipmentToAdd.setId(optionalEquipment.get().getId());
//                    equipmentToAdd.setLabel(optionalEquipment.get().getLabel());
//                    equipmentToAdd.setType(optionalEquipment.get().getType());

// option 1 : dans le sens : ajouter un equipement à l'offre : ça fonctionne car l'offer est maitre dans la relation manytomany
//                    Set<Equipment> equipmentSet = new HashSet<>();
//                    equipmentSet.add(equip);
//
//                        offerToUpdate.setEquipments(equipmentSet);
//                        offerRepository.save(offerToUpdate);

//                if (existingOffer.getEquipments().contains(equip)){
//                }
