package co.simplon.ocar.repository;

import co.simplon.ocar.model.Offer;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    List<Offer> findAllByCarBrandBetweenAndCarModelBetweenAndPostalCodeBetweenAndYearBetweenAndGearboxAndPriceBetween(
            String lowestBrand, String highestBrand,
            String lowestModel, String highestModel,
            Integer lowestPostCode, Integer highestPostCode,
            String lowestYear, String highestYear,
            String gearbox,
            Integer lowestPrice, Integer highestPrice
    );

}
