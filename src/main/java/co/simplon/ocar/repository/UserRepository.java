package co.simplon.ocar.repository;

import co.simplon.ocar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * find a user given its name
     * @param username name of the user to find
     * @return an optional with User type
     */
    Optional<User> findByUsername(String username);

    /**
     * testing if a user name exists, given its name
     * @param username name of the user to test
     * @return boolean true if User exists, false if not
     */
    Boolean existsByUsername(String username);

    /**
     * testing if a user name exists, given its email
     * @param email email of the user to test
     * @return boolean true if User exists, false if not
     */
    Boolean existsByEmail(String email);
}
