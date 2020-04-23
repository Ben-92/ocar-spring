package co.simplon.ocar.service;

import co.simplon.ocar.model.Offer;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    /**
     * creating an Offer to a User
     * @param userId        Id of the User
     * @param offerToAdd    Offer object to persist
     * @return              the Offer created
     */
    Offer createOfferToUser(Long userId, Offer offerToAdd);
}
