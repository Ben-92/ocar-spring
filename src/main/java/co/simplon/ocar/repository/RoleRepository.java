package co.simplon.ocar.repository;

import co.simplon.ocar.model.ERole;
import co.simplon.ocar.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * find a role given its name
     * @param name name of the role to find
     * @return an optional with Role type
     */
    Optional<Role> findByName(ERole name);
}
