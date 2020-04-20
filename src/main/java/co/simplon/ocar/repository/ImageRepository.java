package co.simplon.ocar.repository;

import co.simplon.ocar.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    /**
     * retrieving an Image object, giving its name
     * @param name  name of the image to retrieve
     * @return  an Image Optional type
     */
    Optional<Image> findByName (String name);
}
