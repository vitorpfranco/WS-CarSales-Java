package com.api.WSCarSales.Controllers;

import com.api.WSCarSales.Dtos.CarDto;
import com.api.WSCarSales.Enums.FuelType;
import com.api.WSCarSales.Models.Car;
import com.api.WSCarSales.Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("cars")
public class CarController {
    @Autowired
    CarService carService;

    @PostMapping
    public ResponseEntity<Car> saveCar(@RequestBody @Valid CarDto carDto){
        Car car = carService.setModel(carDto);
        car.setTimestamp_cadastro(Instant.now().getEpochSecond());
        car.setCombustivel(FuelType.toEnum(carDto.getCombustivel()));
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.saveCar(car));
    }

    @GetMapping
    public ResponseEntity<List<CarDto>> getCars(){
        List<Car> carList= carService.getCars();
        List<CarDto> carListDto = carList.stream().map(obj -> new CarDto(obj)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(carListDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(new CarDto(carService.getCarById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Integer id){
        Car car = carService.getCarById(id);
        carService.deleteCar(id);
        return ResponseEntity.status(HttpStatus.OK).body("Car deleted");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Integer id, @RequestBody @Valid CarDto carDto ){
        Car car = carService.setModel(carDto);
        return ResponseEntity.status(HttpStatus.OK).body(carService.updateCar(id,car));
    }
}
