package co.simplon.ocar.service;

import co.simplon.ocar.model.Offer;
import co.simplon.ocar.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {



    Optional<User> getUserById(Long userId);

    /**
     * creating an Offer to a User
     * @param userId        Id of the User
     * @param offerToAdd    Offer object to persist
     * @return              the Offer created
     */
    Offer createOfferToUser(Long userId, Offer offerToAdd);

}
