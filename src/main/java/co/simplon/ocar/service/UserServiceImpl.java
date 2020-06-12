package co.simplon.ocar.service;

import co.simplon.ocar.exception.OfferNotFoundException;
import co.simplon.ocar.exception.UserNotFoundException;
import co.simplon.ocar.model.Offer;
import co.simplon.ocar.model.Sale;
import co.simplon.ocar.model.User;
import co.simplon.ocar.repository.OfferRepository;
import co.simplon.ocar.repository.SaleRepository;
import co.simplon.ocar.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private OfferRepository offerRepository;
    private SaleRepository saleRepository;

    public UserServiceImpl(UserRepository userRepository,
                           OfferRepository offerRepository,
                           SaleRepository saleRepository) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.saleRepository = saleRepository;
    }


    @Override
    public Optional<User> getUserById(Long userId){
        return userRepository.findById(userId);
    }

    /**
     * creating an Offer to a User
     * @param userId        Id of the User
     * @param offerToCreate Offer object to persist
     * @return              the Offer created
     */
    @Override
    public Offer createOfferToUser(Long userId, Offer offerToCreate) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            offerToCreate.setUser(user.get());
            return offerRepository.save(offerToCreate);
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public Sale createSaleToUser(Long userId, Sale saleToCreate, Long offerId) throws UserNotFoundException, OfferNotFoundException {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            saleToCreate.setUser(user.get());

            Optional<Offer> offer = offerRepository.findById(offerId);
            if (offer.isPresent()){
                saleToCreate.setOffer(offer.get());
                return saleRepository.save(saleToCreate);
            } else {
                throw new OfferNotFoundException();
            }
        } else {
            throw new UserNotFoundException();
        }
    }

}
