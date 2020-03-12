package co.simplon.ocar.repository;

import co.simplon.ocar.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

//    List<Offer> findAllByPriceBetween(Integer lowestPrice, Integer highestPrice);
    List<Offer> findAllByCarBrandAndPriceBetween(String brand, Integer lowestPrice, Integer highestPrice);
}
