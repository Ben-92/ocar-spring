package co.simplon.ocar.controller;

import co.simplon.ocar.model.Equipment;
import co.simplon.ocar.service.EquipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipments")
@CrossOrigin("*")
public class EquipmentController {

    private EquipmentService equipmentService;

    public EquipmentController (EquipmentService equipmentService){
        this.equipmentService = equipmentService;
    }

//    @GetMapping("/getequipmentbycar")
//    public List<Equipment> getEquipmentOfACar(@RequestParam Long carToGetEquipment){
//        return equipmentService.getAllEquipmentByCarId(carToGetEquipment);
//    }
}
