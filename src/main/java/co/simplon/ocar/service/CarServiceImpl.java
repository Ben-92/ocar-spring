//package co.simplon.ocar.service;
//
//import co.simplon.ocar.model.Car;
//import co.simplon.ocar.repository.CarRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class CarServiceImpl implements CarService {
//
//    private CarRepository carRepository;
//
//    public CarServiceImpl(CarRepository carRepository){
//        this.carRepository = carRepository;
//    }
//
//    @Override
//    public Optional<Car> getCarById(Long carId){
//        return carRepository.findById(carId);
//    }
//
//}
