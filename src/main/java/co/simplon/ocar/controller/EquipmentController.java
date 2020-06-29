package co.simplon.ocar.controller;


import co.simplon.ocar.model.Equipment;
import co.simplon.ocar.service.EquipmentService;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


@RestController
@RequestMapping("/api/equipments")
@CrossOrigin("*")
@ApiIgnore
public class EquipmentController {

    private EquipmentService equipmentService;

    public EquipmentController (EquipmentService equipmentService){
        this.equipmentService = equipmentService;
    }

    /**
     * get list of equipment references
     * @return List of Equipment objects
     */
    @GetMapping
    public List<Equipment> getEquipments() {
        return equipmentService.getEquipments();
    }

}
