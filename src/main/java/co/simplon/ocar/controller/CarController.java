//package co.simplon.ocar.controller;
//
//import co.simplon.ocar.model.Car;
//import co.simplon.ocar.service.CarService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/cars")
//@CrossOrigin("*")
//public class CarController {
//
//    private CarService carService;
//
//    public CarController (CarService carService){
//        this.carService = carService;
//    }
//
//    @GetMapping("/{carId}")
//    public ResponseEntity<Car> getCarById(@PathVariable Long carId){
//
//        Optional<Car> car = carService.getCarById(carId);
//
//        if (car.isPresent()){
//            return ResponseEntity.ok(car.get());
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//}
