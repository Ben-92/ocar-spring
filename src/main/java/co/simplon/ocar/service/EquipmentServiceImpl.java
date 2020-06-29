package co.simplon.ocar.service;

import co.simplon.ocar.model.Equipment;
import co.simplon.ocar.repository.EquipmentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService{

    private EquipmentRepository equipmentRepository;

    public EquipmentServiceImpl (EquipmentRepository equipmentRepository){
        this.equipmentRepository = equipmentRepository;
    }

    /**
     * retrieve list of all equipments in database
     * @return list of Equipment objects
     */
    @Override
    public List<Equipment> getEquipments() {
        return equipmentRepository.findAll(Sort.by(Sort.Order.asc("type")));
    }

}
