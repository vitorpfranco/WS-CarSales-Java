package com.api.WSCarSales.Services;


import com.api.WSCarSales.Dtos.CarDto;
import com.api.WSCarSales.Exeptions.ResourceNotFoundException;
import com.api.WSCarSales.Models.Car;
import com.api.WSCarSales.Models.Model;
import com.api.WSCarSales.Repositories.CarRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    ModelService modelService;

    public Car setModel(CarDto carDto) {
        Model model= modelService.getModelById(carDto.getModelo_id());
        var car = new Car();
        BeanUtils.copyProperties(carDto,car,"modelo_id");
        car.setModelo(model);
     return car;
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public Car getCarById(Integer id) {
        Optional<Car> car= carRepository.findById(id);
        return car.orElseThrow(()-> new ResourceNotFoundException("Car not found for ID: "+id));
    }

    public void deleteCar(Integer id){
         carRepository.deleteById(id);
    }

    public Car updateCar(Integer id, Car car) {
        Car oldCar= getCarById(id);
        car.setId(oldCar.getId());
        car.setTimestamp_cadastro(oldCar.getTimestamp_cadastro());
        return saveCar(car);
    }
}
