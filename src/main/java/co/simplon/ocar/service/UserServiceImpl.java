package co.simplon.ocar.service;

import co.simplon.ocar.model.Offer;
import co.simplon.ocar.model.User;
import co.simplon.ocar.repository.OfferRepository;
import co.simplon.ocar.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private OfferRepository offerRepository;

    public UserServiceImpl(UserRepository userRepository, OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
    }

    /**
     * creating an Offer to a User
     * @param userId        Id of the User
     * @param offerToCreate Offer object to persist
     * @return              the Offer created
     */
    @Override
    public Offer createOfferToUser(Long userId, Offer offerToCreate) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            offerToCreate.setUser(user.get());
            return offerRepository.save(offerToCreate);
        } else {
            // On devrait renvoyer une exception
            return null;
        }
    }
}
