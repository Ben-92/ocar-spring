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

    @GetMapping
    public List<Equipment> getEquipments() {
        return equipmentService.getEquipments();
    }

}
