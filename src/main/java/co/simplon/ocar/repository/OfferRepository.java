package co.simplon.ocar.repository;

import co.simplon.ocar.model.Offer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    /**
     *
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
     * @param page  Pageable object
     * @return an Offer Page if existing
     */
    Page<Offer> findAllByCarBrandBetweenAndCarModelBetweenAndPostalCodeBetweenAndYearBetweenAndGearboxAndPriceBetween(
            String lowestBrand, String highestBrand,
            String lowestModel, String highestModel,
            Integer lowestPostCode, Integer highestPostCode,
            String lowestYear, String highestYear,
            String gearbox,
            Integer lowestPrice, Integer highestPrice,
            Pageable page
    );



}
