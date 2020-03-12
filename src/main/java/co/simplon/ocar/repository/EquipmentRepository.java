package co.simplon.ocar.repository;

import co.simplon.ocar.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

//    @Query("SELECT equipment FROM Equipment equipment JOIN equipment.cars cars where cars.id = :carToGetEquipment")
//    List<Equipment> findAllEquipmentByCar(Long carToGetEquipment);

}
