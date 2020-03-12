package co.simplon.ocar.service;

import co.simplon.ocar.model.Offer;
import co.simplon.ocar.model.Seller;
import co.simplon.ocar.repository.OfferRepository;
import co.simplon.ocar.repository.SellerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService{

    private SellerRepository sellerRepository;
    private OfferRepository offerRepository;

    public SellerServiceImpl(SellerRepository sellerRepository,
                             OfferRepository offerRepository){
        this.sellerRepository = sellerRepository;
        this.offerRepository = offerRepository;
    }

    @Override
    public Offer createOffer(Long sellerId, Offer offerToCreate) {
        Optional<Seller> seller = sellerRepository.findById(sellerId);

        if (seller.isPresent()) {
            offerToCreate.setSeller(seller.get());
            return offerRepository.save(offerToCreate);
        } else {
            // On devrait renvoyer une exception
            return null;
        }
    }
}
