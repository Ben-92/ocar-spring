package co.simplon.ocar.repository;

import co.simplon.ocar.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    /**
     *
     * @param userNameToSearch  userName of the client to search for
     * @param emailToSearch     email of the client to search for
     * @return  a Client Optional type
     */
    Optional<Client> findClientByUserNameAndEmail(String userNameToSearch, String emailToSearch);
}
