package co.simplon.ocar.service;

import co.simplon.ocar.model.Equipment;
import co.simplon.ocar.repository.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService{

    private EquipmentRepository equipmentRepository;

    public EquipmentServiceImpl (EquipmentRepository equipmentRepository){
        this.equipmentRepository = equipmentRepository;
    }

//    @Override
//    public List<Equipment> getAllEquipmentByCarId(Long carToGetEquipment){
//
//        return  equipmentRepository.findAllEquipmentByCar(carToGetEquipment);
//    }
}
